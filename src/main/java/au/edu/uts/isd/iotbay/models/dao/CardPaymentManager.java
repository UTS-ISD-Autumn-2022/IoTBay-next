package au.edu.uts.isd.iotbay.models.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import au.edu.uts.isd.iotbay.models.data.Card_payment;


import java.sql.ResultSet;
import java.sql.SQLException;





@Component
public class CardPaymentManager {
    private final JdbcTemplate jdbcTemplate;

    public CardPaymentManager(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Iterable<Card_payment> fetchCard_payment() {
        String sqlQuery = "SELECT * FROM Card_payment";
        return jdbcTemplate.query(sqlQuery, new RowMapper<Card_payment>() {
            @Override
            public Card_payment mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Card_payment(
                        rs.getInt("id"),
                        rs.getString("card_name"),
                        rs.getInt("card_number"),
                        rs.getInt("card_cvv"),
                        rs.getInt("card_expiry_month"),
                        rs.getInt("card_expiry_year")

                        );
            }
        });
    }
}
