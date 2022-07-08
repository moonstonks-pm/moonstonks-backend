package hwr.oop;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

class MetaDataHashMap {

    static HashMap<String, Double> metaDataHashMap(String securityAcronym, String metaDataName){

        try {
            return new HashMap<>() {{
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
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("JSON Files cant be reached");
        }
    }
}
