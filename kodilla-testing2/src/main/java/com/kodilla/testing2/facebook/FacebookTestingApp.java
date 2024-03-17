package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {
    private WebDriver driver;
    private WebDriverWait wait;

    public void setUp() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillOutBirthdayForm() {
        WebElement cookieAcceptButton = driver.findElement(By.xpath("//button[@data-testid='cookie-policy-manage-dialog-accept-button']"));
        cookieAcceptButton.click();
        waitForVisibilityOfElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        WebElement createAccountButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createAccountButton.click();

        waitForVisibilityOfElement(By.xpath("//select[@id='day']"));
        selectValueFromDropdown(By.xpath("//select[@id='day']"), "10");

        waitForVisibilityOfElement(By.xpath("//select[@id='month']"));
        selectValueFromDropdown(By.xpath("//select[@id='month']"), "6");

        waitForVisibilityOfElement(By.xpath("//select[@id='year']"));
        selectValueFromDropdown(By.xpath("//select[@id='year']"), "1981");
    }

    private void waitForVisibilityOfElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void selectValueFromDropdown(By locator, String value) {
        WebElement selectCombo = driver.findElement(locator);
        Select selectBoard = new Select(selectCombo);
        selectBoard.selectByValue(value);
    }

    public static void main(String[] args) {
        FacebookTestingApp app = new FacebookTestingApp();
        app.setUp();
        app.fillOutBirthdayForm();
    }
}
