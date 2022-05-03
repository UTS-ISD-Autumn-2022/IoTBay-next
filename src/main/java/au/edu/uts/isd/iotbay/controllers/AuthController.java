package au.edu.uts.isd.iotbay.controllers;

import au.edu.uts.isd.iotbay.models.forms.RegisterForm;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/register")
    public String registerGet(RegisterForm registerForm) {
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid RegisterForm registerForm, BindingResult result, Model model) {
        System.out.println(registerForm);
        if (result.hasErrors()) {
            return "register";
        }

        return "index";
    }
}
