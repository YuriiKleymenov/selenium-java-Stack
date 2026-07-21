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

public class TestToServiceUchiRu {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final By SERVICES_LOCATOR = By.linkText("Услуги и сервисы");
    private static final By UCHI_CSS_LOCATOR = By.cssSelector("a[href^='https://uchi.ru']");
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
    void serviceLinkWithMenuClick() {
        WebElement servicesMenu = wait.until(
                ExpectedConditions.elementToBeClickable(SERVICES_LOCATOR) //Ждем и кликаем на "Услуги и сервисы" в главном меню
        );
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", servicesMenu
        );
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", servicesMenu
        );

        WebElement uchiLink = wait.until(
                ExpectedConditions.presenceOfElementLocated(UCHI_CSS_LOCATOR)// Ждем появления карточки Учи.ру на открывшейся странице по CSS-селектору
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", uchiLink // Проскролливаем страницу до карточки Учи.ру, чтобы она отображалась
        );

        String actualLinkText = uchiLink.getText();
        System.out.println("Текст внутри найденного CSS-элемента: " + actualLinkText);

        assertTrue(actualLinkText.toLowerCase().contains("учи.ру"), // Проверка, что текст карточки содержит слово "Учи.ру"
                "Текст внутри блока не содержит слово Учи.ру! Получено: " + actualLinkText);

        System.out.println("Тест успешно пройден!");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}