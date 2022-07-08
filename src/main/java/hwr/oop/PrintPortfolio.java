package hwr.oop;

import java.util.HashMap;

public class PrintPortfolio {



    public static void printPortfolioAndAnalysis(Portfolio portfolio){
        System.out.println("\nPortfolio Positions: ");
        System.out.println("___________________________________________________" +
                "_______________________________________________________________________");
        System.out.println(portfolio.stringOutput());
        System.out.println("Analyse: \n");
        System.out.println("___________________________________________________" +
                "_______________________________________________________________________");
        PortfolioAnalyse portfolioAnalyse = new PortfolioAnalyse(portfolio);
        System.out.println("Security type allocation: \n\n" + portfolioAnalyse.securityTypeAllocation());
        System.out.println("Industry allocation: \n\n" + portfolioAnalyse.industryAllocation());
        System.out.println("Sector allocation: \n\n" + portfolioAnalyse.sectorAllocation());
        System.out.println("Country allocation: \n\n" + portfolioAnalyse.countryAllocation());
        System.out.println("Region allocation: \n\n" + portfolioAnalyse.regionAllocation());

    }
}
