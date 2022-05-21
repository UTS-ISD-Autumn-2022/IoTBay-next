
package au.edu.uts.isd.iotbay.controllers;

import au.edu.uts.isd.iotbay.models.dao.BankPaymentDao;
import au.edu.uts.isd.iotbay.models.dao.BankPaymentManager;
import au.edu.uts.isd.iotbay.models.data.Bank_Payment;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile/payment")
public class BankPaymentController {
    @Autowired
    BankPaymentManager bankPaymentManager;

    

    @GetMapping("/Bank_Payment")
    String indexGet() {
        return "payment/index";
    }
    @GetMapping("/Bank_Payment/{_id}")
    private Bank_Payment getBank_Payment(@PathVariable("id")UUID _id){
        return BankPaymentDao.getBank_Payment(_id);
    }

    //creating a delete mapping that deletes a specified bank payment 

    @DeleteMapping("/Bank_payment/{_id}")
    public void deleteBank_Payment(@PathVariable("id")UUID _id){
        BankPaymentDao.deleteBank_Payment(_id);
    }
    //creating post mapping that post the Bank Payment Details into the database 

    @PostMapping ("/Bank_Payment")
    private int saveBank_Payment(@RequestBody Bank_Payment bank_Payment){
        BankPaymentDao.saveorUpdateBank_Payment(bank_Payment);
        return Bank_Payment.get_id();
    }

    //creating put mapping that updates the Bank Payment Details
    @PutMapping    ("/Bank_Payment")
    private Bank_Payment UpdateBank_Payment(@RequestBody Bank_Payment bank_Payment){
        BankPaymentDao.UpdateBank_Payment(bank_Payment);
        return bank_Payment;
    }

   

}
