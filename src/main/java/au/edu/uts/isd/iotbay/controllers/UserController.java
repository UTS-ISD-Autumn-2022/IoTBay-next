package au.edu.uts.isd.iotbay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    @GetMapping()
    public String usersGet() {
        return "users/index";
    }

}
