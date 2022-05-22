package au.edu.uts.isd.iotbay.models.dao;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import au.edu.uts.isd.iotbay.models.data.Order;

/**
 * Order manager class,
 * use this class to connect the app to the database
 */
@Component
public class OrderManager {

    /**
     * this here is autoconfigured to connect to the database, see user manager for
     * more examples
     */
    private final JdbcTemplate jdbc;

    /**
     * Use this for logging, handy for debugging errors and things
     */
    private final Logger log = LoggerFactory.getLogger(OrderManager.class);

    public OrderManager(final JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    public Iterable<Order> fetchOrders() {
        String sqlQuery = "SELECT * FROM orders WHERE username = ?";
        return jdbc.query(sqlQuery, (rs, rc) -> {
            Order order = new Order(UUID.fromString(rs.getString("id")));
            order.setCustomerId(UUID.fromString(rs.getString("customer_id")));
            order.setAddressId(UUID.fromString(rs.getString("address_id")));
            order.setPaymentOptionId(UUID.fromString(rs.getString("payment_method")));
            order.setCreatedAt(rs.getTimestamp("created_at"));
            order.setTotalCost(rs.getFloat("total_cost"));
            order.setStatus(rs.getString("status"));

            return order;
        });
    }
}
