package pages;

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class StartPage {

    // Locators
    String signInButton = "Sign In"; // same xpath syntax //*[contains(text(),'Sign In')]
    String email = "[id=email]";
    String password = "[id=pass]";
    String signInButton2 = "(//button[@id=\"send2\"])[1]";

    // VARS
    String EMAIL = "dntest@yopmail.com";
    String PASSWORD = "Nopassword1";

    public StartPage openHomePage() {
        open("https://magento.softwaretestingboard.com");
        return this;
    }

    public StartPage sleep(long period) {
        Selenide.sleep(period*1000);
        return this;
    }


    public void signIn() {
        $(withText(signInButton)).click();
        $(email).setValue(EMAIL);
        $(password).setValue(PASSWORD);
        $(byXpath(signInButton2)).click();
    }

    public static class LoginParams extends StartPage {
        String login;
        String pass;
        String url;

        public LoginParams(String url, String login, String pass) {
            super();
            this.url = url;
            this.login = login;
            this.pass = pass;
        }

        public StartPage signInWithParameters() {
            $(withText(signInButton)).click();
            $(email).setValue(login);
            $(password).setValue(pass);
            $(byXpath(signInButton2)).click();
            return this;
        }

        public LoginParams openHomePageParam() {
            open(url);
            return this;
        }


    }
}
