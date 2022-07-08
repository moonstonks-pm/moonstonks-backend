package hwr.oop;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public interface IShareMetaData {

    HashMap<String, Double> allocationData();

    void setSecurityAcronym(String securityAcronym);
}
