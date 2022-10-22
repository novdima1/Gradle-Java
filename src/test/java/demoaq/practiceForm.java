package demoaq;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import java.util.ArrayList;

public class practiceForm {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.timeout=5000;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiceFormTest() {
        // VARIABLES
        String localUrl = "/automation-practice-form";
        String email = "name@example.com";
        String mobileValue = "1231231231";
        String female = "Female";
        String dataOfBirth = "22 October,2022";

        // LOCATORS
        String studentRegistrationFormTitle = "Student Registration Form";
        String placeholder = "placeholder";
        String firstName = "First Name";
        String lastName = "Last Name";
        WebElement gender = $(byText(female));
        WebElement mobile = $("input[id=userNumber]");
        WebElement submit = $("[id=submit]");
        WebElement thanksText = $(byText("Thanks for submitting the form"));

        // Actual results
        ArrayList<String> label = new ArrayList<String>();
        label.add("Student Name");
        label.add("Student Email");
        label.add("Gender");
        label.add("Mobile");
        label.add("Date of Birth");

        ArrayList<String> value = new ArrayList<String>();
        value.add("Test Client " +  firstName + " Test Client " + lastName);
        value.add(email);
        value.add(female);
        value.add(mobileValue);
        value.add(dataOfBirth);

        open(localUrl);

        // Remove banners
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $(byText(studentRegistrationFormTitle)).shouldBe(visible);
        String name = $(byAttribute(placeholder, firstName)).getAttribute(placeholder);
        $(byAttribute(placeholder, firstName)).setValue("Test Client " + name);
        String surname = $(byAttribute(placeholder, lastName)).getAttribute(placeholder);
        $(byAttribute(placeholder, lastName)).setValue("Test Client " + surname);
        $(byAttribute(placeholder, email)).setValue(email);
        gender.click();
        ((SelenideElement) mobile).setValue(mobileValue);
        submit.click();
        ((SelenideElement) thanksText).shouldBe(visible);

        for (int i = 0; i < label.size(); i++) {
            String selectorLabel = String.format("tbody tr:nth-child(%s) td:nth-child(%s)", i+1, 1);
            $(selectorLabel).shouldHave(exactText(label.get(i)));
            String selectorValue = String.format("tbody tr:nth-child(%s) td:nth-child(%s)", i+1, 2);
            $(selectorValue).shouldHave(exactText(value.get(i)));
        }

        $("[id=closeLargeModal]").click();
        $(byText(studentRegistrationFormTitle)).shouldBe(visible);
    }
}
