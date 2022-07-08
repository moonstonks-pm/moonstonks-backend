package hwr.oop;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
    public Double monthlyCourseDifference(String month) throws IOException, ParseException {
        JSONObject timeSeries = (JSONObject) readJsonFile("monthly", this.security).get("Monthly Time Series");
        JSONObject monthDate = (JSONObject) timeSeries.get(month);
        String openPrice = (String) monthDate.get("1. open");
        String closePrice = (String) monthDate.get("4. close");

        Double dOpenPrice = Double.parseDouble(openPrice);
        Double dClosePrice = Double.parseDouble(closePrice);

        Double monthlyDifferencePercent = (dClosePrice/dOpenPrice - 1)*100;
        Double roundDifference = Double.valueOf(Math.round(monthlyDifferencePercent*100.0)/100.0);
        return roundDifference;

    }
    public Double maxCourseDifference() throws IOException, ParseException {
        JSONObject timeSeries = (JSONObject) readJsonFile("monthly", this.security).get("Monthly Time Series");
        Object[] timeSeriesSet = timeSeries.keySet().toArray();
        String[] timeSeriesArray = Arrays.copyOf(timeSeriesSet, timeSeriesSet.length, String[].class);
        JSONObject oldestPrice = (JSONObject) timeSeries.get(timeSeriesArray[timeSeriesArray.length-1]);
        JSONObject newestPrice = (JSONObject) timeSeries.get(timeSeriesArray[0]);

        String open = (String) oldestPrice.get("1. open");
        String close = (String) newestPrice.get("4. close");

        Double dOpenPrice = Double.parseDouble(open);
        Double dClosePrice = Double.parseDouble(close);

        Double monthlyDifferencePercent = (dClosePrice/dOpenPrice - 1)*100;
        Double roundDifference = Double.valueOf(Math.round(monthlyDifferencePercent*100.0)/100.0);
        return roundDifference;
    }
}
