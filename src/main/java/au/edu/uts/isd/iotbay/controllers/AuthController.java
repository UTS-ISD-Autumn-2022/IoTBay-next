package au.edu.uts.isd.iotbay.controllers;

import au.edu.uts.isd.iotbay.models.dao.UserManager;
import au.edu.uts.isd.iotbay.models.data.Customer;
import au.edu.uts.isd.iotbay.models.forms.RegisterForm;

import javax.validation.Valid;

import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AuthController {
    final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    UserManager userManager;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerGet(RegisterForm registerForm) {
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid RegisterForm registerForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            for (val e : result.getAllErrors())
                logger.error(e.getDefaultMessage());
            return "register";
        }

        try {
            userManager.registerCustomer(registerForm);
        } catch (Exception e) {
            logger.error(e.getMessage());
            result.addError(new FieldError("password", "password", "Passwords did not match"));
            return "register";
        }

        return "index";
    }
}
