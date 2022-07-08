package hwr.oop;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public interface IShareMetaData {

    HashMap<String, Double> allocationData() throws IOException, ParseException;

    void setSecurityAcronym(String securityAcronym);
}
