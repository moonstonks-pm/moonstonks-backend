package hwr.oop;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

class ShareMetaData extends SharePriceData {
    static HashMap<String, Double> getSector(String securityAcronym) throws IOException, ParseException { //TODO Care for sector
        return metaDataHashMap(securityAcronym, "sector");
    }

    static HashMap<String, Double> getIndustry(String securityAcronym) throws IOException, ParseException {
        return metaDataHashMap(securityAcronym, "industry");
    }

    static HashMap<String, Double> getCountry(String securityAcronym) throws IOException, ParseException {
        return metaDataHashMap(securityAcronym, "country");
    }

    static HashMap<String, Double> getRegion(String securityAcronym) throws IOException, ParseException {
        return metaDataHashMap(securityAcronym, "region");
    }

    /*String getSecurityType(String securityAcronym) throws IOException, ParseException {

    }*/

    private static HashMap<String, Double> metaDataHashMap(String securityAcronym, String metaDataName) throws IOException, ParseException {
        return new HashMap<>(){{
            JSONObject metaData = (JSONObject) SharePriceData.readJsonFile("meta", securityAcronym).get("MetaData");
            JSONArray industry = (JSONArray) metaData.get(metaDataName);

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


}
