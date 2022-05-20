package au.edu.uts.isd.iotbay.controllers;

import au.edu.uts.isd.iotbay.models.dao.UserManager;
import au.edu.uts.isd.iotbay.models.data.Customer;
import au.edu.uts.isd.iotbay.models.forms.EditCustomerForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    UserManager userManager;

    final private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("")
    public String indexGet(@AuthenticationPrincipal User customer, Model model) {
        log.info("GET: /profile");

        Customer c = userManager.fetchCustomerByUsername(customer.getUsername());
        log.info(c.toString());

        model.addAttribute("customer", c);

        return "profile/index";
    }

    @GetMapping("/edit/{id}")
    public String editGet(@PathVariable("id") String id, Model model) {
        log.info("GET: /profile/edit/" + id);

        return "profile/edit";
    }

    @PutMapping("/edit/{id}")
    public String editPut(@PathVariable("id") String id, @Valid EditCustomerForm form, BindingResult result) {
        log.info("PUT: /profile/edit/" + id);

        return "profile/edit";
    }
}
