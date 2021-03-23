package pages.scenarios;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ObjectForm {

    //ТестДату лучше тут не размещать
   private String  site = "https://demoqa.com/automation-practice-form",
            firstName = "Boka",
            lastName  = "Joka",
            userEmail = "legenda@mir.com",
            gender = "Other",
            userNumber = "8005553535",
            monthBirth = "8",
            yearBirth = "1980",
            dayBirth = "003",
            subject1 = "arts",
            hobby = "Music",
            picture = "joka.jpg",
            currentAddress = "Russia, Krasnodar, Krasnaya 5",
            state = "ncr",
            city = "gurgaon";

    public void openPage() {
        open(site);


    }

    public ObjectForm fillForm() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        setData(yearBirth, monthBirth, dayBirth);
        $("#subjectsInput").setValue(subject1).pressEnter();
        $(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();
        return this;
    }

    public void setData (String year, String month, String day ) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(month);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__day.react-datepicker__day--" + day).click();

    }

    public void checkData() {
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
