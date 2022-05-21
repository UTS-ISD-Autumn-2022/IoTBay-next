package au.edu.uts.isd.iotbay.models.dao;

import au.edu.uts.isd.iotbay.models.data.Customer;
import au.edu.uts.isd.iotbay.models.data.User;
import au.edu.uts.isd.iotbay.models.forms.EditCustomerForm;
import au.edu.uts.isd.iotbay.models.forms.RegisterForm;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.val;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class UserManager {
    final String ADMIN = "ROLE_ADMIN";
    final String CUSTOMER = "ROLE_CUSTOMER";
    final String EMPLOYEE = "ROLE_EMPLOYEE";

    @Getter
    final String REGISTER_ACTION = "REGISTER";

    @Getter
    final String LOGIN_ACTION = "LOGIN";

    @Getter
    final String EDIT_ACTION = "EDIT";

    final Logger logger = LoggerFactory.getLogger(UserManager.class);

    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;

    public UserManager(JdbcTemplate l_jdbcTemplate, PasswordEncoder l_passwordEncoder) {
        jdbcTemplate = l_jdbcTemplate;
        passwordEncoder = l_passwordEncoder;
    }

    public Customer registerCustomer(RegisterForm registerForm) throws Exception {
        if (!registerForm.getPassword().equals(registerForm.getPasswordVerification())) {
            logger.error("User tried to enter non matching passwords");
            throw new Exception("Passwords do not match!");
        }

        val user = new User(registerForm);
        val customer = new Customer(user);

        try {
            createUserIdentity(user.getUsername(), registerForm.getPassword());
            addUserToCustomerAuthority(user.getUsername());

            createUserInformation(
                    user.getId(),
                    user.getUsername(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail());

            createCustomer(customer.getId(), user.getId());
        } catch (Exception e) {
            logger.error(e.toString());
            logger.error(e.getMessage());
            throw new Exception("Registration Error!");
        }

        logPersist(user.getUsername(), REGISTER_ACTION);

        return customer;
    }

    public Customer fetchCustomerById(final UUID id) {
        logger.info("Fetching customer by id");
        val fetchCustomerQuery = "SELECT user_id, email, first_name, last_name FROM customers AS C INNER JOIN user_information AS UI ON C.user_id = UI.id WHERE C.id = ?";

        return jdbcTemplate.queryForObject(fetchCustomerQuery, (rs, _rn) -> {
            val user = new User(UUID.fromString(rs.getString("user_id")));
            user.setEmail(rs.getString("email"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));

            val customer = new Customer(id);
            customer.setUserInformation(user);

            return customer;
        }, id);
    }

    public Customer fetchCustomerByUsername(final String username) {
        logger.info("Fetching customer details");
        val fetchCustomerQuery = "SELECT C.id, user_id, email, first_name, last_name FROM customers AS C INNER JOIN user_information AS UI ON C.user_id = UI.id WHERE username = ?";

        return jdbcTemplate.queryForObject(fetchCustomerQuery, (rs, _rn) -> {
            val user = new User(UUID.fromString(rs.getString("user_id")));
            user.setUsername(username);
            user.setEmail(rs.getString("email"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));

            val customer = new Customer(UUID.fromString(rs.getString("id")));
            customer.setUserInformation(user);

            return customer;
        }, username);
    }

    public User fetchUserInformationByUsername(final String username) {
        logger.info("Fetching user details");

        val fetchUserQuery = "SELECT * FROM user_information WHERE username = ?";
        return jdbcTemplate.queryForObject(fetchUserQuery, (rs, _rc) -> {
            val user = new User(UUID.fromString(rs.getString("id")));
            user.setUsername(username);
            user.setEmail(rs.getString("email"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));

            return user;
        }, username);
    }

    public User updateUserInformation(final UUID id, final EditCustomerForm form) throws SQLException {
        logger.info("Editing User Details");

        val user = new User(id);
        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());

        val updateUserQuery = "UPDATE user_information " +
                "SET " +
                "first_name = ?," +
                "last_name = ?," +
                "email = ?" +
                "WHERE id = ?";

        jdbcTemplate.update(updateUserQuery, user.getFirstName(), user.getLastName(), user.getEmail(), user.getId());

        return user;
    }

    private Customer mapCustomerDetails(UUID id, ResultSet rs, User user) throws SQLException {
        user.setEmail(rs.getString("email"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));

        val customer = new Customer(id);
        customer.setUserInformation(user);

        return customer;
    }

    private void createUserIdentity(final String username, final String rawPassword) throws Exception {
        logger.info("Creating new user with username " + username);

        val createUserQuery = "INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)";
        jdbcTemplate.update(createUserQuery, username, passwordEncoder.encode(rawPassword), true);
    }

    private void addUserToCustomerAuthority(final String username) throws Exception {
        logger.info("Adding user " + username + "to Customer Authority");

        val createAuthorityQuery = "INSERT INTO authorities VALUES (?, ?)";
        jdbcTemplate.update(createAuthorityQuery, username, CUSTOMER);
    }

    private void createUserInformation(final UUID id, final String username, final String firstName,
            final String lastName, final String email) throws Exception {

        logger.info("Creating user information for " + username);

        val createUserInformationQuery = "INSERT INTO user_information (id, username, first_name, last_name, email)"
                + "VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                createUserInformationQuery,
                id,
                username,
                firstName,
                lastName,
                email);
    }

    private void createCustomer(final UUID id, final UUID userId) throws Exception {
        logger.info("Creating customer table");

        val createCustomerQuery = "INSERT INTO customers (id, user_id) VALUES (?, ?)";
        jdbcTemplate.update(createCustomerQuery, id, userId);
    }

    public void logPersist(final String username, final String action) throws SQLException {
        logger.info("Logging action " + action + "by user " + username);

        val createLogQuery = "INSERT INTO auth_log (id, username, log_action) VALUES (?, ?, ?)";
        jdbcTemplate.update(createLogQuery, UUID.randomUUID(), username, action);
    }
}