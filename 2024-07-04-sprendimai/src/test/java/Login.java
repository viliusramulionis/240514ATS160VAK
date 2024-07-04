import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {
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

    @Parameters({"username", "password"})
    @Test(priority = 3)
    void login(String username, String password) throws Exception {
        System.out.println("Prisijungimas");
        driver.findElement(By.cssSelector("#header-container-nav a:last-child")).click();
        driver.findElement(By.id("UserName")).sendKeys(username);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.cssSelector(".bigNavBtn2")).click();

        Thread.sleep(1000);

        Assert.assertFalse(driver.findElements(By.id("my-ads-nav-button")).isEmpty());
    }

    @Test(priority = 4)
    void logout() throws Exception {
        Thread.sleep(1000);
        Assert.assertFalse(driver.findElements(By.id("my-ads-nav-button")).isEmpty());
        driver.findElement(By.id("my-ads-nav-button")).click();
        driver.findElement(By.cssSelector("[title=\"Atsijungti nuo eLenta.lt\"]")).click();
        System.out.println("Atsijungimas");
    }

    @AfterClass
    void destruct() {
        driver.quit();
    }

}
