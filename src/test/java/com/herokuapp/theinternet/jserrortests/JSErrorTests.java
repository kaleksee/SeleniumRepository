package com.herokuapp.theinternet.jserrortests;

import java.util.List;

import com.herokuapp.theinternet.base.BaseTest;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.pages.JSErrorPage;

public class JSErrorTests extends BaseTest {

    @Test
    public void jsErrorTest() {
        log.info("Starting jsErrorTest");
        SoftAssert softAssert = new SoftAssert();

        // Open JSErrorPage
        JSErrorPage jSErrorPage = new JSErrorPage(driver, log);
        jSErrorPage.openPage();

        // Get logs
        List<LogEntry> logs = getBrowserLogs();

        // Verifying there are no JavaScript errors in console
        for (LogEntry logEntry : logs) {
            if (logEntry.getLevel().toString().equals("SEVERE")) {
                softAssert.fail("Severe error: " + logEntry.getMessage());
            }
        }
        softAssert.assertAll();
    }
}

