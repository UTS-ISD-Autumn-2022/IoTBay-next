package au.edu.uts.isd.iotbay.models.dao;

import au.edu.uts.isd.iotbay.models.data.Customer;
import au.edu.uts.isd.iotbay.models.data.Role;
import au.edu.uts.isd.iotbay.models.data.User;
import au.edu.uts.isd.iotbay.models.forms.RegisterForm;
import lombok.val;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Component
public class UserManager {
    private final JdbcTemplate jdbcTemplate;
    private final Stream<Role> roles;

    public UserManager(JdbcTemplate l_jdbcTemplate) {
        jdbcTemplate = l_jdbcTemplate;

        val sqlQuery = "SELECT * FROM roles";
        roles = jdbcTemplate.queryForStream(sqlQuery, (rs, rowNum) -> {
            val id = UUID.fromString(rs.getString("id"));
            val name = rs.getString("name");
            return new Role(id, name);
        });
    }

    public Stream<Role> fetchRoles() {
        return roles;
    }

    public Stream<User> fetchUsers() {
        val sqlQuery = "SELECT * FROM user_credentials";
        return jdbcTemplate.queryForStream(sqlQuery, (rs, rowNum) -> {
            val id = UUID.fromString(rs.getString("id"));
            val roleId = UUID.fromString(rs.getString("role_id"));
            val role = roles.filter((r) -> r.getId().equals(roleId)).findFirst().get();
            val username = rs.getString("username");
            val password = rs.getString("password_hash");
            val email = rs.getString("email");
            val firstName = rs.getString("first_name");
            val lastName = rs.getString("last_name");

            return new User(Optional.of(id), role, username, password, email, firstName, lastName);
        });
    }

    /*
    public User fetchUserByUsername(String username) {
        val sqlQuery = "SELECT * FROM user_credentials WHERE username = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{username}, (rs, rowNum) -> {
            val id = UUID.fromString(rs.getString("id"));
            val roleId = UUID.fromString(rs.getString("role_id"));
            val role = roles.filter((r) -> r.getId().equals(roleId)).findFirst().get();
            val password = rs.getString("password");
            val email = rs.getString("email");
            val firstName = rs.getString("first_name");
            val lastName = rs.getString("last_name");

            return new User(Optional.of(id), role, username, password, email, firstName, lastName);
        });
    }
     */

    public Customer registerCustomer(RegisterForm registration) {
        val sqlQuery = "INSERT INTO ";

        return null;
    }
}
