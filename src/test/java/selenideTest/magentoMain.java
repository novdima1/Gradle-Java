package selenideTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import java.io.File;
import java.util.ArrayList;

public class magentoMain {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://magento.softwaretestingboard.com";
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.browserSize = "1620x1080";
    }

    @Test
    void menTab() {
        open("/men/tops-men/jackets-men.html");
        $("#ui-id-5").hover();
        $("#ui-id-17").hover();
        $("#ui-id-19").click();
        $(byText("Style")).click();
        $(withText("Rain Coat")).click();
        $("#mode-list").click();
        $("#sorter").click();
        $(withText("Price")).click();
        $("#option-label-size-143-item-168").click();
        $("#option-label-color-93-item-60").click();
        $(byXpath("//li[1]//button[@title='Add to Cart']")).click();
        $("span[class='counter qty']").shouldBe(Condition.visible);
        $("a.showcart").click();
        $(withText("Beaumont Summit Kit")).shouldBe(visible);
        $("a[title=\"Remove item\"]").click();
        $(withText("Are you sure you would like to remove this item from the shopping cart?")).shouldBe(visible);
        $(withText("OK")).click();
        $(withText("You have no items in your shopping cart")).shouldBe(visible);
    }
}
