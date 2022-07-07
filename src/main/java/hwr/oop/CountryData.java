package hwr.oop;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class CountryData implements IShareMetaData{

    private final String securityAcronym;

    CountryData(String securityAcronym){
        this.securityAcronym = securityAcronym;
    }
    @Override
    public HashMap<String, Double> allocationData() throws IOException, ParseException {
        return MetaDataHashMap.metaDataHashMap(securityAcronym, "country");
    }
}
