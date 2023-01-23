package selenideTest;

import org.junit.jupiter.api.Test;
import pages.MyAccountPage;
import pages.MyOrdersTab;
import pages.StartPage;

public class MyAccountTest {
    @Test
    void checkMyAccountPage() {
        StartPage hp = new StartPage();
        MyAccountPage AP = new MyAccountPage();
        hp
                .openHomePage()
                .signIn();
        AP
                .clickMenu();
        AP
                .clickMyAccountItem()
                .checkTitle();
    }

    @Test
    void checkMyOrdersPage() {
        StartPage HP = new StartPage();
        MyAccountPage AP = new MyAccountPage();
        MyOrdersTab OT = new MyOrdersTab();
        HP
                .openHomePage()
                .signIn();
        AP
                .clickMenu();
        AP
                .clickMyAccountItem()
                .gotoMyOrdersTab()
                .checkTitle();
        OT
                .checkNoOrdersMessage();
    }

}
