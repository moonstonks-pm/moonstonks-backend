package hwr.oop;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class MoonStonksTest {

    private ShareMetaData sap;

    private Portfolio n;

       @BeforeEach
        private void setUp(){
            sap = new ShareMetaData("SAP");
            n = new Portfolio();
        }

    /*       @AfterEach
           private void reset(){
           }*/
        @Nested
        class SharePriceDataTest {  //basically retrieve data test //ToDo test with real data when class is implemented correctly

            @Test
          void getSharePrice_retrievesCorrectData(){
                    assertThat(SharePriceData.getSharePrice("SAP", "2022-06-21"))
                            .isEqualTo(120.42);
            }

            @Test
          void getCurrentSharePrice_retrievesCorrectData(){
                    assertThat(SharePriceData.getSharePrice("SAP")).isEqualTo(89.69);
            }
    }

        @Nested
        class ShareMetaDataTest {  //ToDo name expected outputs w/ variables for better understanding

            @Test
            void getIndustry_retrievesCorrectIndustry(){
                assertThat(sap.getIndustry()).isEqualTo(new String[]{"Software"});
            }

            @Test
            void getSector_retrievesCorrectSectors(){
                assertThat(sap.getSector()).isEqualTo(new String[]{"IT"});
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

        }

        @Nested
        class PortfolioOutput { //would be cooler with @AfterAll but must be static sooo....


        }
}
