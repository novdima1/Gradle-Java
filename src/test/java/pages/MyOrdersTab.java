package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class MyOrdersTab extends MyAccountPage{

    // Locators
    String noOrdersMessageLocator = "div.message.info";

    // VAR
    String NoOrderText = "You have placed no orders.";

    public MyOrdersTab checkNoOrdersMessage() {
        $((noOrdersMessageLocator)).shouldHave(text(NoOrderText));
        return this;
    }
}
