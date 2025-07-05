package Classes;

import Models.Shippable;

public class ShippableProduct extends Product implements Shippable {
    private double weight;
    private boolean isExpired;
    public ShippableProduct(String name, double price, int quantity, double weight ,boolean isExpired) {
        super(name, price, quantity);
        this.weight = weight;
        this.isExpired = isExpired;
    }

    @Override
    public boolean isExpired() {
        return isExpired;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}