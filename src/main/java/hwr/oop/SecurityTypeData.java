package hwr.oop;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class SecurityTypeData implements IShareMetaData{

    private final String securityAcronym;

    SecurityTypeData(String securityAcronym){
        this.securityAcronym = securityAcronym;
    }
    @Override
    public HashMap<String, Double> allocationData() throws IOException, ParseException {
        JSONObject metaData = (JSONObject) SharePriceData.readJsonFile("meta", securityAcronym).get("MetaData");
        String securityType = (String) metaData.get("securityType");

        return new HashMap<>(){{
            put(securityType, 100.0);
        }};
    }
}

