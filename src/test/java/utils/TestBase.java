package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebdriverManager() throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/globalProperties/global.properties");
        Properties prop = new Properties();
        prop.load(file);

        String url = prop.getProperty("QA-URL");
        String browserProperties = prop.getProperty("browser");
        String browserMaven = System.getProperty("browser");

        String browser = browserMaven != null ? browserMaven : browserProperties;

        if (driver == null){
            if (browser.equalsIgnoreCase("chrome")){

                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
            }

            if (browser.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                this.driver = new FirefoxDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
        }

        return driver;
    }
}
