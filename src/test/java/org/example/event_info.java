package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class event_info {
    WebDriver driver;
    String event_info_first_team_name, first_team_name, first_team_score, event_info_second_team_name, second_team_name, second_team_score;



    @BeforeSuite
    public void init() {
        // ChromeDriver location set up in Utils class
        // i had problem to set property with adress of location chromedriver, cause it by this way
        //System.setProperty(webdriver.chrome.driver, "F:\\GitHUB\\livescore_simple\\chromedriver.exe");
        driver = new ChromeDriver(new ChromeDriverService.Builder().usingPort(65000).build());
        driver.manage().window().maximize();
        driver.get("https://www.livescore.com/en/");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.id("onetrust-button-group")));
        driver.findElement(By.id("onetrust-button-group")).click();

    }

    @Test (testName = "event_info")
    public void event_info() {


        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.className("MatchCalendar_dates__1qr4c")));
        driver.findElement(By.className("MatchCalendar_dates__1qr4c")).click();
        System.out.println(" click is done");

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.id("1-612469__match-row__home-team-name")));
        driver.findElement(By.id("1-612469__match-row__home-team-name")).isDisplayed();
        event_info_first_team_name = driver.findElement(By.id("1-612469__match-row__home-team-name")).getText();
        first_team_score = driver.findElement(By.id("0-612466__match-row__home-team-score")).getText();
        System.out.println("first_team_name is: " + event_info_first_team_name + ", and their score is: " + first_team_score);

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.id("1-612469__match-row__away-team-name")));
        driver.findElement(By.id("1-612469__match-row__away-team-name")).isDisplayed();
        event_info_second_team_name = driver.findElement(By.id("1-612469__match-row__away-team-name")).getText();
        second_team_score = driver.findElement(By.id("1-612469__match-row__away-team-score")).getText();
        System.out.println("second_team_name: "+ event_info_second_team_name + ", and their score is: " + second_team_score);
        System.out.println("who prefers: Result of match: \"" + event_info_first_team_name + "\" vs \"" + event_info_second_team_name + "\" ended by score " + first_team_score + " : " + second_team_score);
    }

    @Test(testName = "favorites")
    public void favorites() {
        driver.findElement(By.xpath("//*[@viewBox=\"0 0 32 32\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"Favourites__top-menu-link\"]/span")).click();
        first_team_name = driver.findElement(By.xpath("//*[@id=\"0-475068__match-row__home-team-name\"]")).getText();
        second_team_name = driver.findElement(By.xpath("//*[@id=\"0-475068__match-row__away-team-name\"]")).getText();

        Assert.assertEquals(event_info_first_team_name, first_team_name);
        Assert.assertEquals(event_info_second_team_name, second_team_name);
        System.out.println("all is rightly saved");

    }

    @AfterSuite
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        //driver.close();
    }
}
