package au.edu.uts.isd.iotbay.models.data;



public class Bank_Payment implements java.io.Serializable {
final int _id;
String _BANK_NAME;
int  _BANK_ACCOUNT_NUMBER; 
int  _BSB_NUMBER; 

public Bank_Payment (int id , String BANK_NAME , int BANK_ACCOUNT_NUMBER , int BSB_NUMBER ) {
    _id = id;
    _BANK_NAME =  BANK_NAME;
   _BANK_ACCOUNT_NUMBER = BANK_ACCOUNT_NUMBER; 
   _BSB_NUMBER = BSB_NUMBER ;
}

    public int get_id() {
        return _id;
    }


    public String get_BANK_NAME() {
        return _BANK_NAME;
    }

    public void set_BANK_NAME(String BANK_NAME) {
        _BANK_NAME = BANK_NAME;
    }

    public int get_BANK_ACCOUNT_NUMBER() {
        return _BANK_ACCOUNT_NUMBER;
    }

    public void set_BANK_ACCOUNT_NUMBER(char BANK_ACCOUNT_NUMBER) {
      _BANK_ACCOUNT_NUMBER = BANK_ACCOUNT_NUMBER;
    }

    public int get_BSB_NUMBER() {
        return _BSB_NUMBER;
    }

    public void set_BSB_NUMBER(char BSB_NUMBER) {
        _BSB_NUMBER = BSB_NUMBER;
    }

}
