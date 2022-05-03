package au.edu.uts.isd.iotbay.controllers;

import au.edu.uts.isd.iotbay.models.forms.RegisterForm;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid @RequestBody RegisterForm registerForm, Errors err) {
        System.out.println(registerForm);
        if (null != err && err.getErrorCount() > 0) {
            return "register";
        }

        return "index";
    }
}
