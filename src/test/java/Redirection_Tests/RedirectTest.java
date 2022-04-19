package Redirection_Tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class RedirectTest {
WorkData workData = new WorkData();
WebDriver currentDriver;
@Given("Facebook main page is opened")
public void mainPage(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get(workData.mainPage);
    currentDriver = driver;
}
@When("I click on \"Login\" button")
public void clickLogin(){
    WebDriver driver = currentDriver;
    //driver.get("https://www.facebook.com/");
    WebElement loginButton = driver.findElement(By.name("login"));
    loginButton.click();
    currentDriver = driver;
}
@Then("I'm redirected to login page")
public void redirectedToLoginPage(){
    WebDriver driver = currentDriver;
    assertEquals("Facebook - log in or sign up", driver.getTitle());
    driver.quit();
}

}
