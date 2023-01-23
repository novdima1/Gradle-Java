package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class MyAccountPage extends WelcomePage{

    // Locators
    String myAccount = "h1.page-title";
    String myAccountItem = "My Account";
    String myOrdersTab = "My Orders";

    public MyAccountPage gotoMyOrdersTab() {
        $(withText(myOrdersTab)).click();
        return this;
    }

    public MyAccountPage clickMyAccountItem() {
        $(withText(myAccountItem)).click();
        return this;
    }

    public MyAccountPage checkTitle() {
        $((myAccount)).shouldBe(visible);
        return this;
    }
}
