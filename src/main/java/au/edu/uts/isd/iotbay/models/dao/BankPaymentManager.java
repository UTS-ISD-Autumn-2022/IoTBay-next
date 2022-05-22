package au.edu.uts.isd.iotbay.models.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import au.edu.uts.isd.iotbay.models.data.Bank_Payment;



import java.sql.ResultSet;
import java.sql.SQLException;





@Component
public class BankPaymentManager {
    private final JdbcTemplate jdbcTemplate;

    public BankPaymentManager(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Iterable<Bank_Payment> fetchCard_payment() {
        String sqlQuery = "SELECT * FROM Bank_Payment";
        return jdbcTemplate.query(sqlQuery, new RowMapper<Bank_Payment>() {
            @Override
            public Bank_Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Bank_Payment(
                        rs.getInt("id"),
                        rs.getString("BANK_NAME"),
                        rs.getInt("BANK_ACCOUNT_NUMBER"),
                        rs.getInt("BSB_NUMBER"));

            }
        });
    }
}
