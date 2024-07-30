package org.fetch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonFunctions {
    WebDriver driver;

    public CommonFunctions(WebDriver driver) {
        this.driver=driver;
    }
    static Duration WAIT_TIMEOUT = Duration.ofMillis(30000);
    public String captureAlertMessage() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertMessage;
    }

    public static int[] identifyFakeGroup(String weighResult, int[] group1, int[] group2, int[] group3) {
        if (weighResult.contains("=")) {
            // both groups are equal, fake gold bar must be in group3
            return group3;
        } else if (weighResult.contains("<")) {
            //fake gold bar is in group 1
            return group1;
        } else if (weighResult.contains(">")) {
            //fake gold bar is in group 3
            return group2;
        } else {
            throw new IllegalArgumentException("WeighResult is not valid");
        }
    }

    public static int identifyFakeBarInGroup(String weighResult, int[] group) {
        if (weighResult.contains("=")) {
            // third bar is the fake one
            return group[2];
        } else if (weighResult.contains("<")) {
            // first bar is the fake one
            return group[0];
        } else {
            // second bar is the fake one
            return group[1];
        }
    }
}
