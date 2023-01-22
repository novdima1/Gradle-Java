package selenideTest;

import org.junit.jupiter.api.Test;
import pages.ManPage;

public class MagentoManTabTest {
    String URL = "https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html";

    @Test
    void manTabTest() {
        ManPage page = new ManPage();
        page
                .openByURL(URL)
                .hooverMan()
                .selectRainCoat()
                .addToCart()
                .removeItem();
    }
}
