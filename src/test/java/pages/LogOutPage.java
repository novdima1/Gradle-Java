package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class LogOutPage {

    // Locators
    String defaultWelcomeText = "Default welcome msg!";

    public LogOutPage checkThatUserLoggedOut() {
        $(withText(defaultWelcomeText)).shouldBe(visible);
        return this;
    }
}
