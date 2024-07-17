import org.testng.annotations.Test;

public class Skelbiu extends Helpers {
    @Test
    void pirmas() {
        System.out.println(hello());
    }
    String hello() {
        System.out.println("Funkcijos pradzia");

        if(false) {
            return "Sveiki visi";
        }

        System.out.println("Funkcijos pabaiga");

        return "";
    }
}
