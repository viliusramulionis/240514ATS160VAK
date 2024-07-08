import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Tax {
    WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    void setup(String browser) {
//        if(browser.equals("edge")) {
//            driver = new EdgeDriver();
//        } else if(browser.equals("firefox")) {
//            driver = new FirefoxDriver();
//        } else {
//            driver = new ChromeDriver();
//        }

        switch(browser) {
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get("https://tax.lt/skaiciuokles/atlyginimo_ir_mokesciu_skaiciuokle");
        driver.findElement(By.cssSelector(".fc-cta-consent")).click();
    }

    @Test
    void first() throws Exception {
        driver.findElement(By.id("atlyginimas")).sendKeys("1000");
        Thread.sleep(1000);
        String sum = driver.findElement(By.id("i_rankas")).getText();

        sum = sum.replace(" €", "");

        Assert.assertEquals(sum, "746,80");
    }

    @AfterClass
    void destruct() {
//        driver.close();
    }
}
