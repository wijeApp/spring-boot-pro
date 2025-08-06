package com.tas.lapstore;

public class LaptopViewModel {
    private Long id;
    private String brand;
    private String model;
    private double price;
    private int ram;
    private int storage;
    private String imageUrl;

    public static LaptopViewModel fromEntity(Laptop laptop) {
        LaptopViewModel vm = new LaptopViewModel();
        vm.id = laptop.getId();
        vm.brand = laptop.getBrand();
        vm.model = laptop.getModel();
        vm.price = laptop.getPrice();
        vm.ram = laptop.getRam();
        vm.storage = laptop.getStorage();
        vm.imageUrl = laptop.getImageUrl();
        return vm;
    }

    public Laptop toEntity() {
        Laptop laptop = new Laptop();
        laptop.setId(id);
        laptop.setBrand(brand);
        laptop.setModel(model);
        laptop.setPrice(price);
        laptop.setRam(ram);
        laptop.setStorage(storage);
        laptop.setImageUrl(imageUrl);
        return laptop;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getRam() { return ram; }
    public void setRam(int ram) { this.ram = ram; }
    public int getStorage() { return storage; }
    public void setStorage(int storage) { this.storage = storage; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
