package au.edu.uts.isd.iotbay.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class BankPaymentForm {
    @Max(value = 255)
    private String  BANK_ACCOUNT_NAME;
    
    @max(value = 13)
    private String BANK_ACCOUNT_NUMBER;

    @Max(value = 3)
    private String BSB_NUMBER;
   
   

}