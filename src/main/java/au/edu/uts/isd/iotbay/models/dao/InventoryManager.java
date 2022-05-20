package au.edu.uts.isd.iotbay.models.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import au.edu.uts.isd.iotbay.models.data.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class InventoryManager {
    private final JdbcTemplate jdbcTemplate;

    public InventoryManager(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Iterable<Product> fetchProducts() {
        String sqlQuery = "SELECT * FROM products";
        return jdbcTemplate.query(sqlQuery, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Product(
                        rs.getInt("id"),
                        null,
                        rs.getString("name"),
                        rs.getString("description"),
                        null,
                        rs.getInt("stock_level"),
                        rs.getInt("order_level"),
                        rs.getFloat("price"));
            }
        });
    }
}
