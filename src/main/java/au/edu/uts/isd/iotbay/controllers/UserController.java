package au.edu.uts.isd.iotbay.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import au.edu.uts.isd.iotbay.models.dao.UserManager;
import lombok.val;

@Controller
@RequestMapping("/admin/users")
public class UserController {
    final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserManager userManager;

    @GetMapping()
    public String usersGet(Model model) {
        try {
            val users = userManager.fetchUsers().toList();
            model.addAttribute("users", users);
        } catch (Exception ex) {
            log.error("Error fetching all users", ex);
            return "error/500";
        }

        return "users/index";
    }

}
