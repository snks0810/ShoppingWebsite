package ToyProject;

import java.util.ArrayList;
import java.util.List;

public class StringProcessor {

    public static ArrayList<Double> poundRemoval(ArrayList<String> priceList){
        ArrayList<Double> output = new ArrayList<>();
        int length = priceList.size();
        for(int i = 0; i < length; i++){
            String currentPrice = priceList.get(i);
            String smallerString = currentPrice.substring(currentPrice.length() - 5);
            smallerString.replace("£","");
            double someOutput = Double.valueOf(smallerString);
            //System.out.println(someOutput);
            output.add(someOutput);
        }
        return output;
    }

    public static double findSmallest(ArrayList<Double> someNumbers){
        double smallestNumber = 100;
        int length = someNumbers.size();
        for(int i = 0; i < length; i++){
            if( someNumbers.get(i) < smallestNumber){
                smallestNumber = someNumbers.get(i);
            }
        }
        return smallestNumber;
    }
}
