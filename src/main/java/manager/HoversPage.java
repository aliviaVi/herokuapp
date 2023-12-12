package manager;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.PageInputs;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class HoversPage {


    private By userAvatarXPath = By.xpath("//*[@id='content']/div/div[1]");
    private By userAvatar = By.tagName("img");
    private By avatarText = By.tagName("h5");
    private By hoversTextOnThePage = By.xpath("//*[@id='content']/div/h3"); 

    public HoversPage openPage(){
      return   page(open(PageInputs.PAGE_URL + "/hovers", HoversPage.class));
    }

    public void hoverOfAvatarPicture(int i){
        $$(userAvatar).get(i).hover();

    }

    
    public boolean getTextAvatar(String username, int index){
        String avatarTextByIndex = $$(avatarText).get(index).getText();
        return avatarTextByIndex.contains(username);

    }
}
