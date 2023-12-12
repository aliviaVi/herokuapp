package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.PageInputs;

import static com.codeborne.selenide.Selenide.*;

public class InputsPage {

    private By inputValueArea =  By.xpath("//input[@type='number']");


    public void typeValue(){
        $(inputValueArea).type(Keys.UP);
    }

    public void downValue(){
        $(inputValueArea).type(Keys.DOWN);
    }

    public InputsPage openPage() {
        return page(open(PageInputs.PAGE_URL + "/inputs", InputsPage.class));
    }
}
