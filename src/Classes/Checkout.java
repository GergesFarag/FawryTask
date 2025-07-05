package Classes;

import Services.ShippingService;

public class Checkout {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Classes.Cart is empty");
        }

        double subtotal = cart.calculateSubtotal();
        double shipping = cart.calculateShipping();
        double total = subtotal + shipping;

        if (!customer.canPay(total)) {
            throw new IllegalStateException("Classes.Customer's balance is insufficient");
        }

        ShippingService.ship(cart.getShippableItems());
        customer.addHistory(cart);
        System.out.println("** Classes.Checkout receipt **");
        for (CartProduct item : cart.getItems()) {
            System.out.printf("%dx %s\t%.1f$%n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }
        System.out.printf("----------------------%nSubtotal\t%.0f$%nShipping\t%.0f$%nAmount\t%.0f$%n Process Done Successfully\n",
                subtotal, shipping, total);

        customer.pay(total);
        System.out.printf("Customer balance after payment: %.2f$%n", customer.getBalance());
    }
}