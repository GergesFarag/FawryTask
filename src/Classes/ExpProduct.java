package Classes;

public class ExpProduct extends Product{
    private boolean isExpired;
    public ExpProduct(String name , double price , int quantity , boolean isExpired){
        super(name , price , quantity);
        this.isExpired = isExpired;
    }

    @Override
    public boolean isExpired() {
        return isExpired;
    }
}
