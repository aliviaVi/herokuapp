package manager;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.PageInputs;

import static com.codeborne.selenide.Selenide.*;

public class Checkboxes {

    private static final By CHECKBOXTEXT = By.xpath("//form/input[1]");
    private static final By CHECKBOX = By.xpath("//*[@id='checkboxes']/input[1]");



    public Checkboxes openPage(){
        return page(open(PageInputs.PAGE_URL + "/checkboxes", Checkboxes.class));
    }

    public void clickCheckBox(){
        $(CHECKBOX).click();
    }
    public SelenideElement reviewCheckBox(){
        return $(CHECKBOX);
    }
}
