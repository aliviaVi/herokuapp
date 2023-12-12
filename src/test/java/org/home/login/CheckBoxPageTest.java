package org.home.login;

import com.codeborne.selenide.Condition;
import manager.Checkboxes;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;

public class CheckBoxPageTest {
    Checkboxes checkboxes = new Checkboxes();


    @BeforeMethod
    public void open(){
        checkboxes.openPage();
    }

    @Test
    public void CheckboxTest(){
        checkboxes.clickCheckBox();
        checkboxes.reviewCheckBox().shouldHave(attribute("checked"));
    }
}
