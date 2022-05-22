
package au.edu.uts.isd.iotbay.models.dao;

import java.util.UUID;

import au.edu.uts.isd.iotbay.models.data.Bank_Payment;
import au.edu.uts.isd.iotbay.models.forms.Bankpaymentform;

public interface BankPaymentDao {
    
    public  int saveBank_Payment (Bankpaymentform bankpaymentform);
    
  public int UpdateBank_Payment (Bankpaymentform bankpaymentform);

    public Bank_Payment getBank_Payment(UUID _id);

 public int deleteBank_Payment(UUID _id);


  
}
