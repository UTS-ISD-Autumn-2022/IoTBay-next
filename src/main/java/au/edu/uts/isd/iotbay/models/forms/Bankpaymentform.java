package au.edu.uts.isd.iotbay.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class Bankpaymentform {
    @Size(max = 255)
    private String  BANK_ACCOUNT_NAME;
    
    @Size(max = 13)
    private String BANK_ACCOUNT_NUMBER;

    @Size(max = 3)
    private String BSB_NUMBER;
   
   

}