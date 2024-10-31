package org.example.electronicdevices;

public abstract class Device {
    private String name;
    private double price;
    private double weight;

    public Device(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + " (" + price + " USD, " + weight + " kg)";
    }
}
