package com.qascript;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class StepDefs {
    WebDriver driver;
    String username = System.getenv("BROWSERSTACK_USERNAME");
    String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
    String URL = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";

    @Given("Launch website")
    public void launchQAScript() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");

    }

    @Then("Verify webpage is displayed to user")
    public void qascriptPageIsDisplayedToUser() {

        String strTitle = driver.getTitle();
        Assert.assertEquals(strTitle, "SeleniumHQ Browser Automation");
        driver.quit();
    }

    @Given("Launch website in BS")
    public void launchWebsiteInBS() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "80");
        caps.setCapability("build", "1.0");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("project", "Browserstack Demo");
        caps.setCapability("name", "BS Test");
        try {
            WebDriver bs_driver = new RemoteWebDriver(new URL(URL), caps);
            bs_driver.get("https://www.selenium.dev/");
            String strTitle = bs_driver.getTitle();
            Assert.assertEquals(strTitle, "SeleniumHQ Browser Automation");
            bs_driver.quit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
