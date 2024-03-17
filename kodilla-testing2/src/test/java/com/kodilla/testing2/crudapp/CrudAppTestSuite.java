package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://pmerecki.github.io/";
    private static WebDriver driver;
    private static Random generator;

    @BeforeEach
    public void init() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        cleanUpInCRUDApp(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK = "//form[contains(@action,\"createTask\")]";
        final String XPATH_TASK_NAME = XPATH_TASK + "/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = XPATH_TASK + "/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = XPATH_TASK + "/fieldset[3]/button";

        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(8000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class,\"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(8000);
        driver.switchTo().alert().accept();
    }

    private void cleanUpInCRUDApp(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement buttonDeleteCard =
                            theForm.findElement(By.xpath(".//button[@data-task-delete-button]"));
                    buttonDeleteCard.click();
                });
        Thread.sleep(8000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("twoj_login");
        WebElement el = driverTrello.findElement(By.id("login"));
        el.submit();

        Thread.sleep(10000);

        driverTrello.findElement(By.id("password")).sendKeys("twoj_haslo");
        driverTrello.findElement(By.id("login-submit")).submit();

        Thread.sleep(10000);

        for (WebElement aHref : driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]"))) {
            if (!aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).isEmpty()) {
                aHref.click();
                break;
            }
        }

        Thread.sleep(10000);

        boolean result = driverTrello.findElements(By.xpath("//a")).stream()
                .anyMatch(link -> link.getText().contains(taskName));

        driverTrello.close();

        return result;
    }


    @AfterAll
    public static void cleanUpAfterTest() {
        driver.close();
    }
}