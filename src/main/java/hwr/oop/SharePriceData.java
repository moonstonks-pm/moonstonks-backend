package hwr.oop;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.Reader;

//W6PWPCMUGT51Z4O1
class SharePriceData {
    static double getSharePrice(String securityAcronym, String purchaseDate) {
        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("src/main/java/hwr/oop/data/daily" + securityAcronym + ".json");

            Object jsonObj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) jsonObj;
            JSONObject timeSeries = (JSONObject) jsonObject.get("Time Series (Daily)");
            JSONObject date = (JSONObject) timeSeries.get(purchaseDate) ;

            String price = (String) date.get("1. open");
            System.out.println(securityAcronym + ": " + price);
            double priceDouble = Double.parseDouble(price);
            return priceDouble;
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    static double getCurrentSharePrice(String securityAcronym) {
        //current Date is hardcoded because of the usage of JSON Files instead of a responsive API
        return 89.69;
    }
}
