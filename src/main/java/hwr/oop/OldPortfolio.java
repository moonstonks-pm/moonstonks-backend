package hwr.oop.old;

import java.util.*;

public class OldPortfolio {
    private Queue<Stock> singleStock;

    public OldPortfolio() {
        singleStock = new LinkedList<>(); //check if LikedList is best Data Struckture
    }

    public void buyStock(Stock stock) {
        singleStock.add(stock);
        System.out.println(stock.toString() + " has been bought!");
    }

    public void sellStock() { //add amount of stocks sold later
        singleStock.remove();
    }

    public boolean IsEmpty(){ //choose stock later
        return singleStock.isEmpty();
    }

    void deletePortfolio() { //for Test
        singleStock.clear();
    }

    @Override
    public String toString(){
        return "Number of Shares: " +  singleStock.size() + "\n" + singleStock.peek().toString();
    }
}