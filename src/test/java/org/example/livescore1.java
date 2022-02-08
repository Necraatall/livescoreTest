package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class livescore1 {
    WebDriver driver;


    @BeforeSuite
    public void init() {
        // ChromeDriver location set up in Utils class
        driver = new ChromeDriver(new ChromeDriverService.Builder().usingPort(65000).build());

    }
    @Test
    public void hello() {
        driver.get("https://www.seznam.cz");

    }

    @AfterSuite
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
