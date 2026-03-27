import java.util.ArrayList;
public class SmartWarehouse {
    public static void main(String[] args) {
//        GlassJar gj = new GlassJar("01", 501,25000.00, 4.00);
        WarehouseItem myItem = new GlassJar("J1", 101, 20.0, 2.0);
        System.out.println("Total no of Items : "+ GlassJar.totalItems );
//        gj.performSafetyCheck();
//        gj.packageWithBubbleWrap();
        ArrayList<WarehouseItem> Item = new ArrayList<>();
        Item.add(new GlassJar("j1", 101, 20.0, 2.0));
        Item.add(new ChemicalDrum("d1",201,40.0));

        for(WarehouseItem item : Item){
            item.performSafetyCheck();
            if(item instanceof Fragile){
                Fragile fragileItem = (Fragile) item;
                fragileItem.packageWithBubbleWrap();
            }
        }
        try{
            Item.add(new GlassJar("j1", 102, -10.0, 2.0));
        } catch(IllegalArgumentException e){
            System.out.println("Error adding item : "+e.getMessage());
        }
    }
}

abstract class WarehouseItem {
    private String id;
    private int shelfLocation;
    protected double baseValue;
    public static int totalItems = 0;

    public WarehouseItem(String id, int shelfLocation, double baseValue) {
        this.id = id;
        this.shelfLocation = shelfLocation;
        this.baseValue = baseValue;
        totalItems++;
        if(baseValue < 0){
            throw new IllegalArgumentException(" Price can not be negative! ");
        }
    }

    public String getId() { return id; }
    public int getShelfLocation() { return shelfLocation; }
    public double getBaseValue() { return baseValue; }

    public abstract void performSafetyCheck();
}

interface Fragile{
    public void packageWithBubbleWrap();
}

class GlassJar extends WarehouseItem implements Fragile{
    private double thickness;
    public GlassJar(String id, int shelfLocation, double baseValue, double thickness) {
        super(id, shelfLocation, baseValue);
        this.thickness = thickness;
    }

    public double getThickness() { return thickness; }

    @Override
    public void performSafetyCheck() {
        System.out.println("Checking for crack in Jar ["+ getId()+"]");
    }
    @Override
    public void packageWithBubbleWrap() {
        System.out.println("Applying 3 layerd of wrap to Jar ["+ getId()+"]");
    }
}

class ChemicalDrum extends WarehouseItem{
    public ChemicalDrum(String id, int shelfLocation, double baseValue){
        super(id, shelfLocation, baseValue);
    }
    public void performSafetyCheck() {
        System.out.println("Checking seal integrity for Drum ["+ getId()+"]");
    }
}