package com.herokuapp.theinternet.hoverstests;

import com.herokuapp.theinternet.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.pages.HoversPage;

public class HoversTests extends BaseTest {

    @Test
    public void user2ProfileTest() {
        log.info("Starting user2ProfileTest");

        // Open HoversPage
        HoversPage hoversPage = new HoversPage(driver, log);
        hoversPage.openPage();

        // Open User 2 profile
        hoversPage.openUserProfile(2);

        // Verify correct user profile opened
        Assert.assertTrue(hoversPage.getCurrentUrl().contains("/users/2"),
                "Url of opened page is not expected User 1 page url");
    }
}
