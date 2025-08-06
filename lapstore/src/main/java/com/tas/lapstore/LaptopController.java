package com.tas.lapstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping(produces = "application/json")
    public List<LaptopViewModel> getAllLaptops() {
        return laptopService.getAllLaptops().stream().map(LaptopViewModel::fromEntity).toList();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public LaptopViewModel getLaptopById(@PathVariable Long id) {
        Optional<Laptop> laptop = laptopService.getLaptopById(id);
        return laptop.map(LaptopViewModel::fromEntity).orElse(null);
    }

    // The following endpoints are disabled for read-only mode:
    // @PostMapping
    // public LaptopViewModel createLaptop(@RequestBody LaptopViewModel laptopVM) {
    //     Laptop laptop = laptopVM.toEntity();
    //     Laptop saved = laptopService.saveLaptop(laptop);
    //     return LaptopViewModel.fromEntity(saved);
    // }

    // @PutMapping("/{id}")
    // public LaptopViewModel updateLaptop(@PathVariable Long id, @RequestBody LaptopViewModel laptopVM) {
    //     Laptop laptop = laptopVM.toEntity();
    //     laptop.setId(id);
    //     Laptop updated = laptopService.saveLaptop(laptop);
    //     return LaptopViewModel.fromEntity(updated);
    // }

    // @DeleteMapping("/{id}")
    // public void deleteLaptop(@PathVariable Long id) {
    //     laptopService.deleteLaptop(id);
    // }
}
