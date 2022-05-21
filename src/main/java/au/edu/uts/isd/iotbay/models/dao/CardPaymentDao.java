package au.edu.uts.isd.iotbay.models.dao;

import java.util.List;
import java.util.UUID;

import au.edu.uts.isd.iotbay.models.data.Card_payment;

public interface CardPaymentDao {
    public int saveCard_Payment (Card_payment card_payment);

public int UpdateCard_Payment (Card_payment card_payment);

public Card_payment getCard_Payment(UUID _id);

public int deleteCard_Payment(UUID _id);

public List <Card_payment> list();
}
