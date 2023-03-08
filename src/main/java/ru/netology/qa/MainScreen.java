package ru.netology.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class MainScreen {

    private List<MobileElement> digitButtons;

    @AndroidFindBy(id = "userInput")
    public MobileElement textTest;

    @AndroidFindBy(id = "buttonChange")
    public MobileElement buttonChange;

    @AndroidFindBy(id = "textToBeChanged")
    public MobileElement textField;

    @AndroidFindBy(id = "buttonActivity")
    public MobileElement newActivityButton;

    @AndroidFindBy(id = "text")
    public MobileElement textOnNewActivity;

    public MainScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
}
