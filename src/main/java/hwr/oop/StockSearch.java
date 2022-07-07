package hwr.oop;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class StockSearch extends SharePriceData {

    private static final String earliestDatePossible = "2022-02-01";
    private static final String[] securitiesAvailableArray = new String[]{"SAP", "IBM", "MBG", "EUNL", "IS3N", "SXRJ"};

    private static final HashSet<String> securitiesAvailable =
            new HashSet<>(Arrays.asList(securitiesAvailableArray));

    private final String security;
    private final String earliestDate;


    public StockSearch(String securityAcronym){
        this.security = securityAcronym.toUpperCase();
        this.earliestDate = earliestDatePossible;
    }
    public boolean securityIsAvailable(){
        return securitiesAvailable.contains(security);
    }

    public Double weeklyCourseDifferenceInPercent(String date) throws IOException, ParseException {
        JSONObject timeSeries = (JSONObject) readJsonFile("weekly", this.security).get("Weekly Time Series");
        JSONObject week = (JSONObject) timeSeries.get(date);
        String openPrice = (String) week.get("1. open");
        String closePrice = (String) week.get("4. close");

        Double dOpenPrice = Double.parseDouble(openPrice);
        Double dClosePrice = Double.parseDouble(closePrice);

        Double weeklyDifferencePercent = (dClosePrice/dOpenPrice - 1)*100;
        Double roundDifference = Double.valueOf(Math.round(weeklyDifferencePercent*100.0)/100.0);
        return roundDifference;
    }
    public void monthlyCourseDifference(String month) {
        //ToDo return monthly Data

    }
    public void maxCourseDifference() {
    //ToDo return difference between dateToday and earliest date Possible
    }

    //ToDo do costume dates if there is time
}
