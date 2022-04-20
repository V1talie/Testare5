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

public class LoginSuccessfullyTest {
    WebDriver currentDriver;
    WorkData workData = new WorkData();
    @Given("MyAnimeList login page is opened")
    public void loginPage() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(workData.loginPage);
        currentDriver = driver;
    }
    @When("I enter correct login and pass info")
    public void clickSubmit(){
        WebDriver driver = currentDriver;
        WebElement usernameField = driver.findElement(By.name("user_name"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.className("btn-form-submit"));
        usernameField.sendKeys(workData.username);
        passwordField.sendKeys(workData.password);
        loginButton.click();
        currentDriver = driver;
    }
    @Then("I'm logged in successfully")
    public void redirectedToMainPage() throws InterruptedException {
        Thread.sleep(3000);
        WebDriver driver = currentDriver;
        assertEquals("MyAnimeList.net - Panel", driver.getTitle());
        driver.quit();
    }
}
