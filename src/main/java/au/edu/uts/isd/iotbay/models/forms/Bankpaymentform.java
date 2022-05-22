package au.edu.uts.isd.iotbay.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class Bankpaymentform {
    
    @NotNull
    @Size(max = 255)
    private String  BANK_ACCOUNT_NAME;
    
    @NotNull
    @Size(max = 13)
    private String BANK_ACCOUNT_NUMBER;
    
    @NotNull
    @Size(max = 3)
    private String BSB_NUMBER;
   
   

}