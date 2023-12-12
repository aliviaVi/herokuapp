package manager;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.PageInputs;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HorizontalPage {

    protected static By SLIDER = By.xpath("//*[@id='content']/div/div/input");
    private static By SLIDERRESULT = By.id("range");

    public HorizontalPage openPage() {
        return page(open(PageInputs.PAGE_URL + "/horizontal_slider", HorizontalPage.class));
    }

    public void moveSlider(String value) {
        $(SLIDER).setValue(value);
    }

    public SelenideElement sliderResult() {
        return $(SLIDERRESULT);
    }
}
