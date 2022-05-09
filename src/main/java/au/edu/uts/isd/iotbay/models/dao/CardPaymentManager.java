package au.edu.uts.isd.iotbay.models.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import au.edu.uts.isd.iotbay.models.data.Card_payment;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CardPaymentManager{}

/*
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
                        null,
                        rs.getString("card_name"),
                        rs.get("card_number"),
                        null,
                        rs.getchar("card_number"),
                        rs.getchat("card_cvv"),
                        rs.getDate("ard_expiry_date"));
            }
        });
    }
}
*/