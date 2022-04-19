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

import static UTIL.WorkData.COMMENT_STRING;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CommentTest {
    WebDriver currentDriver;
    WorkData workData = new WorkData();
    @Given("MyAnimeList profile  is opened")
    public void mainPage() throws InterruptedException {
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
        driver.get(workData.profile);
        currentDriver = driver;
    }

    @When("I insert string in comment")
    public void clickLogin(){
        WebDriver driver = currentDriver;
        WebElement commentTextArea = driver.findElement(By.name("commentText"));
        commentTextArea.sendKeys(COMMENT_STRING);
        WebElement commentSubmit = driver.findElement(By.name("commentSubmit"));
        commentSubmit.click();
        currentDriver = driver;
    }

    @Then("the comments are updated")
    public void redirectedToLoginPage(){
        WebDriver driver = currentDriver;
        WebElement comtext = driver.findElement(By.className("comment-text"));
        assertEquals(comtext.getText(),COMMENT_STRING);
        driver.quit();
    }



}
