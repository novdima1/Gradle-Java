package pages;
import com.codeborne.selenide.Configuration;

public class BasePage {
    public BasePage() {
        Configuration.baseUrl = "https://magento.softwaretestingboard.com";
        Configuration.browser = "edge";
        Configuration.timeout = 5000;
        Configuration.browserSize = "1620x1080";
    }
}
