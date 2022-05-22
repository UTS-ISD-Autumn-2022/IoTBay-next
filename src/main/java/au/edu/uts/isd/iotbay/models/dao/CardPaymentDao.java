
package au.edu.uts.isd.iotbay.models.dao;
import java.util.List;
import java.util.UUID;
import au.edu.uts.isd.iotbay.models.data.Card_payment;
import au.edu.uts.isd.iotbay.models.forms.Cardpaymentform;

public interface CardPaymentDao {
    
      public int saveCard_Payment (Cardpaymentform cardpaymentform);

public int UpdateCard_Payment (Cardpaymentform cardpaymentform);

public Card_payment getCard_Payment(int _id);

public int deleteCard_Payment(UUID _id);


}
