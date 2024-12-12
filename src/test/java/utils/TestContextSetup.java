package utils;

import java.io.IOException;

public class TestContextSetup {

    public ObjectFactory objectFactory;
    public TestBase testBase;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        objectFactory = new ObjectFactory(testBase.WebdriverManager());
    }
}



