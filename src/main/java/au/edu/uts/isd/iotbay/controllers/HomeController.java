package au.edu.uts.isd.iotbay.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import au.edu.uts.isd.iotbay.models.dao.InventoryManager;

import java.util.UUID;

@Controller
public class HomeController {

    final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    InventoryManager inventoryManager;

    @GetMapping("/")
    String indexGet(Model model) {
        model.addAttribute("products", inventoryManager.fetchProducts());
        return "index";
    }
}
