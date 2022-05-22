
import au.edu.uts.isd.iotbay.models.dao.Bankpaymentimp;
import au.edu.uts.isd.iotbay.models.dao.CardPaymentDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import org.springframework.stereotype.Component;


import au.edu.uts.isd.iotbay.models.data.Card_payment;
import au.edu.uts.isd.iotbay.models.forms.Cardpaymentform;


import java.sql.ResultSet;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





@Component
public class CardPaymentimp implements CardPaymentDao {
    private final JdbcTemplate jdbcTemplate;
       final Logger logger = LoggerFactory.getLogger(CardPaymentimp.class);
    public CardPaymentimp(JdbcTemplate C_jdbctemplate) {
        jdbcTemplate = C_jdbctemplate;
    }


    @Override
    public int saveCard_Payment (Cardpaymentform cardpaymentform){
        String sql = "INSERT INTO CARD_PAYMENT(card_name , card_number , card_cvc ,card_expiry_month, card__expiry_year) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,cardpaymentform.get_card_name(),cardpaymentform.get_card_number(),cardpaymentform.get_card_cvc(),cardpaymentform.get_card_expiry_month(),cardpaymentform.get_card_expiry_year());
    }
   @Override
    public int  UpdateCard_Payment(Cardpaymentform cardpaymentform){
        String sql = "UPDATE CARD_PAYMENT BANK_NAME=? , BANK_ACCOUNT_NUMBER=? ,BSB_NUMBER=? WHERE id=?";
        return jdbcTemplate.update(sql,cardpaymentform.get_card_name(),cardpaymentform.get_card_number(),cardpaymentform.get_card_cvc(),cardpaymentform.get_card_expiry_month(),cardpaymentform.get_card_expiry_year());
    }

   @Override
    public Card_payment getCard_Payment(UUID _id){
        String sql = "SELECT FROM CARD_PAYMENT WHERE _id= " +_id;
        ResultSetExtractor<Card_payment> extractor = (ResultSet rs) -> {
            if (rs.next()){
                String card_name = rs.getString("card_name");
                int card_number = rs.getInt("card_number");
                int card_cvc = rs.getInt("card_cvc");
                int card_expiry_month = rs.getInt("card_expiry_month");
                int card_expiry_year = rs.getInt("card_expiry_year");
                
                return new Card_payment(_ID,card_name,card_number,card_cvc,card_expiry_month,card_expiry_year);
                
            }
            return null;
        };
        return jdbcTemplate.query(sql,extractor);
    }

   @Override
    public int deleteCard_Payment(UUID _id){
        String sql = "SELECT FROM CARD_PAYMENT WHERE _id= " +_id;

    return jdbcTemplate.update(sql) ; 
    }


}
