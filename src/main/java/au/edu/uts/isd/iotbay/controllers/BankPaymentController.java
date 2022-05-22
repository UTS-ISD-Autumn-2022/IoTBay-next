
package au.edu.uts.isd.iotbay.controllers;

import au.edu.uts.isd.iotbay.models.dao.BankPaymentDao;
import au.edu.uts.isd.iotbay.models.dao.Bankpaymentimp;
import au.edu.uts.isd.iotbay.models.data.Bank_Payment;
import au.edu.uts.isd.iotbay.models.forms.Bankpaymentform;
import ch.qos.logback.classic.Logger;

import java.util.UUID;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile/payment")
public class BankPaymentController {
    @Autowired
    Bankpaymentimp bankpaymentimp;

    private final Logger  log = LoggerFactory.getLogger(Bankpaymentimp.class);

    @GetMapping("/Bank_Payment")
    String indexGet() {
        return "payment/index";
    }
    @GetMapping("/Bank_Payment/{_id}")
    private Bank_Payment getBank_Payment(@PathVariable("id")UUID _id){
        return Bankpaymentimp.getBank_Payment(_id);
    }

    //creating a delete mapping that deletes a specified bank payment 
    @PostMapping("/delete/{id}")
    public String  deleteBank_Payment(@PathVariable("id") UUID id) throws Exception {
        throw new Exception("Unimplemented");
        // return "redirect:/logout";
    }
   
    
    //creating post mapping that post the Bank Payment Details into the database 

    @PostMapping ("/Bank_Payment/{id}")
    private String saveBank_Payment(@PathVariable("id") UUID id, @ModelAttribute @Valid Bankpaymentform bankpaymentform, BindingResult result){
        log.info("POST: /Bank_Payment/edit/" + id);

        if (result.hasErrors()) {
            result.getAllErrors().forEach((e) -> log.warn("Field Error: {}", e));
            return "profile/edit";
        }

        try {
            Bankpaymentimp.UpdateBank_Payment (id ,bankpaymentform);
        } catch (Exception ex) {
            log.error("SQL Exception", ex);
            return "error/500";
        }

        return "redirect:/profile";
    }

    //creating put mapping that updates the Bank Payment Details
  

   

}
