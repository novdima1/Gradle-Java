package selenideTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BasePage {
//    @BeforeAll
    public BasePage() {
        Configuration.baseUrl = "https://magento.softwaretestingboard.com";
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.browserSize = "1620x1080";
    }
}
