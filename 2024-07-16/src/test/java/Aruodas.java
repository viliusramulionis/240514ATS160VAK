import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import java.util.*;

public class Aruodas extends Helpers {

    @BeforeClass
    void getPage() throws Exception {
        driver.get("https://aruodas.lt");
        Thread.sleep(1000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Test
    @Parameters({"areaFrom", "areaTo", "priceFrom", "priceTo"})
    void search(
            @Optional String areaFrom,
            @Optional String areaTo,
            @Optional String priceFrom,
            @Optional String priceTo
    ) throws Exception {
        List<WebElement> types = driver.findElements(By.cssSelector("#options_obj label"));

//        PIRMAS SPRENDIMAS PASINAUDOJANT MASYVU
//        String[] ids = new String[types.size()];
//
//        for(int i = 0; i < types.size(); i++) {
//            if(!types.get(i).getAttribute("for").equals("input_obj_101") &&
//                !types.get(i).getAttribute("for").equals("input_obj_9")
//                )
//                ids[i] = types.get(i).getAttribute("for");
//        }
//        ANTRAS SPRENDIMAS PASINAUDOJANT LIST'U

        List<String> ids = new ArrayList<String>();

        for(WebElement type : types) {
            if(!type.getAttribute("for").equals("input_obj_101") &&
                    !type.getAttribute("for").equals("input_obj_9")
            ) {
                ids.add(type.getAttribute("for"));
            }
        }

//        System.out.println(ids.toString());
//        System.out.println(Arrays.toString(ids));

        for(String id : ids) {
            Thread.sleep(500);
            driver.findElement(By.id("display_obj")).click();
            driver.findElement(By.cssSelector("[for=\"" + id + "\"]")).click();

            Thread.sleep(2000);
            if(areaFrom != null) {
                try {
                    WebElement from = driver.findElement(By.id("input_FAreaOverAllMin"));
                    from.clear();
                    from.sendKeys(areaFrom);

                } catch(Exception e) {
                    System.out.println("Prie pasirinktos kategorijos laukeliu nerasta");
                }
            }

            if(areaTo != null) {
                try {
                    WebElement to = driver.findElement(By.id("input_FAreaOverAllMax"));
                    to.clear();
                    to.sendKeys(areaTo);
                } catch(Exception e) {
                    System.out.println("Prie pasirinktos kategorijos laukeliu nerasta");
                }
            }

            if(priceFrom != null) {
                try {
                    WebElement from = driver.findElement(By.id("input_FPriceMin"));
                    from.clear();
                    from.sendKeys(priceFrom);

                } catch(Exception e) {
                    System.out.println("Prie pasirinktos kategorijos kainos laukeliu nerasta");
                }
            }

            if(priceTo != null) {
                try {
                    WebElement to = driver.findElement(By.id("input_FPriceMax"));
                    to.clear();
                    to.sendKeys(priceTo);
                } catch(Exception e) {
                    System.out.println("Prie pasirinktos kategorijos kainos laukeliu nerasta");
                }
            }

            driver.findElement(By.id("buttonSearchForm")).click();

            boolean error = false;

            try {
                driver.findElement(By.cssSelector(".error-div.error2 b")).getText();
                error = true;
            } catch(Exception e) {
            }

            if(driver.findElements(By.cssSelector(".list-row-v2")).size() == 0 && !error) {
                throw new Exception("Skelbimų nerasta, arba žinutė neiššoko");
            }
        }

    }
}
