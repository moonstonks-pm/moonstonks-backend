package hwr.oop;

import java.util.HashMap;

class ShareMetaData {

    static HashMap<String, Double> getSector() {
        return new HashMap<>(){{
            put("software", 100.0);
        }};
    }
    static HashMap<String, Double> getIndustry(){
        return new HashMap<>(){{
            put("it", 100.0);
        }};
    }

    static HashMap<String, Double> getCountry(){
        return new HashMap<>(){{
            put("germany", 100.0);
        }};
    }

    static HashMap<String, Double> getRegion() {
        return new HashMap<>(){{
            put("europe", 100.0);
        }};
    }

    static String getSecurityType(String securityAcronym) {
        return "Stock";
    }
}
