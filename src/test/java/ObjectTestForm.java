import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Selected;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ObjectTestForm {
    String  firstName = "Boka",
            lastName  = "Joka",
            userEmail = "legenda@mir.com",
            gender = "Other",
            userNumber = "8005553535",
            monthOfBirth = "8",
            yearOfBirth = "1980",
            dayOfBirth = "003",
            subject1 = "arts",
            hobby = "Music",
            picture = "joka.jpg",
            currentAddress = "Russia, Krasnodar, Krasnaya 5",
            state = "ncr",
            city = "gurgaon";


    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillForm() {
        //открываем сайт
        open("https://demoqa.com/automation-practice-form");

        //заполняем формы
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(monthOfBirth);
        $(".react-datepicker__year-select").selectOptionByValue(yearOfBirth);
        $(".react-datepicker__day.react-datepicker__day--" + dayOfBirth).click();
        $("#subjectsInput").setValue(subject1).pressEnter();
        $(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        //проверяем ввод
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(userEmail),
                text(gender),
                text(userNumber),
                text("03 September,1980"),
                text(subject1),
                text(hobby),
                text(picture),
                text(currentAddress),
                text(state + " " + city));

        sleep(3000);
    }

}