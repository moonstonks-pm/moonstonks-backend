package hwr.oop;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class SecurityTypeData implements IShareMetaData{

    private final String metaDataType;
    private String securityAcronym;

    SecurityTypeData(){
        this.metaDataType = "securityType";
    }
    @Override
    public HashMap<String, Double> allocationData() {
        try {
            JSONObject metaData = (JSONObject) SharePriceData.readJsonFile("meta", securityAcronym).get("MetaData");
            String securityType = (String) metaData.get(metaDataType);
            return new HashMap<>(){{
                put(securityType, 100.0);
            }};
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("JSON Files cant be reached!");
        }

    }

    @Override
    public void setSecurityAcronym(String securityAcronym) {
        this.securityAcronym = securityAcronym;
    }
}

