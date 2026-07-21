package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDirectorEmail {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final By DIRECTOR_EMAIL_LOCATOR = By.xpath("//a[contains(@href, 'mailto:sar-kristallik@mail.ru')]");
    private static final By MENU_LOCATOR = By.xpath("//a[text()='Руководство']");
    private static final String EXPECTED_TITLE = "Руководство";
    private static final String TEST_URL = "https://kristallik-sar.gosuslugi.ru/";

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(TEST_URL);
    }

    @Test
    void checkDirectorEmailOnPage() {
        WebElement linkElement = wait.until(
                ExpectedConditions.elementToBeClickable(MENU_LOCATOR)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
                linkElement
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                linkElement
        );
        wait.until(ExpectedConditions.titleContains(EXPECTED_TITLE));// Ждем, пока ссылка с email директора появится в DOM-дереве
        WebElement emailLink = wait.until(
                ExpectedConditions.presenceOfElementLocated(DIRECTOR_EMAIL_LOCATOR)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                emailLink
        );

        assertTrue(emailLink.isDisplayed(), "Email директора не найден!");

        String actualEmailText = emailLink.getText();
        System.out.println("Найден email директора: " + actualEmailText + "\nПроверка пройдена успешно!");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

