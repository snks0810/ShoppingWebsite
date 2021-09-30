package ToyProject;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) throws InterruptedException {
        InitialiseWishlistTest someInstance = new InitialiseWishlistTest();
        someInstance.setUp();
        someInstance.initialiseWishlist();
        ArrayList<Double> prices = new ArrayList<>();
        for(int i = 0; i < someInstance.scrapePrice().size(); i++) {
            prices.add(StringProcessor.poundRemoval(someInstance.scrapePrice()).get(i));
        }
        someInstance.addToCart();
        someInstance.verifyCheapest(StringProcessor.findSmallest(prices));
    }
}