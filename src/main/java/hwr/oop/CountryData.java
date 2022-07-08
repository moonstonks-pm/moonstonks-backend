package hwr.oop;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class CountryData implements IShareMetaData{

    private final String metaData;
    private String securityAcronym;

    CountryData(){
        this.metaData = "country";
    }
    @Override
    public HashMap<String, Double> allocationData() throws IOException, ParseException {
        return MetaDataHashMap.metaDataHashMap(securityAcronym, "country");
    }

    @Override
    public void setSecurityAcronym(String securityAcronym) {
        this.securityAcronym = securityAcronym;
    }
}
