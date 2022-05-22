package au.edu.uts.isd.iotbay.models.data;
import au.edu.uts.isd.iotbay.models.forms.Bankpaymentform;
import lombok.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class Bank_Payment{
final private  UUID  _id;
private String  _BANK_NAME;
private int _BANK_ACCOUNT_NUMBER; 
private int _BSB_NUMBER; 

 

public Bank_Payment(Bankpaymentform bankpaymentform){

    _id = UUID.randomUUID();
    _BANK_NAME = bankpaymentform.get_BANK_NAME();
    _BANK_ACCOUNT_NUMBER = bankpaymentform.get_BANK_ACCOUNT_NUMBER();
    _BSB_NUMBER = bankpaymentform.get_BSB_NUMBER();
  

}
}
