package au.edu.uts.isd.iotbay.models.dao;

import au.edu.uts.isd.iotbay.models.data.Role;
import lombok.val;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

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
}
