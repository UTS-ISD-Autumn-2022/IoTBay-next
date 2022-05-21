package au.edu.uts.isd.iotbay.models.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import au.edu.uts.isd.iotbay.models.data.Bank_Payment;
import au.edu.uts.isd.iotbay.models.forms.Bankpaymentform;

import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;





@Component
public abstract class BankPaymentManager implements BankPaymentDao {
    private final JdbcTemplate jdbcTemplate;

    public BankPaymentManager(JdbcTemplate jdbcTemplate) {
        jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public int saveBank_Payment (Bank_Payment bpBank_Payment){
        String sql = "INSERT INTO BANK_PAYMENT (BANK_NAME , BANK_ACCOUNT_NUMBER ,BSB_NUMBER) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,bpBank_Payment.get_BANK_NAME(),bpBank_Payment.get_BANK_ACCOUNT_NUMBER(),bpBank_Payment.get_BSB_NUMBER());
    }

    @Override
    public int  UpdateBank_Payment (Bank_Payment bpbank_Payment){
        String sql = "UPDATE BANK_PAYMENT BANK_NAME=? , BANK_ACCOUNT_NUMBER=? ,BSB_NUMBER=? WHERE id=?";
        return jdbcTemplate.update(sql , bpbank_Payment.get_BANK_NAME(), bpbank_Payment.get_BANK_ACCOUNT_NUMBER(),bpbank_Payment.get_BSB_NUMBER());
    }

    @Override
    public Bank_Payment getBank_Payment(UUID _id){
        String sql = "SELECT FROM  BANK_PAYMENT WHERE _id= " +_id;
        ResultSetExtractor<Bank_Payment> extractor = new ResultSetExtractor<Bank_Payment>() {
            @Override
            public Bank_Payment extractData(ResultSet rs) throws SQLException , DataAccessException{
                if (rs.next()){
                    String BANK_NAME = rs.getString("Bank_Name");
                    int BANK_ACCOUNT_NUMBER = rs.getInt("BANK_ACCOUNT_NUMBER");
                    int BSB_NUMBER = rs.getInt("BSB_NUMBER");

                    return new Bank_Payment(_id, BANK_NAME, BANK_ACCOUNT_NUMBER, BSB_NUMBER);

                }
                return null;
            }
        };
        return jdbcTemplate.query(sql,extractor);
    }

    @Override
    public int deleteBank_Payment(UUID _id){
        String sql = "SELECT FROM  BANK_PAYMENT WHERE _id= " +_id;

    return jdbcTemplate.update(sql) ; 
    }

    
    }
