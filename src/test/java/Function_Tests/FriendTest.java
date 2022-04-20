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

public class FriendTest {
    WebDriver currentDriver;
    WorkData workData = new WorkData();
    @Given("MyAnimeList friend page")
    public void searchPage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(workData.loginPage);
        WebElement usernameField = driver.findElement(By.name("user_name"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.className("btn-form-submit"));
        usernameField.sendKeys(workData.username);
        passwordField.sendKeys(workData.password);
        loginButton.click();
        Thread.sleep(3000);
        driver.get(workData.friendUrl);
        currentDriver = driver;
    }
    @When("I click on adding a friend")
    public void clickSearchBtn() {
        WebDriver driver = currentDriver;
        WebElement friendField = driver.findElement(By.name("friend_name"));
        WebElement searchBtn = driver.findElement(By.className("inputButton"));
        friendField.sendKeys(workData.friendName);
        searchBtn.click();
        WebElement cancel = driver.findElement(By.xpath("//input[2]"));
        cancel.click();
    }
    @Then("I'm adding a friend")
    public void redirectedToResultsPage() throws InterruptedException {
        WebDriver driver = currentDriver;
        assertEquals(workData.friendUrl,driver.getCurrentUrl());
        driver.quit();
    }
}
