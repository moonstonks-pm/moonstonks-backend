package hwr.oop;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class SectorData implements IShareMetaData{

    private final String securityAcronym;

    SectorData(String securityAcronym){
        this.securityAcronym = securityAcronym;
    }
    @Override
    public HashMap<String, Double> allocationData() throws IOException, ParseException {
        return MetaDataHashMap.metaDataHashMap(securityAcronym, "sector");
    }
}
