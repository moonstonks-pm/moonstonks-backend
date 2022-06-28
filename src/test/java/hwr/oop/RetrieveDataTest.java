package hwr.oop;

import org.junit.jupiter.api.*;

import org.assertj.core.api.Assertions;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

class RetrieveDataTest {

    @Test
    void retrieveSymbolTestData() {
        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("/Users/I550626/repositories/private/coding-project-hwr/src/test/java/hwr/oop/mock.json");

            Object jsonObj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) jsonObj;
            JSONObject result = (JSONObject) jsonObject.get("Meta Data");

            String symbol = (String) result.get("2. Symbol");
            System.out.println("Symbol: " + symbol);

            Assertions.assertThat(symbol).isEqualTo("IBM");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void retrieveFullDayJsonObject(){
        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader("/Users/I550626/repositories/private/coding-project-hwr/src/test/java/hwr/oop/mock.json");

            Object jsonObj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) jsonObj;
            JSONObject result = (JSONObject) jsonObject.get("Time Series (Daily)");
            JSONObject daily = (JSONObject) result.get("2022-06-24");

            daily.toJSONString();
            System.out.println(daily);

            //TODO: Add assertion for this test. Currently too lazy to do it :P
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
