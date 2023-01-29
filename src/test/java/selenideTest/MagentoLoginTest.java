package selenideTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LogOutPage;
import pages.StartPage;
import pages.WelcomePage;
import pages.StartPage.LoginParams;


import java.util.stream.Stream;

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


    @DisplayName("Login with parameters")
    @ParameterizedTest()
    @MethodSource("credentials")
    void checkLoginWithParams(String url, String login,String password) {
        LoginParams hp = new LoginParams(url, login, password);
        WelcomePage wp = new WelcomePage();
        hp
                .openHomePageParam()
                .signInWithParameters();
        wp
                .checkThatUserLoggedIn()
                .close();
    }

    private static Stream<Arguments> credentials() {
        return Stream.of(
                Arguments.of("https://magento.softwaretestingboard.com", "dntest@yopmail.com", "Nopassword1"),
                Arguments.of("https://magento.softwaretestingboard.com", "dntest@yopmail.com", "Nopassword1")
        );
    }
}
