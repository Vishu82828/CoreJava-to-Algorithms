public class ProductManagementSystem {
    public static void main(String[] args) {
//        Product p1 = new Product("Laptop", 1200.0, 10);
//        Product p2 = new Product("Mouse", 25.0);
        Electronics e1 = new Electronics("Tablet",60.0, 24);
//        p1.applyDiscount(10);
//        System.out.println("Product Name : " + p1.getName());
//        System.out.println("Product Price : " + p1.getPrice());
//        System.out.println("Product In Stock : " + p1.getStock());
//        System.out.println("Product Total Product Created : " + p1.totalProductsCreated);
        System.out.println("Product Warranty Month : " + e1.getWarranty());
        System.out.println("Product Name E! : " + e1.getName());
        e1.applyDiscount(20);
        e1.printDetails();
        System.out.println("Tax on Product : " + e1.calculateTax());
    }
}
abstract class Product{
    private String name;
    protected double price;
    private int stock;
    public static int totalProductsCreated = 0;

    public Product(String name, double price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
        totalProductsCreated++;
    }

    public Product(String name, double price){
        this(name, price, 0);
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public void setPrice(double price){ this.price = price; }
    public double getPrice(){ return price; }

    public void setStock(int stock){ this.stock = stock; }
    public int getStock(){ return stock; }

    public void applyDiscount(double percentage){
        if(percentage < 0 || percentage > 100){
            System.out.println("Invalid discounted");
        }else{
            this.price -= (price * percentage/100);
            System.out.println("Discounted Price = " + this.price);
        }
    }
    public abstract void printDetails();
}
interface Taxable{
    double calculateTax();
}

class Electronics extends Product implements Taxable {
    private int warranty;
    public Electronics(String name, double price, int warranty){
        super(name, price);
        this.warranty = warranty;
    }
    public int getWarranty(){ return warranty; }
    public void setWarranty(int warranty){ this.warranty = warranty;}

    @Override
    public final void applyDiscount(double percentage){
        super.applyDiscount(percentage);
        if(this.price < 50 ){
            this.price = 50;
            System.out.println("Discounted Price = " + this.price);
        }
    }
    @Override
    public void printDetails(){
        System.out.println("Warranty = " + this.warranty + " | Product Name : "+ getName());
    }
    @Override
    public double calculateTax(){
        double Tax = 0;
        Tax = (this.price * 0.18);
        return Tax;
    }
}