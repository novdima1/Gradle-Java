package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class WelcomePage{

    // Locators
    String welcomeText = "Welcome, testname testlastname!";
    String menuIcon = "(//button[@tabindex=\"-1\"])[1]";
    String signOutButton = "Sign Out";

    public WelcomePage checkThatUserLoggedIn() {
        $(withText(welcomeText)).shouldBe(visible);
        return this;
    }

    public WelcomePage logOut() {
        clickMenu();
        $(withText(signOutButton)).click();
        return this;
    }

    public WelcomePage clickMenu() {
        $(byXpath(menuIcon)).click();
        return this;
    }

    public void close() {
        closeWebDriver();
    }
}
