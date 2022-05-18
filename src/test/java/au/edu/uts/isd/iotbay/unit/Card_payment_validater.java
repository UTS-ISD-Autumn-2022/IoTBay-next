package au.edu.uts.isd.iotbay.unit;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Card_payment_validater implements Serializable{ 


     
private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";       
     
private String numericPattern= "0-9";          
public Card_payment_validater(){    }       


public boolean validate(String pattern, String input){       
   Pattern regEx = Pattern.compile(pattern);       
   Matcher match = regEx.matcher(input);       

   return match.matches(); 

}       



public boolean checkEmpty(String card_name, String card_number , String cvv , String card_expiry_month , String card_expiry_year ){       

   return  card_name.isEmpty() || card_number.isEmpty() ||   cvv.isEmpty() || card_expiry_month.isEmpty() || card_expiry_year.isEmpty() ;

}


public boolean validatecard_name (String card_name){                       

   return validate(namePattern ,card_name);   

}

    
public boolean validatecard_number (String card_number){

   return validate(numericPattern,card_number); 

}       


public boolean validate_cvv (String cvv){

   return validate(numericPattern,cvv); 

}   

public boolean validatecard_expiry_month (String card_expiry_month){

    return validate(numericPattern, card_expiry_month); 
 
 }  

 public boolean validatecard_expiry_year (String card_expiry_year){

    return validate(numericPattern,card_expiry_year); 
 
 }       


}