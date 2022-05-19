package au.edu.uts.isd.iotbay.controllers;

import au.edu.uts.isd.iotbay.models.dao.UserManager;
import au.edu.uts.isd.iotbay.models.data.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    UserManager userManager;

    final private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("")
    public String indexGet(@AuthenticationPrincipal User customer, Model model) {
        log.info("Fetching /profile");

        Customer c = userManager.fetchCustomerByUsername(customer.getUsername());
        log.info(c.toString());

        model.addAttribute("customer", c);

        return "profile/index";
    }
}
