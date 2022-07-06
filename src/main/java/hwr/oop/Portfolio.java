package hwr.oop;

import javax.sound.sampled.Port;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Portfolio {

    private static final int minNumberOfSharesToBeBought = 1;
    private HashMap<String, PortfolioPosition> portfolio;

    public Portfolio(){ //maybe add name of owner or sth
        this.portfolio = new HashMap<>();
    }

    public void buyShares(String securityAcronym, String purchaseDate, int numberOfShares){
        securityAcronym = securityAcronym.toUpperCase();

        if(!new StockSearch(securityAcronym).securityIsAvailable())
            throw new RuntimeException("Security paper not available!");

        if(numberOfShares < minNumberOfSharesToBeBought)
            throw new RuntimeException("Invalid number of shares");

        if(!this.hasSecurity(securityAcronym)){
            portfolio.put(securityAcronym,new PortfolioPosition(securityAcronym));
        }
        portfolio.get(securityAcronym).addShare(purchaseDate, numberOfShares);
    }

    public void sellShares(String securityAcronym, int numberOfShares){
        securityAcronym = securityAcronym.toUpperCase();

        if(!this.hasSecurity(securityAcronym))
            throw new RuntimeException("You don't own that security paper!");

        if(numberOfShares > portfolio.get(securityAcronym).getPositionSize())
            throw new RuntimeException("You don't own this many shares");

        portfolio.get(securityAcronym).removeShare(numberOfShares);

        if(portfolio.get(securityAcronym).isEmpty()){
            portfolio.remove(securityAcronym);
        }
    }

    public double value(){
        double totalValue = 0;
        for(PortfolioPosition position : portfolio.values()){
            totalValue+= position.getCurrentValue();
        }
        return totalValue;
    }

    public boolean hasSecurity(String securityAcronym) {
        return portfolio.containsKey(securityAcronym);
    }

    public void output(){
        for(String key : portfolio.keySet()){ //ToDo correct formatting and maybe add analytics
            System.out.println(key + "| Amount Deposited: " + portfolio.get(key).getAmountDeposited() +
                    "| Current Value: " + portfolio.get(key).getCurrentValue() +
                    String.format("| price Gains:  %.2f",
                            (portfolio.get(key).getCurrentValue() - portfolio.get(key).getAmountDeposited())) +
                    "| buy in: " + (portfolio.get(key).getAmountDeposited() / portfolio.get(key).getPositionSize()) +
                    "| # of Shares: " + portfolio.get(key).getPositionSize());
        }
    }
}
