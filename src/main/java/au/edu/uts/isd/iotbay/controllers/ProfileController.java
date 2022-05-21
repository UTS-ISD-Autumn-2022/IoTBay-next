package au.edu.uts.isd.iotbay.controllers;

import au.edu.uts.isd.iotbay.models.dao.UserManager;
import au.edu.uts.isd.iotbay.models.data.Customer;
import au.edu.uts.isd.iotbay.models.forms.EditCustomerForm;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

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
    public String editGet(@PathVariable("id") UUID id, EditCustomerForm form, Model model) {
        log.info("GET: /profile/edit/" + id);

        try {
            val customer = userManager.fetchCustomerById(id);
            log.info(customer.toString());
            model.addAttribute("customer", customer);
            model.addAttribute("user", customer.getUserInformation());

            form.setEmail(customer.getUserInformation().getEmail());
            form.setFirstName(customer.getUserInformation().getFirstName());
            form.setLastName(customer.getUserInformation().getLastName());

        } catch (Exception e) {
            log.error("Could not fetch customer data", e);
            return "error/500";
        }

        return "profile/edit";
    }

    @PostMapping("/edit/{id}")
    public String editPost(@PathVariable("id") UUID id, @ModelAttribute @Valid EditCustomerForm editCustomerForm, BindingResult result) {
        log.info("POST: /profile/edit/" + id);

        if (result.hasErrors()) {
            result.getAllErrors().forEach((e) -> log.warn("Field Error: {}", e));
            return "profile/edit";
        }

        try {
            userManager.updateUserInformation(id, editCustomerForm);
        } catch (Exception ex) {
            log.error("SQL Exception", ex);
            return "error/500";
        }

        return "redirect:/profile";
    }

    @PostMapping("/delete/{username}")
    public String customerDelete(@PathVariable("username") String username) {
        try {
            userManager.deleteUserByUsername(username);
        } catch (Exception e) {
            log.error("Could not delete user successfully", e);
            return "error/500";
        }

        return "redirect:/logout";
    }
}
