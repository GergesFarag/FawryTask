import Classes.*;
import Models.Shippable;
import Classes.*;
public class Main {
    public static void main(String[] args) {
        Product cheese = new ExpProduct("Cheese", 100, 5, false);
        Product biscuits = new ExpProduct("Biscuits", 150, 3, false);
        Product tv = new ShippableProduct("TV", 5000, 4, 700, false);
        Product mobileScreen = new NonExpProduct("Mobile Screen", 50, 10);

        Customer customer = new Customer("Gerges", 10000);

        Cart cart = new Cart();
        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 1);
        cart.addProduct(tv, 1);
        cart.addProduct(mobileScreen, 1);

        try {
            Checkout.checkout(customer, cart);
            System.out.printf("%s's Classes.Cart History:\n" , customer.getName());
            customer.showHistory();
//            customer.clearHistory();
//            System.out.printf("%s's classes.Classes.Cart History:\n" , customer.getName());
//            customer.showHistory();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

//        Error Trial
//        cart.addProduct(cheese, 5);
//        cart.addProduct(tv, 3);
//        try {
//            classes.Classes.Checkout.checkout(customer, cart);
//        } catch (Exception e) {
//            System.out.println("ERROR: " + e.getMessage());
//        }
    }
}