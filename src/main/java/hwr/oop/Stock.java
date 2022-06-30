package hwr.oop.old;


import java.util.Date;

class Stock{

    private final double stockPrice;
    private final String companyAbb;

    Stock(String companyAbb) {
        this.companyAbb = companyAbb;
        this.stockPrice = 120;
    }

    @Override
    public String toString() {
        return "Stock name: " + companyAbb + "\nStock bid price: " + stockPrice;
    }
}
