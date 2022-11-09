package selenideTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import java.io.File;
import java.util.ArrayList;

public class practiceForm {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.browserSize = "1920x1280";
    }

    @Test
    void practiceFormTest() {
        // VARIABLES
        String localUrl = "/automation-practice-form";
        String email = "name@example.com";
        String mobileValue = "1231231231";
        String female = "Female";
        String subject = "subject";
        String reading = "Reading";
        String empty = "";
        String filePath = "src/test/resources/test-picture-1.png";
        String hobbies = "Reading";
        String fileName = "test-picture-1.png";
        String address = "Address";
        String state = "NCR";
        String city = "Noida";
        String stateAndCity = state + " " + city;
        String month = "November";
        String year = "2022";
        String day = "05";
        String dataOfBirthResult = day + " " + month + "," + year;

        // LOCATORS
        String studentRegistrationFormTitle = "Student Registration Form";
        String placeholder = "placeholder";
        String firstName = "First Name";
        String lastName = "Last Name";
        WebElement gender = $(byText(female));
        WebElement hobbiesLocator = $(byText(reading));
        WebElement mobile = $("input[id=userNumber]");
        WebElement submit = $("[id=submit]");
        WebElement thanksText = $(byText("Thanks for submitting the form"));
        WebElement subjectsLocator = $("input[id=subjectsInput]");
        WebElement dateOfBirth = $("#dateOfBirthInput");
        WebElement addressLocator = $("#currentAddress");
        WebElement stateLocator = $("#state");
        WebElement cityLocator = $("#city");
        WebElement monthSelector = $(".react-datepicker__month-select");
        WebElement yearSelector = $(".react-datepicker__year-select");
        String daySelector = ".react-datepicker__day.react-datepicker__day--0";


        // Actual results for Labels
        ArrayList<String> label = new ArrayList<String>();
        label.add("Student Name");
        label.add("Student Email");
        label.add("Gender");
        label.add("Mobile");
        label.add("Date of Birth");
        label.add("Subjects");
        label.add("Hobbies");
        label.add("Picture");
        label.add("Address");
        label.add("State and City");

        // Actual results for Values
        ArrayList<String> value = new ArrayList<String>();
        value.add("Test Client " + firstName + " Test Client " + lastName);
        value.add(email);
        value.add(female);
        value.add(mobileValue);
        value.add(dataOfBirthResult);
        value.add(empty);
        value.add(hobbies);
        value.add(fileName);
        value.add(address);
        value.add(stateAndCity);

        open(localUrl);

        // Remove banners
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        // Main steps
        $(byText(studentRegistrationFormTitle)).shouldBe(visible);
        String name = $(byAttribute(placeholder, firstName)).getAttribute(placeholder);
        $(byAttribute(placeholder, firstName)).setValue("Test Client " + name);
        String surname = $(byAttribute(placeholder, lastName)).getAttribute(placeholder);
        $(byAttribute(placeholder, lastName)).setValue("Test Client " + surname);
        $(byAttribute(placeholder, email)).setValue(email);
        gender.click();
        ((SelenideElement) mobile).setValue(mobileValue);
        // Calendar
        dateOfBirth.click();
        $(monthSelector).selectOption(month);
        $(yearSelector).selectOption(year);
        $(daySelector + day).click();
        hobbiesLocator.click();
        File file = $("#uploadPicture").uploadFile(new File(filePath));
        ((SelenideElement) addressLocator).setValue(address);
        stateLocator.click();
        $(byText(state)).click();
        cityLocator.click();
        $(byText(city)).click();
        submit.click();
        ((SelenideElement) thanksText).shouldBe(visible);

        for (int i = 0; i < label.size(); i++) {
            String table = "tbody tr:nth-child(%s) td:nth-child(%s)";
            String selectorLabel = String.format(table, i + 1, 1);
            $(selectorLabel).shouldHave(exactText(label.get(i)));
            String selectorValue = String.format(table, i + 1, 2);
            $(selectorValue).shouldHave(exactText(value.get(i)));
        }

        $("[id=closeLargeModal]").click();
        $(byText(studentRegistrationFormTitle)).shouldBe(visible);
    }
}
