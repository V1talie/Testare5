package Function_Tests;

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

public class SearchAccessTest {
    WebDriver currentDriver;
    WorkData workData = new WorkData();
    @Given("MyAnimeList search bar is given")
    public void searchPage() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(workData.searchUrl);
        currentDriver = driver;
    }
    @When("I enter text in search bar and access search element")
    public void clickSearchBtn() {
        WebDriver driver = currentDriver;
        WebElement searchField = driver.findElement(By.className("js-advancedSearchText"));
        WebElement searchBtn = driver.findElement(By.className("inputButton"));
        searchField.click();
        searchField.sendKeys(workData.searchKey);
        searchBtn.click();
        WebElement result = driver.findElement(By.className("hoverinfo_trigger"));
        result.click();
    }
    @Then("I'm redirected to the search element successfully")
    public void redirectedToResultsPage() throws InterruptedException {
        WebDriver driver = currentDriver;
        assertEquals(workData.expectedAnime,driver.getTitle());
        driver.quit();
    }
}
