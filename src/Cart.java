import java.util.ArrayList;
import java.util.List;

class Cart {
    private final List<CartProduct> products = new ArrayList<>();

    public void addProduct(Product product, int qty) {
        if (product.isExpired()) {
            throw new IllegalArgumentException("Expired Product");
        }

        if (!product.isAvailable(qty)) {
            throw new IllegalArgumentException("Quantity exceeds available quantity");

        }
        products.add(new CartProduct(product, qty));
        product.reduceQuantity(qty);
    }

    public List<CartProduct> getItems() {
        return products;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public double calculateSubtotal() {
        return products.stream().mapToDouble(CartProduct::getTotalPrice).sum();
    }

    public double calculateShipping() {
        return products.stream()
                .filter(CartProduct::isShippable)
                .count() * 10;
    }
    public double getTotalCartPrice(){
        return this.calculateShipping() + this.calculateSubtotal();
    }
    public List<Shippable> getShippableItems() {
        List<Shippable> list = new ArrayList<>();
        for (CartProduct item : products) {
            if (item.getProduct() instanceof Shippable) {
                list.add((Shippable) item.getProduct());
            }
        }
        return list;
    }
}