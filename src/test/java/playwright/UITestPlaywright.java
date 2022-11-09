package playwright;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.*;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
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
                    .setHeadless(false).setArgs(List.of("--start-maximized")));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1280));
            Page page = context.newPage();

            page.navigate("https://demoqa.com/automation-practice-form");
            // Remove banners
            page.locator("$('footer').remove()");
            page.locator("$('#fixedban').remove()");

            page.getByPlaceholder("First Name").click();
            page.getByPlaceholder("First Name").fill("Bobby");
            page.getByPlaceholder("Last Name").click();
            page.getByPlaceholder("Last Name").fill("Stellar");
            page.getByPlaceholder("name@example.com").click();
            page.getByPlaceholder("name@example.com").fill("ex_email@gmail.com");
            page.getByText("Other").click();
            page.getByPlaceholder("Mobile Number").click();
            page.getByPlaceholder("Mobile Number").fill("123321123");
            page.locator("#dateOfBirthInput").click();
            page.locator(".subjects-auto-complete__value-container").click();
            page.locator("#subjectsInput").fill("Math");
            page.locator("#react-select-2-option-0").click();
            page.getByText("Sports").click();
            page.getByText("Reading").click();
            page.getByText("Music").click();
            page.getByPlaceholder("Current Address").click();
            page.getByPlaceholder("Current Address").fill("av. North, 5");
            page.getByPlaceholder("Mobile Number").click();
            page.getByPlaceholder("Mobile Number").fill("1233211231");
            page.locator("#submit").click();
            assertThat(page.locator("#example-modal-sizes-title-lg")).containsText("Thanks for submitting the form");
            page.locator("#closeLargeModal").click();
        }
    }
}
