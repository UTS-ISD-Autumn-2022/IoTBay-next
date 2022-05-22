package au.edu.uts.isd.iotbay.models.dao;

import au.edu.uts.isd.iotbay.models.data.Customer;
import au.edu.uts.isd.iotbay.models.data.User;
import au.edu.uts.isd.iotbay.models.forms.EditCustomerForm;
import au.edu.uts.isd.iotbay.models.forms.RegisterForm;
import au.edu.uts.isd.iotbay.models.forms.UserForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.val;

import java.util.Locale;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * User Manager binds java to postgres sql database
 */
@Component
public class UserManager {
    @Getter
    final String adminRole = "ROLE_ADMIN";

    @Getter
    final String customerRole = "ROLE_CUSTOMER";

    @Getter
    final String employeeRole = "ROLE_EMPLOYEE";

    @Getter
    final String registerAction = "REGISTER";

    @Getter
    final String loginAction = "LOGIN";

    @Getter
    final String editAction = "EDIT";

    final Logger logger = LoggerFactory.getLogger(UserManager.class);

    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;

    public UserManager(JdbcTemplate l_jdbcTemplate, PasswordEncoder l_passwordEncoder) {
        jdbcTemplate = l_jdbcTemplate;
        passwordEncoder = l_passwordEncoder;
    }

    /**
     * Register a new customer
     * 
     * @param registerForm A new registration form object
     * @return a newly created sql customer
     * @throws Exception fails if data is invalid or if it cannot connect to
     *                   database
     */
    public Customer registerCustomer(RegisterForm registerForm) throws Exception {
        if (!registerForm.getPassword().equals(registerForm.getPasswordVerification())) {
            logger.error("User tried to enter non matching passwords");
            throw new Exception("Passwords do not match!");
        }

        val user = new User(registerForm);
        val customer = new Customer(user);

        try {
            createUserIdentity(user.getUsername(), registerForm.getPassword());
            addUserToCustomerRole(user.getUsername());

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

        logPersist(user.getUsername(), registerAction);

        return customer;
    }

    /**
     * Get a customer by their UUID
     * 
     * @param id a unique identifier of a customer
     * @return Customer with UUID id
     */
    public Customer fetchCustomerById(final UUID id) throws DataAccessException {
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

    /**
     * Get a customer by their username
     * 
     * @param username a customers username/login credential
     * @return Customer with a username of the input username
     * @throws DataAccessException SQL Exception in case of failure
     */
    public Customer fetchCustomerByUsername(final String username) throws DataAccessException {
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

    public User createUser(final UserForm userForm) throws DataAccessException {
        logger.info("Creating new user {}", userForm.getUsername());

        val user = new User(userForm);
        createUserIdentity(userForm.getUsername(), passwordEncoder.encode(userForm.getPassword()));
        createUserInformation(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(),
                user.getEmail());

        return user;
    }

    public void addUserToCustomerRole(final String username) throws DataAccessException {
        addUserToRole(username, customerRole);
    }

    public void addUserToEmployeeRole(final String username) throws DataAccessException {
        addUserToRole(username, employeeRole);
    }

    public void addUserToAdminRole(final String username) throws DataAccessException {
        addUserToRole(username, adminRole);
    }

    /**
     * Get a users information by their username
     * 
     * @param username a users username credential
     * @return A user with username
     * @throws DataAccessException SQL Exception with data access information
     */
    public User fetchUserByUsername(final String username) throws DataAccessException {
        logger.info("Fetching user details by username: {}", username);

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

    /**
     * Fetch a user by their uuid
     * 
     * @param id a uuid assigned to the user, readonly
     * @return a user with given uuid
     * @throws DataAccessException A database access exception
     */
    public User fetchUserById(final UUID id) throws DataAccessException {
        logger.info("Fetching user details by id: " + id.toString());

        val fetchUserQuery = "SELECT (username, first_name, last_name, email) FROM user_information WHERE id = ?";
        return jdbcTemplate.queryForObject(fetchUserQuery, (rs, _rc) -> {
            val user = new User(id);
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));

            return user;
        }, id);
    }

    /**
     * Fetch all users as a stream
     * 
     * @return a stream of users for efficient filtering
     * @throws DataAccessException A Data access error for postgres database
     */
    public Stream<User> fetchUsers() throws DataAccessException {
        logger.info("Fetching all users");

        val fetchUsersQuery = "SELECT * FROM user_information";
        return jdbcTemplate.queryForStream(fetchUsersQuery, (rs, _rc) -> {
            val user = new User(UUID.fromString(rs.getString("id")));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));

            return user;
        });
    }

