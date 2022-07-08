package hwr.oop;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class IndustryData extends MetaDataHashMap implements IShareMetaData{

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
        return metaDataHashMap(securityAcronym, metaData);
    }
}
