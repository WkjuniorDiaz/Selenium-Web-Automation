package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;


public class TestDataLoader {
    private JsonObject testData;
    String jsonFilePath;


    public TestDataLoader() {
        jsonFilePath = System.getProperty("user.dir") + "/src/test/resources/dataProvider/testData.json";

        try (FileReader reader = new FileReader(jsonFilePath)) {
            testData = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JsonObject loadData(String testCaseName) {
        String jsonFilePath = "testdata.json";

        try (FileReader reader = new FileReader(jsonFilePath)) {
            JsonObject testda = JsonParser.parseReader(reader).getAsJsonObject();
            return testda.getAsJsonObject(testCaseName);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JsonObject getTestDataForTestCase(String testCaseName) {
        return testData.getAsJsonObject(testCaseName);
    }

}
