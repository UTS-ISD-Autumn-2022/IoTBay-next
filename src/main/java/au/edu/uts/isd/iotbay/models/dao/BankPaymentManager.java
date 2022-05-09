package au.edu.uts.isd.iotbay.models.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import au.edu.uts.isd.iotbay.models.data.Bank_Payment;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class BankPaymentManager {
    private final JdbcTemplate jdbcTemplate;

    public BankPaymentManager(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Iterable<Card_payment> fetchBank_Payment() {
        String sqlQuery = "SELECT * FROM Bank_payment";
        return jdbcTemplate.query(sqlQuery, new RowMapper<Bank_Payment>() {
            @Override
            public Card_payment mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Bank_payment(
                        rs.getInt("id"),
                        null,
                        rs.getString("BANK_ACCOUNT_NAME"),
                        rs.getchar("BANK_ACCOUNT_NUMBER"),
                        rs.getchar("BSB_NUMBER")
                       );
            }
        });
    }
}


