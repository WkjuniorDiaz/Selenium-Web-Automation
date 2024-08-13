package stepDefinition;

import com.google.gson.JsonObject;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.JSONReader;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks {

    TestContextSetup testContextSetup;
    public static JSONObject jsonData;

    public Hooks(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @After
    public void afterScenario() throws IOException{
        testContextSetup.testBase.WebdriverManager().quit();
    }

    @AfterStep
    public void  takeScreenshot(Scenario scenario) throws IOException{
        if (scenario.isFailed()){
            WebDriver driver = testContextSetup.testBase.WebdriverManager();
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent,"image/png","image");
        }
    }

    @Before
    public void readData() {
        JSONReader jsonReader = new JSONReader();
        try {
            jsonData = jsonReader.readJSON("src/test/resources/dataProvider/testData.json");
        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }
}
