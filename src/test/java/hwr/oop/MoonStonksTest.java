package hwr.oop;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoonStonksTest {

    private ShareMetaData sap;

    private Portfolio n;

       @BeforeEach
        private void setUp() throws IOException, ParseException {
            sap = new ShareMetaData("SAP"); //SAP belongs here
            n = new Portfolio();
        }

    /*       @AfterEach
           private void reset(){
           }*/
        @Nested
        class SharePriceDataTest {  //basically retrieve data test

            @Test
          void getSharePrice_retrievesCorrectData(){
                    assertThat(SharePriceData.getSharePrice("SAP", "2022-06-21"))
                            .isEqualTo(89.5000);
            }

            @Test
          void getCurrentSharePrice_retrievesCorrectData(){
                    assertThat(SharePriceData.getCurrentSharePrice("SAP")).isEqualTo(87.34);
            }
    }

        @Nested
        class ShareMetaDataTest {  //ToDo name expected outputs w/ variables for better understanding

            @Test
            void getIndustry_retrievesCorrectIndustry() throws IOException, ParseException {
                assertThat(ShareMetaData.getIndustry("SAP")).isEqualTo(new HashMap<String, Double>(){{put("Software", 100.0);}});
            }

            @Test
            void getSector_retrievesCorrectSectors() throws IOException, ParseException {
                assertThat(ShareMetaData.getSector("SAP")).isEqualTo(new HashMap<String, Double>(){{put("IT", 100.0);}});
            }

            @Test
            void getCountry_retrievesCorrectCountry(){
                assertThat(sap.getCountry()).isEqualTo(new String[]{"Germany"});
            }
            @Test
            void getRegion_retrievesCorrectRegion(){
                assertThat(sap.getRegion()).isEqualTo(new String[]{"Europe"});
            }

            @Test
            void getSecurityType_retrievesCorrectType(){
                assertThat(sap.getSecurityType()).isEqualTo("Stock");
            }
        }
        @Nested
        class PortfolioTest{

            @Test
            void buyShares_throwsExceptionForInvalidSecurityPaper(){
                boolean flag = false;
                try{
                    n.buyShares("APPL","2022-06-17", 1);
                }catch (Exception e) {
                    assertThat(e).isInstanceOf(RuntimeException.class);
                    flag = true;
                }
                assertThat(flag).isTrue();
            }

            @Test
            void buyShares_throwsExceptionForInvalidNumberOfShares(){
                boolean flag = false;
                try{
                    n.buyShares("SAP","2022-06-17", -1);
                }catch (Exception e) {
                    assertThat(e).isInstanceOf(RuntimeException.class);
                    flag = true;
                }
                assertThat(flag).isTrue();
            }
            
            @Test
            void buyShares_buyingSharesForFirstTime_CreatesNewKeyValuePair(){  //ToDo write correct test later
                Portfolio p = new Portfolio();
                p.buyShares("SAP", "2022-06-22", 1);
                assertThat(p.value()).isEqualTo(89.69);
            }

            @Test
            void sellShares_throwsExceptionForInvalidSecurityPaper(){
                Portfolio p = new Portfolio();
                boolean flag = false;
                try{
                    p.sellShares("SAP", 1);
                }catch (Exception e) {
                    assertThat(e).isInstanceOf(RuntimeException.class);
                    flag = true;
                }
                assertThat(flag).isTrue();
            }

            @Test
            void sellShares_throwsExceptionForInvalidNumberOfShares(){
                Portfolio p = new Portfolio();
                p.buyShares("SAP", "2022-06-21", 2);
                boolean flag = false;
                try{
                    p.sellShares("SAP", 3);
                }catch (Exception e){
                    assertThat(e).isInstanceOf(RuntimeException.class);
                    flag = true;
                }
                assertThat(flag).isTrue();
            }

            @Test
            void sellShares_sellingSharesSoThatPortfolioIsEmpty_DeletesKeyValuePair(){  //ToDo write correct test later
                Portfolio p = new Portfolio();
                p.buyShares("SAP", "2022-06-17",1);
                p.sellShares("SAP", 1);
                assertThat(p.value()).isEqualTo(0);
            }

        }

        @Nested
        class PortfolioOutput { //would be cooler with @AfterAll but must be static sooo....

            @Test
            void toStringPortfolioPosition_returnsCorrectString(){
                PortfolioPosition pp = new PortfolioPosition("SAP");
                pp.addShare("2022-06-17", 2);
                assertThat(pp.toString()).hasToString("[120.42, 120.42]");
            }
            @Test
            void getOutput(){
                n.buyShares("SAP", "2022-06-21",2);
                n.output();
            }

        }
}
