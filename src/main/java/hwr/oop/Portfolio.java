package hwr.oop;

import javax.sound.sampled.Port;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Portfolio {

    private HashMap<String, PortfolioPosition> portfolio;

    private static final String[] securitiesAvailableArray = new String[]{"SAP"};

    private static final HashSet<String> securitiesAvailable =
            new HashSet<>(Arrays.asList(securitiesAvailableArray));

    Portfolio(){ //maybe add name of owner or sth
        this.portfolio = new HashMap<>();
    }

    public void buyShares(String companyAcronym, String purchaseDate, int numberOfShares){
        if(!securitiesAvailable.contains(companyAcronym))
            throw new RuntimeException("Security paper not available!");
        if(numberOfShares < 1)
            throw new RuntimeException("Invalid number of shares");

        if(!portfolio.containsKey(companyAcronym)){
            portfolio.put(companyAcronym,new PortfolioPosition(companyAcronym));
        }
        portfolio.get(companyAcronym).addShare(purchaseDate, numberOfShares);
    }

    public void sellShares(String companyAcronym, int numberOfShares){
        if(!portfolio.containsKey(companyAcronym))
            throw new RuntimeException("You don't own that security paper!");
        if(numberOfShares > portfolio.get(companyAcronym).getPositionSize())
            throw new RuntimeException("You don't own this many shares");

        portfolio.get(companyAcronym).removeShare(numberOfShares);

        if(portfolio.get(companyAcronym).isEmpty()){
            portfolio.remove(companyAcronym);
        }
    }

    public double value(){
        double totalValue = 0;
        for(PortfolioPosition position : portfolio.values()){
            totalValue+= position.getCurrentValue();
        }
        return totalValue;
    }

    public void output(){
        for(String key : portfolio.keySet()){ //ToDo correct formatting and maybe add analytics
            System.out.println(key + "| Amount Deposited: " + portfolio.get(key).getAmountDeposited() +
                    "| Current Value: " + portfolio.get(key).getCurrentValue() +
                    "| price Gains: " + (portfolio.get(key).getCurrentValue() - portfolio.get(key).getAmountDeposited()) +
                    "| buy in: " + (portfolio.get(key).getAmountDeposited() / portfolio.get(key).getPositionSize()) +
                    "| # of Shares: " + portfolio.get(key).getPositionSize());
        }
    }
}
