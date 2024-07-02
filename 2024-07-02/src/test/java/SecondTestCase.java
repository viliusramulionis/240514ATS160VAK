// Anotacijos importavimas
import org.testng.annotations.Test;

public class SecondTestCase {
//    @Test = Anotacijos priskyrimas
//    (priority = 1) nurodo metodo paleidimo eiles tvarka

    @Test(priority = 4)
    void logout() {
        System.out.println("Atsijungimas");
    }

    @Test(priority = 1)
    void register() {
        System.out.println("Registracija");
    }

    @Test(priority = 2)
    void login() {
        System.out.println("Prisijungimas");
    }

    @Test(priority = 3)
    void account() {
        System.out.println("Paskyra");
    }
}
