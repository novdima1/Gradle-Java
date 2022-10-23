package playwright;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.*;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class UITestPlaywright {
    @Test
    @Tag("playwright")
    void check_playwright() {
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
    void tmpTestDemo() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://demoqa.com/automation-practice-form");

            String dataOfBirthInput = "23 Oct 2022";
            page.locator("#dateOfBirthInput").click();
            page.locator("#dateOfBirthInput").fill(dataOfBirthInput);

            page.locator("#userNumber").fill("qweqweqwe");
            page.locator("#subjectsInput").fill("qweqweqwe");

        }
    }
}
