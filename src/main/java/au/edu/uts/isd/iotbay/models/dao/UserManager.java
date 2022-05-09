package au.edu.uts.isd.iotbay.models.dao;

import au.edu.uts.isd.iotbay.models.data.Customer;
import au.edu.uts.isd.iotbay.models.data.User;
import au.edu.uts.isd.iotbay.models.forms.RegisterForm;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.val;
import java.util.UUID;

@Component
public class UserManager {
    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;

    public UserManager(JdbcTemplate l_jdbcTemplate, PasswordEncoder l_passwordEncoder) {
        jdbcTemplate = l_jdbcTemplate;
        passwordEncoder = l_passwordEncoder;
    }

    public Customer registerCustomer(RegisterForm registerForm) throws Exception {
        if (registerForm.getPassword().equals(registerForm.getPasswordVerification()))
            throw new Exception("Passwords do not match!");

        try {
            val createUserQuery = "INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)";
            jdbcTemplate.update(createUserQuery, registerForm.getUsername(),
                    passwordEncoder.encode(registerForm.getPassword()),
                    true);
        } catch (Exception e) {
            throw new Exception("Username already exists!");
        }

        val createAuthorityQuery = "INSERT INTO authorities VALUES (?, ?)";
        jdbcTemplate.update(createAuthorityQuery, registerForm.getUsername(), "CUSTOMER");

        val createUserInformationQuery = "INSERT INTO user_information (id, username, first_name, last_name, email)" +
                "VALUES (?, ?, ?, ?, ?)";

        val userId = UUID.randomUUID();
        jdbcTemplate.update(
                createUserInformationQuery,
                userId.toString(),
                registerForm.getUsername(),
                registerForm.getFirstName(),
                registerForm.getLastName(),
                registerForm.getEmail());

        val createCustomerQuery = "INSERT INTO customers (id, user_id) VALUES (?, ?)";
        val custId = UUID.randomUUID();
        jdbcTemplate.update(createCustomerQuery, custId.toString(), userId.toString());

        return new Customer(
                custId,
                new User(
                        userId,
                        registerForm.getUsername(),
                        registerForm.getFirstName(),
                        registerForm.getLastName(),
                        registerForm.getEmail()));
    }
}