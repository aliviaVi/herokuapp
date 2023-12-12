package org.home.login;

import manager.InputsPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PageInputs;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class InputsPageTests{
    InputsPage inputsPage = new InputsPage();

    @BeforeMethod
    public void openPage(){
        inputsPage.openPage();
    }

    @Test
    public void inputSuccess (){
        inputsPage.typeValue();
        $(By.xpath("//input[@type='number']")).getAttribute("value").equals(1);
    }
    @Test
    public void inputThanDownValue(){
        inputsPage.typeValue();
        inputsPage.typeValue();
        inputsPage.downValue();
        $(By.xpath("//input[@type='number']")).getAttribute("value").equals(1);
    }
}
