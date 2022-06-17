package hwr.oop;


class Stock {

    final private String stockAbb;
    private double stockBidPrice;

    Stock(String stockAbb){ //better from data base
        this.stockAbb = stockAbb;
        stockBidPrice = 120;
    }

    @Override
    public String toString(){
        return "Stock name: " + stockAbb + "\nStock bid price: " + stockBidPrice;
    }
}
