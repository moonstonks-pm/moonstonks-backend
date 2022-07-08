package hwr.oop;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoonStonksTest {

    private Portfolio n;
    private StockSearch ss;
    private IShareMetaData metaData;

    @BeforeEach
    private void setUp() throws IOException, ParseException {
        n = new Portfolio();
        ss = new StockSearch("sap");
    }

    @Nested
    class SharePriceDataTest {  //basically retrieve data test

        @Test
        void getSharePrice_retrievesCorrectData() {
            assertThat(SharePriceData.getSharePrice("SAP", "2022-06-21"))
                    .isEqualTo(89.50);
        }

        @Test
        void getCurrentSharePrice_retrievesCorrectData() {
            assertThat(SharePriceData.getCurrentSharePrice("SAP")).isEqualTo(87.34);
        }
    }

    @Nested
    class ShareMetaDataTest {

        @Test
        void getIndustry_retrievesCorrectIndustry() throws IOException, ParseException {
            metaData = new IndustryData();
            metaData.setSecurityAcronym("SAP");
            assertThat(metaData.allocationData()).isEqualTo(new HashMap<String, Double>() {{
                put("Software", 100.0);
            }});
        }

        @Test
        void getSector_retrievesCorrectSectors() throws IOException, ParseException {
            metaData = new SectorData();
            metaData.setSecurityAcronym("SAP");
            assertThat(metaData.allocationData()).isEqualTo(new HashMap<String, Double>() {{
                put("IT", 100.0);
            }});
        }

        @Test
        void getCountry_retrievesCorrectCountry() throws IOException, ParseException {
            metaData = new CountryData();
            metaData.setSecurityAcronym("SAP");
            assertThat(metaData.allocationData()).isEqualTo(new HashMap<String, Double>() {{
                put("Germany", 100.0);
            }});
        }

        @Test
        void getRegion_retrievesCorrectRegion() throws IOException, ParseException {
            metaData = new RegionData();
            metaData.setSecurityAcronym("SAP");
            assertThat(metaData.allocationData()).isEqualTo(new HashMap<String, Double>() {{
                put("EU", 100.0);
            }});
        }

        @Test
        void getSecurityType_retrievesCorrectType() throws IOException, ParseException {
            metaData = new SecurityTypeData();
            metaData.setSecurityAcronym("SAP");
            assertThat(metaData.allocationData()).isEqualTo(new HashMap<String, Double>() {{
                put("Stock", 100.0);
            }});
        }
    }

    @Nested
    class PortfolioTest {

        @Test
        void buyShares_throwsExceptionForInvalidSecurityPaper() {
            boolean flag = false;
            try {
                n.buyShares("APPL", "2022-06-17", 1);
            } catch (Exception e) {
                assertThat(e).isInstanceOf(RuntimeException.class);
                flag = true;
            }
            assertThat(flag).isTrue();
        }

        @Test
        void buyShares_throwsExceptionForInvalidNumberOfShares() {
            boolean flag = false;
            try {
                n.buyShares("SAP", "2022-06-17", -1);
            } catch (Exception e) {
                assertThat(e).isInstanceOf(RuntimeException.class);
                flag = true;
            }
            assertThat(flag).isTrue();
        }

        @Test
        void buyShares_buyingSharesForFirstTime_CreatesNewKeyValuePair() {  //ToDo write correct test later
            Portfolio p = new Portfolio();
            p.buyShares("SAP", "2022-06-22", 1);
            assertThat(p.value()).isEqualTo(87.34);
        }

        @Test
        void sellShares_throwsExceptionForInvalidSecurityPaper() {
            Portfolio p = new Portfolio();
            boolean flag = false;
            try {
                p.sellShares("SAP", 1);
            } catch (Exception e) {
                assertThat(e).isInstanceOf(RuntimeException.class);
                flag = true;
            }
            assertThat(flag).isTrue();
        }

        @Test
        void sellShares_throwsExceptionForInvalidNumberOfShares() {
            Portfolio p = new Portfolio();
            p.buyShares("SAP", "2022-06-21", 2);
            boolean flag = false;
            try {
                p.sellShares("SAP", 3);
            } catch (Exception e) {
                assertThat(e).isInstanceOf(RuntimeException.class);
                flag = true;
            }
            assertThat(flag).isTrue();
        }

        @Test
        void sellShares_sellingSharesSoThatPortfolioIsEmpty_DeletesKeyValuePair() {
            Portfolio p = new Portfolio();
            p.buyShares("SAP", "2022-06-17", 1);
            p.sellShares("SAP", 1);
            assertThat(p.isEmpty()).isTrue();
        }

    }

    @Nested
    class PortfolioAnalysis {
        private PortfolioAnalyse a;

        @BeforeEach
        void setUpAnalysis(){
            n.buyShares("SAP", "2022-05-26", 4);
            a = new PortfolioAnalyse(n);
        }
        @Test
        void securityTypeAllocation_showsCorrectAllocation() throws IOException, ParseException {
            assertThat(a.securityTypeAllocation()).isEqualTo("Stock: 100,00\n" );
        }
        @Test
        void regionAllocation_showsCorrectAllocation() throws IOException, ParseException {
            assertThat(a.regionAllocation()).isEqualTo("EU: 100,00\n" );
        }

        @Test
        void countryAllocation_showsCorrectAllocation() throws IOException, ParseException {
            assertThat(a.countryAllocation()).isEqualTo("Germany: 100,00\n" );
        }

        @Test
        void sectorAllocation_showsCorrectAllocation() throws IOException, ParseException {
            assertThat(a.sectorAllocation()).isEqualTo("IT: 100,00\n" );
        }

        @Test
        void industryAllocation_showsCorrectAllocation() throws IOException, ParseException {
            assertThat(a.industryAllocation()).isEqualTo("Software: 100,00\n" );
        }

        @Test
        void privateAllocationMethod_worksWithSameAllocationType() throws IOException, ParseException {
            n.buyShares("EUNL", "2022-04-14", 6);
            n.buyShares("IS3N", "2022-03-02", 7);
            a = new PortfolioAnalyse(n);
            assertThat(a.securityTypeAllocation()).isEqualTo("ETF: 63,31\nStock: 36,69\n");
        }
    }

    @Nested
    class PortfolioOutput {

        @Test
        void toStringPortfolioPosition_returnsCorrectString() {
            PortfolioPosition pp = new PortfolioPosition("SAP");
            pp.addShare("2022-06-17", 2);
            assertThat(pp.toString()).hasToString("[88.3, 88.3]");
        }

        @Test
        void getOutput() {
            n.buyShares("SAP", "2022-06-21", 2);
            n.output();
        }

    }

    @Nested
    class StockSearchTest {
        @Test
        void weeklyPerCentDifferenceIsCorrect() throws IOException, ParseException {
            System.out.println(ss.weeklyCourseDifferenceInPercent("2022-06-10"));
        }
    }
}
