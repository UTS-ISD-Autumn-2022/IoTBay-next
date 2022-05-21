package au.edu.uts.isd.iotbay.controllers;
import au.edu.uts.isd.iotbay.models.dao.BankPaymentManager;
import au.edu.uts.isd.iotbay.models.dao.CardPaymentDao;
import au.edu.uts.isd.iotbay.models.dao.CardPaymentManager;
import au.edu.uts.isd.iotbay.models.dao.InventoryManager;
import au.edu.uts.isd.iotbay.models.data.Bank_Payment;
import au.edu.uts.isd.iotbay.models.data.Card_payment;

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
public class CardPaymentController {
    @Autowired
    CardPaymentManager cardPaymentManager;

    @GetMapping("/Card_payment")
    String indexGet() {
        return "payment/index";
    }

    @GetMapping("/Card_Payment/{_id}")
    private Card_payment getCard_Payment(@PathVariable("id")int _id){
        return CardPaymentDao.getCard_Payment(_id);
    }

    //creating a delete mapping that deletes a specified bank payment 

    @DeleteMapping("/Card_payment/{_id}")
    public void deleteCard_Payment (@PathVariable("id")UUID _id){
        CardPaymentDao.deleteCard_Payment(_id);
    }
    //creating post mapping that post the Bank Payment Details into the database 

    @PostMapping ("/Card_payment")
    private int saveCard_Payment(@RequestBody Card_payment card_payment){
        CardPaymentDao.saveCard_Payment(card_payment);
        return Card_payment.get_id();
    }

    //creating put mapping that updates the Bank Payment Details
    @PutMapping    ("/Card_payment")
    private Card_payment UpdateCard_Payment(@RequestBody Card_payment card_payment){
        CardPaymentDao.UpdateCard_Payment(card_payment);
        return card_payment;
}
}
