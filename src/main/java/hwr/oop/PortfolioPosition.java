package hwr.oop;

import java.util.LinkedList;
import java.util.Queue;

public class PortfolioPosition {

    private final ShareMetaData metaData;

    private final String securityAcronym;
    private double priceGainsRealized;
    private Queue<Double> shares;

    PortfolioPosition(String securityAcronym){
        this.securityAcronym = securityAcronym;
        metaData = new ShareMetaData(securityAcronym);  //do I really need this here?
        shares = new LinkedList<Double>();

    }

    void addShare(String purchaseDate, int numberOfSharesBought){
        for(int i = 1; i < numberOfSharesBought; i++) {
            shares.add(SharePriceData.getSharePrice(securityAcronym, purchaseDate));
        }
    }

    void removeShare(int numberOfSharesSold){
        for(int i = 1; i < numberOfSharesSold; i++) {
            priceGainsRealized +=
                    SharePriceData.getSharePrice(securityAcronym) - shares.poll();
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

    double getCurrentPricePerShare(){
        return SharePriceData.getSharePrice(securityAcronym);
    }

    boolean isEmpty(){
        return shares.isEmpty();
    }

}
