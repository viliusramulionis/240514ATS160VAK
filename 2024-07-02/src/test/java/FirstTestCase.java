// Anotacijos importavimas
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FirstTestCase {
//    @Test = Anotacijos priskyrimas
//    (priority = 1) nurodo metodo paleidimo eiles tvarka

    @Parameters({"vardas", "pavarde"})
    @Test(priority = 1)
    void register(String name, String last_name) {
        System.out.println("Registracija su duomenimis: " + name + " " + last_name);
        Assert.assertEquals(name + last_name, "BradPitt");
    }

    @Test(priority = 2)
    void login() {
        System.out.println("Prisijungimas");
    }

    @Test(priority = 3)
    void account() {
        System.out.println("Paskyra");
    }

    @Test(priority = 4)
    void logout() {
        System.out.println("Atsijungimas");
    }
}
