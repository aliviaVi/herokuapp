package org.home.login;

import manager.HomePage;
import manager.InputsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputsPageTests  extends TestBase{


    public InputsPage openInputsPage(){
        HomePage homePage = new HomePage(webDriver);
        InputsPage inputsPage = homePage.openInputsPage();
        return inputsPage;
    }

    @Test
    public void inputSuccess(){
        InputsPage inputsPage = openInputsPage();
        inputsPage.typeValue();

        Assert.assertEquals(webDriver.findElement(By.xpath("//input[@type='number']")).getAttribute("value"), "1");
    }

    @Test
    public void inputValuePlusDownValueSuccess(){
        InputsPage inputsPage = openInputsPage();
        inputsPage.typeValue();
        inputsPage.typeValue();
        inputsPage.downValue();

        Assert.assertEquals(webDriver.findElement(By.xpath("//input[@type='number']")).getAttribute("value"), "1");

    }
}
