package org.home.login;

import manager.HoversPage;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HoversPageTests {
    HoversPage hoversPage = new HoversPage();

    @BeforeMethod
    public void openPage(){
        hoversPage.openPage();
    }

    @Test
    public void checkAllPictures(){
        for (int i = 1; i < 4  ; i++) {
            hoversPage.hoverOfAvatarPicture(i);
           Assert.assertTrue(hoversPage.getTextAvatar("user" + i, i -1));
        }
    }

    @Test
    public void clickAvatarByIndex(){
        hoversPage.hoverOfAvatarPicture(2);
        Assert.assertTrue(hoversPage.getTextAvatar("user2" , 1));
    }

}
