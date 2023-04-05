package org.openjfx;

public class SoftToys extends Product {

    private String material;
    public SoftToys(String name, double price, int quantity, String manufacturer, String material) {
        super(name, price, quantity, manufacturer);
        this.material = material;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    @Override
    public String getInfo() {
        return super.getInfo() + ", материал: " + material;
    }
}