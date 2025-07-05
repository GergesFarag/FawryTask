import java.util.Stack;

class Customer {
    private String name;
    private double balance;
    private Stack<Cart> cartHistory;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        cartHistory = new Stack<Cart>();
    }

    public boolean canPay(double amount) {
        return balance >= amount;
    }

    public void pay(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void addHistory(Cart cart) {
        cartHistory.push(cart);
    }

    public void clearHistory() {
        cartHistory.clear();
    }

    public String getName() {
        return this.name;
    }

    public void showHistory() {
        if (cartHistory.isEmpty())
            System.out.println("History is Empty!");
        else
            cartHistory.forEach(cart ->
                    System.out.printf("----------------------\nCart Identifier : %s\nCart Products Quantity : %s products\nCart Total Price : %.1f$%n----------------------\n", cart, cart.getItems().size(), cart.getTotalCartPrice()));
    }
}