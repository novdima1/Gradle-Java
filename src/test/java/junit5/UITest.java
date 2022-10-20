package junit5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class UITest {
    @Test
    void check_playwright(){
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            // Open new page
            Page page = context.newPage();
            // Go to https://playwright.dev/
            page.navigate("https://playwright.dev/");
            // Click text=Get started
            page.locator("text=Get started").click();
            assertThat(page).hasURL("https://playwright.dev/docs/intro");
            // Click aside >> text=Writing Tests
            page.locator("aside >> text=Writing Tests").click();
            assertThat(page).hasURL("https://playwright.dev/docs/writing-tests");
            // Click aside >> text=Running Tests
            page.locator("aside >> text=Running Tests").click();
            assertThat(page).hasURL("https://playwright.dev/docs/running-tests");
            // Click text=Test Generator >> nth=0
            page.locator("text=Test Generator").first().click();
            assertThat(page).hasURL("https://playwright.dev/docs/codegen-intro");
            // Click text=Trace Viewer >> nth=0
            page.locator("text=Trace Viewer").first().click();
            assertThat(page).hasURL("https://playwright.dev/docs/trace-viewer-intro");

            // Click text=Authentication >> nth=0
            page.locator("text=Authentication").first().click();
            assertThat(page).hasURL("https://playwright.dev/docs/auth");
            // Click text=Command line >> nth=0
            page.locator("text=Command line").first().click();
            assertThat(page).hasURL("https://playwright.dev/docs/test-cli");
        }
    }

    @Test
    @Tag("issue-1")
    void check_playwright32(){
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            // Open new page
            Page page = context.newPage();
            // Go to https://playwright.dev/
            page.navigate("https://playwright.dev/");
        }
    }
}
