package main.java.com.instructure.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.java.com.GooglePage;

public class GoogleTest {
	  private WebDriver driver;
	    private GooglePage google;

	    @BeforeTest
	    public void setUp() throws MalformedURLException {
	        DesiredCapabilities dc = DesiredCapabilities.chrome();
	        driver = new RemoteWebDriver(new URL("http://172.18.0.1:5555/wd/hub"), dc);
	        google = new GooglePage(driver);
	    }

	    @Test
	    public void googleTest() throws InterruptedException {
	        google.goTo();
	        google.searchFor("automation");
	        Assert.assertTrue(google.getResults().size() >= 9);
	    }
	    
	    @AfterTest
	    public void tearDown() throws InterruptedException {
	        driver.quit();
	    }  
}
