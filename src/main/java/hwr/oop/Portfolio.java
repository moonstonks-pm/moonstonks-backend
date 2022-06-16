package hwr.oop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Portfolio {
    private Queue<Stock> singleStock;

    public Portfolio() {
        singleStock = new LinkedList<>(); //check if LikedList is best Data Struckture
    }

    public void buyStock(Stock stock) {
        singleStock.add(stock);
    }

    @Override
    public String toString(){
        return "Number of Shares: " +  singleStock.size() + "\n" + singleStock.peek().toString();
    }
}