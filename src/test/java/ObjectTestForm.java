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

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillForm() {
        //открываем сайт
        open("https://demoqa.com/automation-practice-form");

        //заполняем формы
        $("#firstName").setValue("Boka");
        $("#lastName").setValue("Joka");
        $("#userEmail").setValue("legenda@mir.com");
        $(byText("Other")).click();
        $("#userNumber").setValue("8005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("8");
        $(".react-datepicker__year-select").selectOptionByValue("1980");
        $(".react-datepicker__day.react-datepicker__day--003").click();
        $("#subjectsInput").setValue("arts").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("joka.jpg");
        $("#currentAddress").setValue("Russia, Krasnodar, Krasnaya 5.");
        $("#react-select-3-input").setValue("ncr").pressEnter();
        $("#react-select-4-input").setValue("gurgaon").pressEnter();
        $("#submit").click();

        //проверяем ввод
        $(".table-responsive").shouldHave(text("Boka Joka"),
                text("legenda@mir.com"),
                text("Other"),
                text("8005553535"),
                text("03 September,1980"),
                text("Arts"),
                text("Music"),
                text("Joka.jpg"),
                text("Russia, Krasnodar, Krasnaya 5."),
                text("NCR Gurgaon"));
    }

}