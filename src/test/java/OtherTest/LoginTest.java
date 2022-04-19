package OtherTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginTest {
    WebDriver currentDriver;
    @Given("Facebook login page")
    public void mainPage(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/login");
        currentDriver = driver;
       // driver.quit();
    }
    @When("I introduce an email with a wrong password")
    public void clickLogin(){
       // WebDriverManager.chromedriver().setup();
       // WebDriver driver = new ChromeDriver();
        WebDriver driver = currentDriver;
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement passwordField = driver.findElement(By.name("pass"));
        WebElement loginButton = driver.findElement(By.name("login"));
        emailField.sendKeys("emailRandom@mail.com");
        passwordField.sendKeys("ceva");
        loginButton.click();
        currentDriver = driver;
    }
    @Then("I'm not able to login")
    public void redirectedToLoginPage(){
        WebDriver driver = currentDriver;
        assertEquals("Log into Facebook", driver.getTitle());
        driver.quit();
    }

}