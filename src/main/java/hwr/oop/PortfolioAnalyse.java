package hwr.oop;

import java.util.HashMap;

public class PortfolioAnalyse {

    private Portfolio portfolio;
    private HashMap<String, Double> positionValue;

    private double portfolioValue;
    PortfolioAnalyse(Portfolio portfolio) {
        this.portfolio = portfolio;
        this.positionValue = portfolio.getPositionValues();
        this.portfolioValue = portfolio.value();
    }

    private String SecurityTypeAllocation(){
        HashMap<String, Double> securityTypeAllocation = new HashMap<>();
        for(String key: positionValue.keySet()) {
            securityTypeAllocation.computeIfPresent(ShareMetaData.getSecurityType(key),
                    (securityType, overallValue) -> overallValue += positionValue.get(key));

            securityTypeAllocation.computeIfAbsent(ShareMetaData.getSecurityType(key),
                    securityType ->
                            securityTypeAllocation.put(ShareMetaData.getSecurityType(key), positionValue.get(key)));
            }
        return securityTypeAllocation.toString();
    }



}
