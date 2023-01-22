package pages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ManPage extends BasePage {

    String MenTab = "#ui-id-5";
    String Tops = "#ui-id-17";
    String Jackets = "#ui-id-19";
    String Style = "Style";
    String RainCoat = "Rain Coat";

    public ManPage openByURL(String url) {
        open(url);
        return this;
    }

    public ManPage hooverMan() {
        $(MenTab).hover();
        $(Tops).hover();
        $(Jackets).click();
        return this;
    }

    public ManPage selectRainCoat() {
        $(byText(Style)).click();
        $(withText(RainCoat)).click();
        return this;
    }

    public ManPage addToCart() {
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

    public void removeItem() {
        $("a[title=\"Remove item\"]").click();
        $(withText("Are you sure you would like to remove this item from the shopping cart?")).shouldBe(visible);
        $(withText("OK")).click();
        $(withText("You have no items in your shopping cart")).shouldBe(visible);
    }

}
