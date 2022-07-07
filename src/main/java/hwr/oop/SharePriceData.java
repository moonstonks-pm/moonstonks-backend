package hwr.oop;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;

//W6PWPCMUGT51Z4O1
class SharePriceData {

    static JSONObject readJsonFile(String type, String securityAcronym) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("src/main/java/hwr/oop/data/" + type + securityAcronym + ".json");
        Object jsonObj = parser.parse(reader);
        JSONObject jsonObject = (JSONObject) jsonObj;
        return jsonObject;
    }
    static double getSharePrice(String securityAcronym, String purchaseDate) {
        try {
            JSONObject timeSeries = (JSONObject) readJsonFile("daily", securityAcronym).get("Time Series (Daily)");
            JSONObject date = (JSONObject) timeSeries.get(purchaseDate);
            String price = (String) date.get("1. open");
            double priceDouble = Double.parseDouble(price);
            BigDecimal bd=new BigDecimal(priceDouble).setScale(2, RoundingMode.HALF_DOWN);
            return priceDouble;
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    static double getCurrentSharePrice(String securityAcronym) {
        //current Date is hardcoded because of the usage of JSON Files instead of a responsive API
        try {
            JSONObject timeSeries = (JSONObject) readJsonFile("daily", securityAcronym).get("Time Series (Daily)");
            JSONObject date = (JSONObject) timeSeries.get("2022-06-30");
            String price = (String) date.get("1. open");
            double currentPrice = Double.parseDouble(price);
            return currentPrice;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
