package au.edu.uts.isd.iotbay.models.dao;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import org.springframework.stereotype.Component;

import au.edu.uts.isd.iotbay.models.data.Bank_Payment;
import au.edu.uts.isd.iotbay.models.forms.Bankpaymentform;

import java.sql.ResultSet;
import java.util.UUID;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





@Component

public  class Bankpaymentimp implements BankPaymentDao {
    private final JdbcTemplate jdbcTemplate;
    final Logger logger = LoggerFactory.getLogger(Bankpaymentimp.class);
    public Bankpaymentimp (JdbcTemplate B_jdbcTemplate) {
        jdbcTemplate = B_jdbcTemplate;
    }
    
    @Override
    public int saveBank_Payment (Bankpaymentform bankpaymentform){
        String sql = "INSERT INTO BANK_PAYMENT (BANK_NAME , BANK_ACCOUNT_NUMBER ,BSB_NUMBER) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,bankpaymentform.get_BANK_NAME(),bankpaymentform.get_BANK_ACCOUNT_NUMBER(),bankpaymentform.get_BSB_NUMBER());
    }

   @Override
    public int  UpdateBank_Payment (Bankpaymentform bankpaymentform){
        String sql = "UPDATE BANK_PAYMENT BANK_NAME=? , BANK_ACCOUNT_NUMBER=? ,BSB_NUMBER=? WHERE id=?";
        return jdbcTemplate.update(sql , bankpaymentform.get_BANK_NAME(), bankpaymentform.get_BANK_ACCOUNT_NUMBER(),bankpaymentform.get_BSB_NUMBER());
    }

   @Override
    public Bank_Payment getBank_Payment(UUID _id){
        String sql = "SELECT FROM  BANK_PAYMENT WHERE _id= " +_id;
        ResultSetExtractor<Bank_Payment> extractor = (ResultSet rs) -> {
            if (rs.next()){
                String BANK_NAME = rs.getString("Bank_Name");
                int BANK_ACCOUNT_NUMBER = rs.getInt("BANK_ACCOUNT_NUMBER");
                int BSB_NUMBER = rs.getInt("BSB_NUMBER");
                
                return new Bank_Payment(_id, BANK_NAME, BANK_ACCOUNT_NUMBER, BSB_NUMBER);
                
            }
            return null;
        };
        return jdbcTemplate.query(sql,extractor);
    }

    @Override
    public int deleteBank_Payment(UUID _id){
        String sql = "SELECT FROM  BANK_PAYMENT WHERE _id= " +_id;

    return jdbcTemplate.update(sql) ; 
    }

    
    
    }