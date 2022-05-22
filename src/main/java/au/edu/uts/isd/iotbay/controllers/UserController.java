package au.edu.uts.isd.iotbay.controllers;

import au.edu.uts.isd.iotbay.models.forms.UserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import au.edu.uts.isd.iotbay.models.dao.UserManager;
import lombok.val;

import javax.validation.Valid;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/users")
public class UserController {
    final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserManager userManager;

    @GetMapping()
    public String usersGet(Model model) {
        log.info("GET /admin/users");

        try {
            //val users = userManager.fetchUsers().toList();
            val users = userManager.fetchUsers().collect(Collectors.toList());
            model.addAttribute("users", users);
        } catch (Exception ex) {
            log.error("Error fetching all users", ex);
            return "error/500";
        }

        return "users/index";
    }

    @GetMapping("/create")
    public String createUserGet() {
        log.info("GET /admin/users/create");

        return "users/create";
    }

    @PostMapping("/create")
    public String createUserPost(@ModelAttribute @Valid UserForm form, BindingResult result) {
        log.info("POST /admin/users/create");

        if (result.hasErrors()) {
            for (val e : result.getFieldErrors())
                log.warn("Field Error: {}", e);

            return "users/create";
        }

        try {
            val user = userManager.createUser(form);

            if (form.isCustomer())
                userManager.addUserToCustomerRole(user.getUsername());

            if (form.isStaff())
                userManager.addUserToEmployeeRole(user.getUsername());

            if (form.isAdmin())
                userManager.addUserToAdminRole(user.getUsername());
        } catch (Exception ex) {
            log.error("SQL Exception", ex);

            return "error/500";
        }

        return "redirect:/admin/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserGet(@PathVariable("id") UUID id, UserForm userForm) {
        log.info("GET /admin/users/edit/" + id.toString());

        try {
            val user = userManager.fetchUserById(id);

            userForm.setUsername(user.getUsername());
            userForm.setFirstName(user.getFirstName());
            userForm.setLastName(user.getLastName());
            userForm.setEmail(user.getEmail());

            userManager.setRoles(userForm);
        } catch (Exception ex) {
            log.error("SQL Exception", ex);

            return "error/500";
        }

        return "/users/edit";
    }

    @PostMapping("/edit/{id}")
    public String editUserPost(@PathVariable("id") UUID id, @ModelAttribute @Valid UserForm userForm, BindingResult result) {
        return "stub";
    }

}
