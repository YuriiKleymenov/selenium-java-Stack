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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestKristallikRules {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final By LINK_LOCATOR = By.xpath("//a[contains(., 'Правила приема в школу')]");
    private static final String EXPECTED_TITLE = "Правила приема";
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
    void clickLinkByTextSelectorAndCheckTitle() {
        WebElement linkElement = wait.until(
                ExpectedConditions.elementToBeClickable(LINK_LOCATOR)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
                linkElement
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                linkElement
        );
        wait.until(ExpectedConditions.titleContains(EXPECTED_TITLE));
        String actualTitle = driver.getTitle();
        System.out.println("Текущий заголовок: " + actualTitle + " - Проверка пройдена успешно!");
        assertTrue(actualTitle.contains(EXPECTED_TITLE),
                "Заголовок '" + actualTitle + "' не содержит ожидаемой фразы '" + EXPECTED_TITLE + "'");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
