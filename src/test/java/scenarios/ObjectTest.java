package scenarios;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.ObjectForm;

public class ObjectTest {
    pages.ObjectForm ObjectForm = new ObjectForm();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillForm() {
        ObjectForm
                .openPage()
                .fillForm()
                .checkData();
    }
}
