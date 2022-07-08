package hwr.oop;

import java.util.LinkedList;
import java.util.Queue;

public class PortfolioPosition {

    private final String securityAcronym;
    private double priceGainsRealized;
    private Queue<Double> shares;

    PortfolioPosition(String securityAcronym){
        this.securityAcronym = securityAcronym;
        shares = new LinkedList<Double>();

    }

    void addShare(String purchaseDate, int numberOfSharesBought){
        for(int i = 0; i < numberOfSharesBought; i++) {
            shares.add(SharePriceData.getSharePrice(securityAcronym, purchaseDate));
        }
    }

    void removeShare(int numberOfSharesSold){
        for(int i = 0; i < numberOfSharesSold; i++) {
            priceGainsRealized +=
                    SharePriceData.getCurrentSharePrice(securityAcronym) - shares.poll();
        }
    }

    int getPositionSize(){
        return shares.size();
    }

    double getAmountDeposited(){
        double deposited = 0;
        for (Double share: shares){
            deposited += share;
        }
        return deposited;
    }

    double getCurrentValue(){
        return SharePriceData.getCurrentSharePrice(securityAcronym) * shares.size();
    }

    boolean isEmpty(){
        return shares.isEmpty();
    }

    @Override
    public String toString(){
        return shares.toString();
    }

}
