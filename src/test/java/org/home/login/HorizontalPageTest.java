package org.home.login;

import com.codeborne.selenide.SelenideElement;
import manager.HorizontalPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;


public class HorizontalPageTest {

    HorizontalPage horizontalPage = new HorizontalPage();


    @BeforeMethod
    public void open(){
        horizontalPage.openPage();
    }

    @Test
    public void sliderTest(){
        String value = "4";
       horizontalPage.moveSlider(value);
       horizontalPage.sliderResult().shouldHave(text(value));

    }
}
