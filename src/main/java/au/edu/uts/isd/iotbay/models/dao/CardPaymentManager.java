package au.edu.uts.isd.iotbay.models.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import au.edu.uts.isd.iotbay.models.data.Card_payment;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.List;
import java.sql.RowId;

import javax.sql.DataSource;





@Component
public abstract class  CardPaymentManager implements CardPaymentDao {
    private final JdbcTemplate jdbcTemplate;

    public CardPaymentManager(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


 @Override
    public int saveCard_Payment (Card_payment c_Card_payment){
        String sql = "INSERT INTO CARD_PAYMENT(card_name , card_number , card_cvc ,card_expiry_month, card__expiry_year) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,c_Card_payment.get_card_name(),c_Card_payment.get_card_number(),c_Card_payment.get_card_cvc(),c_Card_payment.get_card_expiry_month(),c_Card_payment.get_card__expiry_year());
    }
    @Override
    public int  UpdateCard_Payment(Card_payment c_Card_payment){
        String sql = "UPDATE CARD_PAYMENT BANK_NAME=? , BANK_ACCOUNT_NUMBER=? ,BSB_NUMBER=? WHERE id=?";
        return jdbcTemplate.update(sql,c_Card_payment.get_card_name(),c_Card_payment.get_card_number(),c_Card_payment.get_card_cvc(),c_Card_payment.get_card_expiry_month(),c_Card_payment.get_card__expiry_year());
    }

    @Override
    public Card_payment getCard_Payment(UUID _id){
        String sql = "SELECT FROM CARD_PAYMENT WHERE _id= " +_id;
        ResultSetExtractor<Card_payment> extractor = new ResultSetExtractor<Card_payment>() {
            @Override
            public Card_payment extractData(ResultSet rs) throws SQLException , DataAccessException{
                if (rs.next()){
                    String card_name = rs.getString("card_name");
                    int card_number = rs.getInt("card_number");
                    int card_cvc = rs.getInt("card_cvc");
                    int card_expiry_month = rs.getInt("card_expiry_month");
                    int card_expiry_year = rs.getInt("card_expiry_year");

                    return new Card_payment(_id,card_name,card_number,card_cvc,card_expiry_month,card_expiry_year);

                }
                return null;
            }
        };
        return jdbcTemplate.query(sql,extractor);
    }

    @Override
    public int deleteCard_Payment(UUID _id){
        String sql = "SELECT FROM CARD_PAYMENT WHERE _id= " +_id;

    return jdbcTemplate.update(sql) ; 
    }


}


