import java.util.ArrayList;
public class SmartCheckout {
    public static void main(String[] args) {
        ArrayList<StoreProduct> cart = new ArrayList<>();
        cart.add(new ElectronicsProduct("Smartphone", 500.0));
        cart.add(new DigitalSoftware("Antivirus", 50.0));

        for (StoreProduct p : cart) {
            p.displayTaxInfo();
            if (p instanceof Discountable) {
                Discountable discount = (Discountable) p;
                discount.applyVoucher(50.0);
            }
        }

        try {
            cart.add(new ElectronicsProduct("Smartphone", -50.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Error Adding Item" + e.getMessage());
        }
    }
}

abstract class StoreProduct{
    private String name;
    protected double price;
    public StoreProduct(String name, double price){
        if(price < 0){
            throw new IllegalArgumentException("Price cannot be negative. ");
        }
        this.name = name;
        this.price = price;
    }
    public String getName(){return name;}
    public double getPrice(){return price;}

    public abstract void displayTaxInfo();

    public final void getInvoiceHeader(){
        System.out.println("--- OFFICIAL INVOICE ---");
    }
}

interface Discountable{
    void applyVoucher(double amount);
}

class ElectronicsProduct extends StoreProduct implements Discountable{
    final double WarrantyFee = 20.0;
    public ElectronicsProduct(String name, double price){
        super(name, price);
    }
    @Override
    public void displayTaxInfo(){
        getInvoiceHeader();
        System.out.println("ElectronicsProduct tax applied 18% for ["+ getName()+"].");
    }
    @Override
    public void applyVoucher(double amount){
        this.price -= amount;
        System.out.println("New Price After voucher for ["+ this.price+"].");
    }
}

class DigitalSoftware extends StoreProduct{
    public DigitalSoftware(String name, double price){
        super(name, price);
    }
    @Override
    public void displayTaxInfo(){
        System.out.println("Digital tax applied 5% for ["+ getName()+"].");
    }
}