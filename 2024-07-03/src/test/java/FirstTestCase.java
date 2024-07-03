import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestCase {
    WebDriver driver = new ChromeDriver();

    @Test(priority = 1)
    void setup() {
        driver.manage().window().maximize();
        driver.get("https://elenta.lt/");
    }
    @Test(priority = 2)
    void cookieConsent() {
        driver.findElement(By.cssSelector(".fc-cta-consent")).click();
    }

    @Test(priority = 3)
    void login() throws Exception {
        System.out.println("Prisijungimas");
        driver.findElement(By.cssSelector("#header-container-nav a:last-child")).click();
        driver.findElement(By.id("UserName")).sendKeys("helloworld2");
        driver.findElement(By.id("Password")).sendKeys("!>]Y]c");
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

    @Test(priority = 5)
    void destruct() {
        driver.quit();
    }

}
