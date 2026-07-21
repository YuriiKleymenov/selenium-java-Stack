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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestSocialMediaLinks { //  Мы ищем все ссылки <a> на странице, у которых в href есть vk.com или ok.ru
    private WebDriver driver;
    private WebDriverWait wait;

    private static final By SOCIAL_LINKS_SELECTOR = By.cssSelector("a[href*='vk.com'], a[href*='ok.ru']");
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
    void SocialLinksOnMainPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(SOCIAL_LINKS_SELECTOR));// Ждем появления хотя бы одной ссылки из блока соцсетей

        List<WebElement> socialLinksList = driver.findElements(SOCIAL_LINKS_SELECTOR);
        System.out.println("Количество найденных иконок соцсетей на главной странице: " + socialLinksList.size()); // Печать количества иконок соц.сетей, которые найдены.

        assertFalse(socialLinksList.isEmpty(), "На сайте школы не найдено ни одной ссылки-иконки на ВК или Одноклассники!");

        for (WebElement link : socialLinksList) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});",
                    link
            );
            // Получаем точный адрес группы школы
            String socialHref = link.getAttribute("href");
            System.out.println("Успешно найдена  ссылка/и соцсети/ей: " + socialHref);
        }
        System.out.println("Тест проверки списков социальных сетей пройден!");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

