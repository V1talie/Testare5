package Hyper_Tests;

import UTIL.WorkData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {
    WebDriver currentDriver;
    WorkData workData = new WorkData();
    @Given("MyAnimeList search page")
    public void searchPage() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(workData.searchUrl);
        currentDriver = driver;
    }
    @When("I introduce a key word in search bar")
    public void clickSearchBtn() {
        WebDriver driver = currentDriver;
        WebElement searchField = driver.findElement(By.className("js-advancedSearchText"));
        WebElement searchBtn = driver.findElement(By.className("inputButton"));
        searchField.click();
        searchField.sendKeys(workData.searchString);
        searchBtn.click();
        currentDriver = driver;
    }
    @Then("I'm given the results")
    public void redirectedToResultsPage() throws InterruptedException {
        Thread.sleep(3000);
        WebDriver driver = currentDriver;
        WebElement infoBar = driver.findElement(By.className("result-header"));
        assertEquals(infoBar.getText(), workData.expectedSearch);
        driver.quit();
    }
}
