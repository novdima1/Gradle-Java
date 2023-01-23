package selenideTest;
import org.junit.jupiter.api.*;
import pages.LogOutPage;
import pages.StartPage;
import pages.WelcomePage;

public class MagentoLoginTest {
    @Test
    void checkLogin() {
        StartPage hp = new StartPage();
        WelcomePage wp = new WelcomePage();
        hp
                .openHomePage()
                .signIn();
        wp
                .checkThatUserLoggedIn();
    }

    @Test
    void checkLogout() {
        StartPage hp = new StartPage();
        WelcomePage wp = new WelcomePage();
        LogOutPage lp = new LogOutPage();
        hp
                .openHomePage()
                .signIn();
        wp
                .checkThatUserLoggedIn()
                .logOut();
        lp
                .checkThatUserLoggedOut();
    }
}
