package hwr.oop;


class Stock {

    final private String stockAbb;
    private double stockBidPrice;

    Stock(String stockAbb){
        this.stockAbb = stockAbb;
        stockBidPrice = 120; //get this from Market Interface Later
    }

    @Override
    public String toString(){
        return "Stock name: " + stockAbb + "\nStock bid price: " + stockBidPrice;
    }
}
