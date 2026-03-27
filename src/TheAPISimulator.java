import static java.lang.Math.*;
import java.util.ArrayList;

public class TheAPISimulator {
    public static void main(String[] args) {

        ArrayList<String> apiData = new ArrayList<>();
        apiData.add("100");
        apiData.add("200");
        apiData.add("abcd"); // add invalid data outside loop

        for (String api : apiData) {
            try {
                PriceCalculator.processPrice(api);
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid data [" + api + "] - " + e.getMessage());
            }
        }
    }
}

class PriceCalculator {
    public static void processPrice(String rawPrice) {
        double price = Double.parseDouble(rawPrice);

        price = sqrt(price);
        System.out.println("Square Root of price : " + price);

        price = pow(price, 2);
        System.out.println("Power of price is " + price);
    }
}