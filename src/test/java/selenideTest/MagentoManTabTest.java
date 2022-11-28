package selenideTest;
import org.junit.jupiter.api.*;

public class MagentoManTabTest {
    String URL = "https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html";

    @Test
    void manTabTest() {
        MagentoManPage page = new MagentoManPage();
        page
            .openByURL(URL)
            .hooverMan()
            .selectRainCoat()
            .addToCart()
            .removeItem();
    }
}
