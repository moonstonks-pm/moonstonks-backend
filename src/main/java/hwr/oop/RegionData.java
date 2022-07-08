package hwr.oop;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class RegionData extends MetaDataHashMap implements IShareMetaData{

    private final String metaData;
    private String securityAcronym;

    RegionData(){
        this.metaData = "region";
    }

    @Override
    public HashMap<String, Double> allocationData(){
        return metaDataHashMap(securityAcronym, metaData);
    }

    @Override
    public void setSecurityAcronym(String securityAcronym) {
        this.securityAcronym = securityAcronym;
    }
}
