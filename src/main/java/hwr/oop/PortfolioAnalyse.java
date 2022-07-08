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

    public String regionAllocation(){
        IShareMetaData regionData = new RegionData();
        return stringifyAllocationData(allocation(regionData));
    }

    public String countryAllocation(){
        IShareMetaData countryData = new CountryData();
        return stringifyAllocationData(allocation(countryData));
    }

    public String industryAllocation(){
        IShareMetaData industryData = new IndustryData();
        return stringifyAllocationData(allocation(industryData));
    }

    public String sectorAllocation(){
        IShareMetaData sectorData = new SectorData();
        return stringifyAllocationData(allocation(sectorData));
    }

    public String securityTypeAllocation(){
        IShareMetaData securityType = new SecurityTypeData();
        return stringifyAllocationData(allocation(securityType));
    }

    private HashMap<String, Double> allocation(IShareMetaData metaData){
        HashMap<String, Double> allocation = new HashMap<>();

        for (String securityAcronym : positions.keySet()) { //Bsp: "MSCI World"
            metaData.setSecurityAcronym(securityAcronym);
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


    private String stringifyAllocationData(HashMap<String, Double> allocationData){
        String stringifiedAllocationData = "";
        for(String allocation: allocationData.keySet()){
            stringifiedAllocationData += String.format("%s: ",allocation) +
                    String.format("%.2f\n",((allocationData.get(allocation) / portfolioValue)*100));
        }
        return stringifiedAllocationData;
    }

}
