package hwr.oop;

public class PortfolioAnalyse {

    private Portfolio portfolio;
    private HashMap<String, Double> positionValue;

    private double portfolioValue;
    PortfolioAnalyse(Portfolio portfolio) {
        this.portfolio = portfolio;
        this.positionValue = portfolio.getPositionValues();
        this.portfolioValue = portfolio.value();

    }

    public String SecurityTypeAllocation(){
        HashMap<String, Double> securityTypeAllocation = new HashMap<>();
        for(String key: positionValue.keySet()) {
            if(!securityTypeAllocation.containsKey(ParseShareMetaData.getSecurityType(key))){
                securityTypeAllocation.put(ParseShareMetaData.getSecurityType(key), positionValue.get(key));
            }else{
                securityTypeAllocation.computeIfPresent(ParseShareMetaData.getSecurityType(key),
                        (securityType, overallValue) -> overallValue += positionValue.get(key));
            }
        }
        return securityTypeAllocation.toString();
    }

}
