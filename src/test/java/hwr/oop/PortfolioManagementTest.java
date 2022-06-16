package hwr.oop;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PortfolioManagementTest {

    private final String stockNameAAPL = "AAPL";
    private final double stockBidPrice120 = 120;
    private Stock stock;
    private Portfolio portfolio;

    @BeforeEach
    private void setUp(){
        stock = new Stock(stockNameAAPL);
        portfolio = new Portfolio();
        portfolio.buyStock(stock);
    }

    @Nested
    class StockTest {
        @Test
        void Stock_hasCorrectToStringMethod(){
            assertThat(stock).hasToString("Stock name: " + stockNameAAPL + "\nStock bid price: " + stockBidPrice120);
        }
    }

    @Nested
    class PortfolioTest {

        @Test
        void Portfolio_hasCorrectToStringMethod(){
            assertThat(portfolio).hasToString("Number of Shares: " +  1 + "\n" + "Stock name: " + stockNameAAPL + "\nStock bid price: " + stockBidPrice120);
        }

    }

    @Nested
    class PortfolioOutput { //would be cooler with @AfterAll but must be static sooo....
        @DisplayName("Just for Visuals")
        @Test
        void show(){
            System.out.println(portfolio);
        }

    }
}
