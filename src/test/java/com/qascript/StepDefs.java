package com.qascript;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefs {
    WebDriver driver;

    @Given("Launch website")
    public void launchQAScript() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");


    }

    @Then("QAScript page is displayed to user")
    public void qascriptPageIsDisplayedToUser() {

        String strTitle = driver.getTitle();
        Assert.assertEquals(strTitle, "SeleniumHQ Browser Automation");
        driver.quit();
    }
}
