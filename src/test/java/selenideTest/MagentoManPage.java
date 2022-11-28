package selenideTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MagentoManPage {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://magento.softwaretestingboard.com";
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.browserSize = "1620x1080";
    }
    public MagentoManPage openByURL(String url) {
        open(url);
        return this;
    }

    public MagentoManPage hooverMan() {
        $("#ui-id-5").hover();
        $("#ui-id-17").hover();
        $("#ui-id-19").click();
        return this;
    }

    public MagentoManPage selectRainCoat() {
        $(byText("Style")).click();
        $(withText("Rain Coat")).click();
        return this;
    }

    public MagentoManPage addToCart() {
        $("#mode-list").click();
        $("#sorter").click();
        $(withText("Price")).click();
        $("#option-label-size-143-item-168").click();
        $("#option-label-color-93-item-60").click();
        $(byXpath("//li[1]//button[@title='Add to Cart']")).click();
        $("span[class='counter qty']").shouldBe(Condition.visible);
        $("a.showcart").click();
        $(withText("Beaumont Summit Kit")).shouldBe(visible);
        return this;
    }

    public MagentoManPage removeItem() {
        $("a[title=\"Remove item\"]").click();
        $(withText("Are you sure you would like to remove this item from the shopping cart?")).shouldBe(visible);
        $(withText("OK")).click();
        $(withText("You have no items in your shopping cart")).shouldBe(visible);
        return this;
    }

}
