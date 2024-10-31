package org.example.electronicdevices;

public class Laptop extends Device {
    private int ramSize;
    private String processorType;

    public Laptop(String name, double price, double weight, int ramSize, String processorType) {
        super(name, price, weight);
        this.ramSize = ramSize;
        this.processorType = processorType;
    }

    @Override
    public String toString() {
        return super.toString() + " - Laptop: " + ramSize + "GB RAM, " + processorType;
    }
}
