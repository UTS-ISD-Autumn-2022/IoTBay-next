package au.edu.uts.isd.iotbay.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    final Logger log = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/admin")
    public String adminGet() {
        return "admin";
    }
}
