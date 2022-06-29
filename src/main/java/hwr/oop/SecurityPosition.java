package hwr.oop;

import java.util.LinkedList;
import java.util.Queue;

public class SecurityPosition {

    private final SecurityMetaData metaData;
    private double priceGainsRealized;
    private Queue<Double> shares;

    SecurityPosition(String securityAcronym){
        metaData = new SecurityMetaData(securityAcronym);
        shares = new LinkedList<Double>();

    }

    void addShare(String purchaseDate, int numberOfSharesBought){
        for(int i = 1; i < numberOfSharesBought; i++) {
            shares.add(SecurityPriceData.getSharePrice(metaData.getSecurityAcronym(), purchaseDate));
        }
    }

    void removeShare(int numberOfSharesSold){
        for(int i = 1; i < numberOfSharesSold; i++) {
            priceGainsRealized +=
                    SecurityPriceData.getSharePrice(metaData.getSecurityAcronym()) - shares.poll();
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
        return SecurityPriceData.getSharePrice(metaData.getSecurityAcronym());
    }

    boolean isEmpty(){
        return shares.isEmpty();
    }

}
