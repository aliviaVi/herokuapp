package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.Key;

public class InputsPage {
    protected WebDriver webDriver;

    private By inputValueArea =  By.xpath("//input[@type='number']");

    public InputsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void typeValue(){
        WebElement webElement = webDriver.findElement(inputValueArea);
        webElement.sendKeys(Keys.UP);
    }

    public void downValue(){
        WebElement element = webDriver.findElement(inputValueArea);
        element.sendKeys(Keys.DOWN);
    }
}
