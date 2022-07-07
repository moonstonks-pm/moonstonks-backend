package hwr.oop;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class PortfolioAnalyse {

    private Portfolio portfolio;
    private HashMap<String, Double> positions;

    private double portfolioValue;
    PortfolioAnalyse(Portfolio portfolio) {
        this.portfolio = portfolio;
        this.positions = portfolio.getPositionValues();
        this.portfolioValue = portfolio.value();

    }

    HashMap<String, Double> allocation() throws IOException, ParseException {
        HashMap<String, Double> allocation = new HashMap<>();

        for (String securityAcronym : positions.keySet()) { //Bsp: "MSCI World"
            IShareMetaData metaData = new RegionData(securityAcronym);
            double positionValue = positions.get(securityAcronym);

            for (String region : metaData.allocationData().keySet()) {
                double regionPercentage = metaData.allocationData().get(region) / 100;
                if (!allocation.containsKey(region)) {
                    allocation.put(region,
                            positionValue * regionPercentage);
                } else {
                    allocation.computeIfPresent(region, (regionKey, regionValue) ->
                            regionValue += positionValue * regionPercentage);
                }
            }
        }
        return allocation;
    }


    public void analyse() throws IOException, ParseException {
        HashMap<String, Double> allocation = allocation();
        for(String key: allocation.keySet()){
            System.out.println(key + ": " +
                    String.format("%.2f",((allocation.get(key) / portfolioValue)*100)));
        }
    }

}
