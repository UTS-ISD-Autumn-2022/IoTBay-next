
package au.edu.uts.isd.iotbay.controllers;

import au.edu.uts.isd.iotbay.models.dao.BankPaymentManager;
import au.edu.uts.isd.iotbay.models.dao.CardPaymentManager;
import au.edu.uts.isd.iotbay.models.dao.InventoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile/payment")
public class PaymentController {
    @Autowired
    BankPaymentManager bankPaymentManager;

    @Autowired
    CardPaymentManager cardPaymentManager;

    @GetMapping("")
    String indexGet() {
        return "payment/index";
    }
}
