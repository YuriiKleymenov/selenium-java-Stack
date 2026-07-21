package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSheduleOpen {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final By SCHEDULE_MENU_LOCATOR = By.linkText("Расписание");
    private static final String EXPECTED_URL = "https://disk.yandex.ru/i/zEViogQ8pJNBmw";
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
    void verifyScheduleLinkIsCorrect() {
        WebElement scheduleMenu = wait.until(
                ExpectedConditions.presenceOfElementLocated(SCHEDULE_MENU_LOCATOR)
        );
        String actualUrlFromAttribute = scheduleMenu.getAttribute("href");
        System.out.println("Ссылка на кнопке расписания: " + actualUrlFromAttribute);

        assertTrue(actualUrlFromAttribute.toLowerCase().contains("zeviogq8pjnbmw"),
                "На сайте школы изменилась или прописана неверная ссылка на расписание! Получено: " + actualUrlFromAttribute);
        System.out.println("Проверка атрибута выполнена успешно!");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
