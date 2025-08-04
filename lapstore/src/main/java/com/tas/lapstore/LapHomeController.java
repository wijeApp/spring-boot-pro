package com.tas.lapstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class LapHomeController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping({"/laphome", "/"})
    public String showLapHome(Model model) {
        List<Laptop> laptops = laptopService.getAllLaptops();
        model.addAttribute("laptops", laptops);
        model.addAttribute("title", "Laptop Home");
        return "home";
    }
}
