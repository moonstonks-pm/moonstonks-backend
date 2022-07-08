package hwr.oop;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class IndustryData implements IShareMetaData{

    private String securityAcronym;
    private final String metaData;

    IndustryData(){
        this.metaData = "industry";
    }

    @Override
    public void setSecurityAcronym(String securityAcronym) {
        this.securityAcronym = securityAcronym;
    }
    @Override
    public HashMap<String, Double> allocationData() throws IOException, ParseException {
        return MetaDataHashMap.metaDataHashMap(securityAcronym, metaData);
    }
}
