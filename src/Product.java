public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;
    public Product(String name , double price , int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public boolean isAvailable(int requestedQty) {
        return quantity >= requestedQty;
    }
    public void reduceQuantity(int qty) {
        quantity -= qty;
    }
    public void increaseQuantity(int qty) {
        quantity += qty;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public abstract boolean isExpired();
}
