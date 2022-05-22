package au.edu.uts.isd.iotbay.controllers;


import java.util.UUID;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import au.edu.uts.isd.iotbay.models.dao.CardPaymentimp;
import au.edu.uts.isd.iotbay.models.data.Card_payment;

import au.edu.uts.isd.iotbay.models.forms.Cardpaymentform;
import ch.qos.logback.classic.Logger;


@Controller
@RequestMapping("/profile/payment")
public class CardPaymentController {
    
    @Autowired
    CardPaymentimp cardpaymentimp;

    final private Logger log = LoggerFactory.getLogger(CardPaymentimp.class);

    @GetMapping("/Card_Payment")
    String indexGet() {
        return "payment/index";
    }
    @GetMapping("/Card_Payment/{_id}")
    private Card_payment getCard_Payment(@PathVariable("id")UUID _id){
        return CardPaymentimp.getCard_Payment(_id);
    }

    //creating a delete mapping that deletes a specified bank payment 
    @PostMapping("/delete/{id}")
    public String  deleteCard_Payment(@PathVariable("id") UUID id) throws Exception {
        throw new Exception("Unimplemented");
        // return "redirect:/logout";
    }
   
    
    //creating post mapping that post the Bank Payment Details into the database 

    @PostMapping ("/Card_Payment/{id}")
    private String saveCard_Payment(@PathVariable("id") UUID id, @ModelAttribute @Valid Cardpaymentform cardpaymentform, BindingResult result){
        log.info("POST: /Card_Payment/edit/" + id);

        if (result.hasErrors()) {
            result.getAllErrors().forEach((e) -> log.warn("Field Error: {}", e));
            return "profile/edit";
        }

        try {
            CardPaymentimp.UpdateCard_Payment(id ,cardpaymentform);
        } catch (Exception ex) {
            log.error("SQL Exception", ex);
            return "error/500";
        }

        return "redirect:/profile";
    }
}

    //creating put mapping that updates the Bank Payment Details