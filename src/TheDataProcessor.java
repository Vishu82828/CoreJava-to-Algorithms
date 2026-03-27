public class TheDataProcessor {
    public static void main(String [] args) {
        String priceStr = "1000";
        DataUtility.processData(priceStr);
        try {
            DataUtility.processData("12e4");
        } catch (NumberFormatException e) {
            System.out.println("Invalid price" + e.getMessage());
        }
    }
}

class DataUtility{
    public static void processData(String input){
        if(input == null){
//            throw new NumberFormatException("Please enter a string");
            System.out.println("Input is null!");
            return;
        }
        Integer num = Integer.valueOf(input);
        num += (num*10/100);
        String str = String.valueOf(num);
        System.out.println("Processed Value : "+str);
    }
}