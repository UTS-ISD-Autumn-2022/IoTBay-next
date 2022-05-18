package au.edu.uts.isd.iotbay.models.dao;

import au.edu.uts.isd.iotbay.models.data.Customer;
import au.edu.uts.isd.iotbay.models.data.User;
import au.edu.uts.isd.iotbay.models.forms.RegisterForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.val;

import java.util.UUID;

@Component
public class UserManager {
    final String ADMIN = "ROLE_ADMIN";
    final String CUSTOMER = "ROLE_CUSTOMER";
    final String EMPLOYEE = "ROLE_EMPLOYEE";

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
                    user.getEmail()
                    );

            createCustomer(customer.getId(), user.getId());;
        } catch (Exception e) {
            logger.error(e.toString());
            logger.error(e.getMessage());
            throw new Exception("Registration Error!");
        }

        return customer;
   }

    private void createUserIdentity(final String username, final String rawPassword) throws Exception{
        logger.info("Creating new user with username " + username);
        val createUserQuery="INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)";
        jdbcTemplate.update(createUserQuery,username,passwordEncoder.encode(rawPassword), true);
    }

    private void addUserToCustomerAuthority(final String username) throws Exception {
        logger.info("Adding user " + username + "to Customer Authority");
        val createAuthorityQuery = "INSERT INTO authorities VALUES (?, ?)";
        jdbcTemplate.update(createAuthorityQuery, username, CUSTOMER);
    }

    private void createUserInformation(final UUID id, final String username, final String firstName, final String lastName, final String email) throws Exception {
        logger.info("Creating user information for " + username);
        val createUserInformationQuery = "INSERT INTO user_information (id, username, first_name, last_name, email)" + "VALUES (?, ?, ?, ?, ?)";
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
}