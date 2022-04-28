package au.edu.uts.isd.iotbay.controllers;

import au.edu.uts.isd.iotbay.models.data.InventoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    InventoryManager inventoryManager;

    @GetMapping("/")
    String indexGet(Model model) {
        model.addAttribute("products", inventoryManager.fetchProducts());
        return "index";
    }
}
