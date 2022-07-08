package hwr.oop;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class SectorData extends MetaDataHashMap implements IShareMetaData{

    private final String metaDataName;
    private String securityAcronym;

    SectorData(){
        this.metaDataName = "sector";
    }

    public void setSecurityAcronym(String securityAcronym){
        this.securityAcronym = securityAcronym;
    }
    @Override
    public HashMap<String, Double> allocationData(){
        return metaDataHashMap(securityAcronym, metaDataName);
    }
}
