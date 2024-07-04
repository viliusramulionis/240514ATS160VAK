import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Register {
    WebDriver driver;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://elenta.lt/");
    }

    @Test(priority = 2)
    void cookieConsent() {
        driver.findElement(By.cssSelector(".fc-cta-consent")).click();
    }

    @Parameters({"username", "email", "password", "positive"})
    @Test(priority = 3)
    void register(String username, String email, String password, boolean positive) {
        driver.findElement(By.cssSelector("#header-container-nav a:last-child")).click();
        driver.findElement(By.cssSelector("table tr:last-child a")).click();
        driver.findElement(By.id("UserName")).sendKeys(username);
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("Password2")).sendKeys(password);
        driver.findElement(By.cssSelector(".bigNavBtn2")).click();

        if(positive) {
            Assert.assertNotEquals(driver.findElements(By.cssSelector(".info h1 b")).size(), 0);
        } else {
            Assert.assertEquals(driver.findElements(By.cssSelector(".info h1 b")).size(), 0);
        }
    }

    @AfterClass
    void destruct() {
        driver.quit();
    }
}
