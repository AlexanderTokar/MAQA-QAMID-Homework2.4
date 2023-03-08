package ru.netology.qa;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TextTest {
    private AndroidDriver driver;
    public String inputText = "hello";

    @BeforeAll
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Some name");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void changeTextInTextField() {
        MainScreen mainScreen = new MainScreen(driver);
        String expected = mainScreen.textField.getText();
        mainScreen.textTest.setValue(" ");
        mainScreen.buttonChange.click();
        Assertions.assertEquals(expected, mainScreen.textField.getText());
    }

    @Test
    public void showTextOnNewActivity() {
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.textTest.setValue(inputText);
        mainScreen.newActivityButton.click();
        Assertions.assertEquals(inputText, mainScreen.textOnNewActivity.getText());
    }

    @AfterAll
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
