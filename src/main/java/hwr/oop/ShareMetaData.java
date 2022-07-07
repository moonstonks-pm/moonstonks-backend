package hwr.oop;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

class ShareMetaData extends SharePriceData {

    private final HashMap<String, Double> sector;
    private final HashMap<String, Double> industry;
    private final HashMap<String, Double> region;
    private final HashMap<String, Double> country;
    private final String securityAcronym;
    private final String securityType;

    ShareMetaData(String securityAcronym) throws IOException, ParseException {  //  ToDo get constructor information from JSON-File API
        this.securityAcronym = securityAcronym;
        this.industry= new HashMap<>(){{
            JSONObject metaData = (JSONObject) SharePriceData.readJsonFile("meta", securityAcronym).get("MetaData");
            JSONArray industry = (JSONArray) metaData.get("industry");

            for (int i = 0; i < industry.size(); i++) {
                JSONObject meta = (JSONObject) industry.get(i);
                String name = (String) meta.get("name");
                Long share = (Long) meta.get("share");

                String sName = name;
                Double dShare = Double.valueOf(share);
                put(sName, dShare);
            }
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
    static HashMap<String, Double> getSector(String securityAcronym) throws IOException, ParseException { //TODO Care for sector
        return new HashMap<>(){{
            JSONObject metaData = (JSONObject) SharePriceData.readJsonFile("meta", securityAcronym).get("MetaData");
            JSONArray sector = (JSONArray) metaData.get("sector");

            for (int i = 0; i < sector.size(); i++) {
                JSONObject meta = (JSONObject) sector.get(i);
                String name = (String) meta.get("name");
                Long share = (Long) meta.get("share");

                String sName = name;
                Double dShare = Double.valueOf(share);
                put(sName, dShare);
            }
        }};
    }

    static HashMap<String, Double> getIndustry(String securityAcronym) throws IOException, ParseException {
        return new HashMap<>(){{
            JSONObject metaData = (JSONObject) SharePriceData.readJsonFile("meta", securityAcronym).get("MetaData");
            JSONArray industry = (JSONArray) metaData.get("industry");

            for (int i = 0; i < industry.size(); i++) {
                JSONObject meta = (JSONObject) industry.get(i);
                String name = (String) meta.get("name");
                Long share = (Long) meta.get("share");

                String sName = name;
                Double dShare = Double.valueOf(share);
                put(sName, dShare);
            }
        }};
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
