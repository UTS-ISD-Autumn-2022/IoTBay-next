package au.edu.uts.isd.iotbay.controllers;
import au.edu.uts.isd.iotbay.models.dao.InventoryManager;
import au.edu.uts.isd.iotbay.models.data.Customer;
import au.edu.uts.isd.iotbay.models.data.Product;
import au.edu.uts.isd.iotbay.models.forms.EditCustomerForm;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryManager inventoryManager;
    @PostMapping("/addproduct")
    public String addproduct(@Valid Product product) {
        if (result.hasErrors()) {
            return "add-user";
        }
        
        inventoryManager.save(user);
        return "redirect:/index";
    }

    }    

    

