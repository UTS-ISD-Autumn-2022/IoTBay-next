package au.edu.uts.isd.iotbay.models.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Order manager class,
 * use this class to connect the app to the database
 */
@Component
public class OrderManager {

    /**
     * this here is autoconfigured to connect to the database, see user manager for more examples
     */
    private final JdbcTemplate jdbc;

    /**
     * Use this for logging, handy for debugging errors and things
     */
    private final Logger log = LoggerFactory.getLogger(OrderManager.class);

    public OrderManager(final JdbcTemplate jdbcTemplate) {
        jdbc = jdbcTemplate;
    }
}
