package pages.scenarios;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ObjectTest {
    ObjectForm ObjectForm = new ObjectForm();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillForm() {
        ObjectForm.openPage();
        ObjectForm
                .fillForm()
                .checkData();
            // попробовал оба варианта чтобы разобратся, все понятно теперь.
    }
}
