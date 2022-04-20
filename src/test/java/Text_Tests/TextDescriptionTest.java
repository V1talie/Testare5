package Text_Tests;

import UTIL.WorkData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static UTIL.WorkData.DESCRIPTION_STRING;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TextDescriptionTest {
WorkData workData = new WorkData();
WebDriver currentDriver;
@Given("MyAnimeList profile settings is opened")
public void mainProfile() throws InterruptedException {
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
    driver.get(workData.editProfile);
    currentDriver = driver;
}

@When("I insert {string} in about me")
public void insertString(String string){
    WebDriver driver = currentDriver;
    WebElement abouMeTextArea = driver.findElement(By.name("profile_aboutme"));
    abouMeTextArea.clear();
    abouMeTextArea.sendKeys(string);
    WebElement submitButton = driver.findElement(By.name("submit"));
    submitButton.click();
    currentDriver = driver;
}

@Then("the description is updated on profile")
public void updateDescription(){
    WebDriver driver = currentDriver;
    driver.get(workData.profile);
    assertEquals(DESCRIPTION_STRING, driver.findElement(By.className("word-break")).getText());
    driver.quit();
}

}
