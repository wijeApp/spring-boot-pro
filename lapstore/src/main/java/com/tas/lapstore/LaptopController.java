package com.tas.lapstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping({"/home", "/laphome", "/"})
    public String showLapHome(Model model) {
        model.addAttribute("title", "Laptop Store Home");
        model.addAttribute("laptops", laptopService.getAllLaptops());
        return "home";
    }

    @GetMapping("/laptops/home")
    public String laptopsHome(Model model) {
        model.addAttribute("title", "Laptop Store Home");
        model.addAttribute("laptops", laptopService.getAllLaptops());
        return "home";
    }

    @GetMapping("/add")
    public String addLaptopForm(Model model) {
        model.addAttribute("laptop", new Laptop());
        return "add-laptop";
    }

    @PostMapping("/add")
    public String addLaptop(@ModelAttribute Laptop laptop) {
        laptopService.saveLaptop(laptop);
        return "redirect:/laptops/home";
    }

    @GetMapping("/edit/{id}")
    public String editLaptopForm(@PathVariable Long id, Model model) {
        Optional<Laptop> laptop = laptopService.getLaptopById(id);
        if (laptop.isPresent()) {
            model.addAttribute("laptop", laptop.get());
            return "edit-laptop";
        }
        return "redirect:/laptops/home";
    }

    @PostMapping("/edit/{id}")
    public String editLaptop(@PathVariable Long id, @ModelAttribute Laptop laptop) {
        laptop.setId(id);
        laptopService.saveLaptop(laptop);
        return "redirect:/laptops/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteLaptop(@PathVariable Long id) {
        laptopService.deleteLaptop(id);
        return "redirect:/laptops/home";
    }
}
