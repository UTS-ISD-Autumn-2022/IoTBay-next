package au.edu.uts.isd.iotbay.controllers;

import au.edu.uts.isd.iotbay.models.dao.OrderManager;
import au.edu.uts.isd.iotbay.models.dao.UserManager;
import au.edu.uts.isd.iotbay.models.data.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @Autowired
    UserManager userManager;

    @Autowired
    OrderManager orderManager;

    @GetMapping("/profile/orders")
    public String orderGet(@AuthenticationPrincipal User customer) {
        final Customer c = userManager.fetchCustomerByUsername(customer.getUsername());
        return "orders/index";
    }
}
