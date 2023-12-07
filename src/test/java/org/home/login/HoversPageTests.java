package org.home.login;

import manager.HomePage;
import manager.HoversPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversPageTests  extends TestBase{

    public HoversPage openHoversPage(){
        HomePage homePage = new HomePage(webDriver);
        HoversPage hoversPage = homePage.openHoversPage();
        return hoversPage;
    }

    @Test
    public void clickAvatarTest(){
        HoversPage hoversPage = openHoversPage();
       // hoversPage.clickOfPicture();
        hoversPage.hoverOfAvatarPicture(1);
        Assert.assertEquals(hoversPage.getTextAvatar(),"name: user1");
    }

   @Test
    public void checkAllPictures(){
        HoversPage hoversPage =openHoversPage();
       for (int i = 1; i < 4; i++) {
           hoversPage.hoverOfAvatarPicture(i);
           Assert.assertEquals(hoversPage.getTextAvatar(),"name: user"+ i);
       }
   }
}