    public User updateUserInformation(final UUID id, final EditCustomerForm form) throws DataAccessException {
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

    public User updateUser(final UUID id, final UserForm form) throws DataAccessException {
        logger.info("Editing user details");

        val user = new User(id);
        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());

        val updateUserCredQuery = "UPDATE users SET password = ? WHERE username = ?";

        jdbcTemplate.update(updateUserCredQuery, passwordEncoder.encode(form.getPassword()), user.getUsername());
        val updateUserQuery = "UPDATE user_information " +
                "SET " +
                "first_name = ?," +
                "last_name = ?," +
                "email = ?" +
                "WHERE id = ?";

        jdbcTemplate.update(updateUserQuery, user.getFirstName(), user.getLastName(), user.getEmail(), user.getId());

        return user;
    }

    /**
     * Delete a user by their username, cascade deletes a user, so all associated
     * tables are also deleted, can
     * be used for both deleting regular users with roles as well as customers
     * because of the cascade property
     * 
     * @param username the users login username, acts as a central primary key for
     *                 all associated data
     * @throws DataAccessException SQL Exception in case of failure
     */
    public void deleteUserByUsername(final String username) throws DataAccessException {
        logger.info("Deleting user {}", username);

        val deleteUserQuery = "DELETE FROM users WHERE username = ?";
        jdbcTemplate.update(deleteUserQuery, username);
    }

    public UserForm setRoles(final UserForm userForm) throws DataAccessException {
        val queryRoles = "SELECT * FROM authorities WHERE username = ?";
        val roles = jdbcTemplate.queryForStream(queryRoles,(rs, rc) -> {
            return new Role(rs.getString("username"), rs.getString("authority"));
        }, userForm.getUsername());

        userForm.setCustomer(roles.anyMatch((role) -> role.isRole(customerRole)));
        userForm.setStaff(roles.anyMatch((role) -> role.isRole(employeeRole)));
        userForm.setAdmin(roles.anyMatch((role) -> role.isRole(adminRole)));

        return userForm;
    }

    @AllArgsConstructor
    private class Role {
        private String username;
        private String authority;

        public boolean isRole(final String role) {
            return role.equals(authority);
        }
    }

    private void createUserIdentity(final String username, final String rawPassword) throws DataAccessException {
        logger.info("Creating new user with username " + username);

        val createUserQuery = "INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)";
        jdbcTemplate.update(createUserQuery, username, passwordEncoder.encode(rawPassword), true);
    }

    private void addUserToRole(final String username, final String role) throws DataAccessException {
        logger.info("Adding user " + username + "to Employee Role");

        val createAuthorityQuery = "INSERT INTO authorities VALUES (?, ?)";
        jdbcTemplate.update(createAuthorityQuery, username, role.toUpperCase(Locale.ROOT));
    }

    private void createUserInformation(final UUID id, final String username, final String firstName,
            final String lastName, final String email) throws DataAccessException {

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

    private void createCustomer(final UUID id, final UUID userId) throws DataAccessException {
        logger.info("Creating customer table");

        val createCustomerQuery = "INSERT INTO customers (id, user_id) VALUES (?, ?)";
        jdbcTemplate.update(createCustomerQuery, id, userId);
    }

    public void logPersist(final String username, final String action) throws DataAccessException {
        logger.info("Logging action " + action + "by user " + username);

        val createLogQuery = "INSERT INTO auth_log (id, username, log_action) VALUES (?, ?, ?)";
        jdbcTemplate.update(createLogQuery, UUID.randomUUID(), username, action);
    }
}