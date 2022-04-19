import io.github.bonigarcia.wdm.WebDriverManager;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeTest {
    @Test
    public void install() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.facebook.com/");
        WebElement searchButton = driver.findElement(By.name("login"));
        searchButton.click();
        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("pass"));
        email.sendKeys("testmail");
        password.sendKeys("testpass");
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();
        driver.quit(); //in coment to see the browser

    }



}
