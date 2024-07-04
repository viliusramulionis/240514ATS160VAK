import org.testng.annotations.*;

public class First {
    @BeforeMethod
    void await () {
        System.out.println("Palaukimas");
    }

    @AfterMethod
    void awaitEnd () {
        System.out.println("Palaukimo pabaiga");
    }

    @BeforeClass
    @Parameters({"username", "password"})
    void setup(String username, String password) {
        System.out.println("Inicijuojamas driveris prisijungimo duomenys: " + username + " " + password);
    }

    @Test(priority = 2)
    void register() {
        System.out.println("Registracija");
    }

    @Test(priority = 3)
    void login() {
        System.out.println("Prisijungimas");
    }

    @Test(priority = 4)
    void logout() {
        System.out.println("Atsijungimas");
    }

    @AfterClass
    void destruct() {
        System.out.println("Driverio sunaikinimas");
    }

}
