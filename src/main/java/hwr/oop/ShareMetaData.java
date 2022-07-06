package hwr.oop;

import java.util.HashMap;

class ShareMetaData {

    private final HashMap<String, Double> sector;
    private final HashMap<String, Double> industry;
    private final HashMap<String, Double> region;
    private final HashMap<String, Double> country;
    private final String securityAcronym;
    private final String securityType;

    ShareMetaData(String securityAcronym) {  //  ToDo get constructor information from JSON-File API
        this.securityAcronym = securityAcronym;
        this.industry= new HashMap<>(){{
            put("it", 100.0);
        }};
        this.sector = new HashMap<>(){{
            put("software", 100.0);
        }};
        this.country = new HashMap<>(){{
            put("germany", 100.0);
        }};
        this.region =  new HashMap<>(){{
            put("europe", 100.0);
        }};
        this.securityType = "Stock";
    }
    HashMap<String, Double> getSector() {
        return this.sector;
    }

    HashMap<String, Double> getIndustry(){
        return this.industry;
    }

    HashMap<String, Double> getCountry(){
        return this.country;
    }

    HashMap<String, Double> getRegion() {
        return this.region;
    }

    String getSecurityType() {
        return this.securityType;
    }
}
