/*package au.edu.uts.isd.iotbay.unit;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Bank_payment_validater implements Serializable{ 


     
private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";       
     
private String numericPattern= "0-9";          
public Bank_payment_validater(){    }       


public boolean validate(String pattern, String input){       
   Pattern regEx = Pattern.compile(pattern);       
   Matcher match = regEx.matcher(input);       

   return match.matches(); 

}       



public boolean checkEmpty(String BANK_NAME, String BANK_ACOUNT_NUMBER ,String BSB_NUMBER ){       

   return  BANK_NAME.isEmpty() || BANK_ACOUNT_NUMBER.isEmpty() ||   BSB_NUMBER.isEmpty() ;

}


public boolean validateBANK_NAME (String  BANK_NAME){                       

   return validate(namePattern , BANK_NAME);   

}

    
public boolean validateBANK_ACOUNT_NUMBER (String BANK_ACOUNT_NUMBER){

   return validate(numericPattern,BANK_ACOUNT_NUMBER); 

}       


public boolean validateBSB_NUMBER (String BSB_NUMBER){

   return validate(numericPattern,BSB_NUMBER); 

}   


}
*/