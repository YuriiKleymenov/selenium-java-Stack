# Selenium Java Stack: Amazon Corretto (JDK) + Maven + IntelliJ IDEA + Selenium Java Client + ChromeDriver + Selenium Server Standalone

<p align="center"><a href="https://selenium.dev"><img src="https://selenium.dev/images/selenium_logo_square_green.png" width="100" alt="Selenium"/></a></p>

<p align="center"><b>Универсальный фреймворк для автоматизации работы с браузером<br>и проведения автоматизированного тестирования</b></p>

<p align="center"><a href="https://seleniumbase.io"><img src="https://img.shields.io/badge/docs-seleniumbase.io-11BBAA.svg" alt="SeleniumBase Docs"/><br><img src="https://img.shields.io/badge/Framework-Selenium-blue" alt="Selenium"></a></p>


## Содержание

- [Требования](#требования)
- [Установка Amazon Corretto (JDK)](#установка-amazon-corretto-jdk)
- [Настройка IntelliJ IDEA](#настройка-intellij-idea)
- [Структура проекта](#структура-проекта)
- [Зависимости Maven](#зависимости-maven)
- [Запуск тестов](#запуск-тестов)
- [Selenium Server Standalone](#selenium-server-standalone)
- [ChromeDriver](#chromedriver)
- [Полезные ссылки](#полезные-ссылки)

---

## Требования

- **ОС:** Windows 
- **Amazon Corretto JDK:** 11 или 17 (LTS).
- **IntelliJ IDEA Community/Ultimate.**
- **Maven 3.6+.**
- **Google Chrome** (совместимой версии с ChromeDriver).

---

# 📥 Установка Amazon Corretto (JDK)

Скачайте Corretto с [официального сайта](https://aws.amazon.com/corretto/).

### Windows
1. Установите `.msi` (x64 или ARM64).
2. Отметьте: **Set JAVA_HOME**, **Add to PATH**.
3. Перезапустите терминал.
4. Проверка: `java -version`, `javac -version`.

   Выполните: source ~/.zshrc.

### macOS
1. Установите `.pkg`.
2. Добавьте в `~/.zshrc`:
   ```bash
   export JAVA_HOME=/Library/Java/JavaVirtualMachines/amazon-corretto-<версия>.jdk/Contents/Home
   export PATH=$JAVA_HOME/bin:$PATH
   ```

# Maven 

Основная цель Maven — дать разработчику возможность организовать и собрать Java-проект за максимально короткое время. 
Для этого он:

✅ упрощает процесс сборки
✅ обеспечивает единообразия системы сборки
✅ предоставляет качественную информацию о проекте
✅ поощряет и стремится собрать воедино современные принципы разработки лучших практик
Со всеми функциями и возможностями Maven Вы можете ознакомитьяс на [официальном сайте Maven](https://maven.apache.org/what-is-maven.html).

Если вы только пишете код в IntelliJ IDEA и не работаете с серверами — можно обойтись встроенным Maven, отдельно скачивать не обязательно.
Если вы настраиваете CI/CD, работаете в команде или на сервере — Maven нужно установить отдельно и настроить переменную окружения PATH (чтобы команда mvn работала в терминале)
Краткая инструкциию по установке расположена ниже ⬇️ ссылка на видео с установкой [здесь](https://yandex.ru/video/preview/10847041845917453841).

## ⚙️ Установка Maven

Перед началом работы убедитесь, что у вас установлен **Apache Maven**. Это необходимо для загрузки зависимостей (в том числе `WebDriverManager`), указанных в нашем проекте.

### 1. 📥 Проверка установки

Откройте терминал (или командную строку) и выполните команду:

```bash
mvn -v
```
Ожидаемый результат: Если Maven установлен, вы увидите версию Java и Maven. Если команда не найдена — переходите к шагу 2.

### 2. 📂 Установка Maven
Если Maven не установлен, скачайте архив с [официального сайта](https://maven.apache.org/download.cgi) и распакуйте его.

Настройка переменных окружения (Windows)
Добавьте путь к папке bin Maven в переменную PATH:

* Откройте Параметры системы → Дополнительные параметры системы → Переменные среды.
* В Системных переменных найдите PATH, нажмите Изменить.
* Добавьте путь вида: C:\path\to\apache-maven-3.x.x\bin.

** Проверка после настройки **
Снова выполните mvn -v в терминале. Теперь команда должна работать.

### 3. 📁 Импорт проекта в IDE
* Скопируйте содержимое репозитория в локальную папку.
* Откройте вашу IDE (IntelliJ IDEA, Eclipse, VS Code).
* Выберите Open (или Import) и укажите папку с проектом.
### 4. 🔄 Загрузка зависимостей
Чтобы Maven скачал все библиотеки (включая webdrivermanager), выполните в корне проекта:

```bash
mvn clean install
```
или 
```bash
mvn dependency:resolve
```
### 5. ✅ Проверка готовности
После успешной загрузки в папке проекта появится скрытая папка .m2 (локальный репозиторий Maven) и сгенерированные файлы.

Теперь Вы можете запускать тесты — все зависимости подключены.


#  IntelliJ IDEA
<img src="https://img.shields.io/badge/IDE-IntelliJ_IDEA-blue" alt="IntelliJ IDEA">

**IntelliJ IDEA** — профессиональная среда разработки от JetBrains, оптимизированная для Java‑проектов.  
✅ Автоматизирует рутинные задачи (генерация кода, рефакторинг, навигация).  
✅ Предоставляет расширенные инструменты анализа кода и поиска ошибок.  
✅ Интегрируется с Maven, Git и средствами запуска тестов (TestNG).  

В этом репозитории используется как основная среда для разработки и отладки автотестов.

 Руководство по установке IDE для разработки на языке Java и других языках программирования. 
 Официальный сайт JetBrains с российский IP-адресов может быть не доступен. В случае блокирования данного сайта, для скачивания IntelliJ IDEA и активации лицензии рекомедуется воспользоваться VPN.

## 📥 Скачивание IntelliJ IDEA
1. Откройте официальный сайт Jetbrains - https://www.jetbrains.com/idea/download/;
2. Скачать версию Ultimate, так как она предоставляет более полный набор инструментов для разработки и автоматизации тестирования, включая поддержку фреймворков и баз данных;
3. Выберите необходимую веерсию ОС (Windows или MacOS) и файл .exe (для Windows) и .dmg (для macOS);
4. Нажать кнопку Download.

## ⚙️ Установка

Windows
1. Запустите скаченный установочный файл .exe;
2. Следую по шагам установщика на этапе выбора компонентов отметьте нужные ассоциации файлов и создания ярлыков.

macOS
1. Откройте скаченный установочный файл .dmg;
2. Переместите IntelliJ IDEA в папку Applications.

## 🔐 Активация
IntelliJ IDEA Ultimate является платным продуктом. Доступны следующие варианты лицензии:

* Пробная версия (Trial): 30 дней бесплатного использования;
* Для студентов: бесплатная лицензия через JetBrains Education;
* Корпоративная лицензия: через организацию;
* Индивидуальная подписка: покупка на официальном сайте;

## 🚀 Первый запуск и создание проекта.
Отклоните предложение импортировать настройки (выберите Do not import settings), если вы устанавливаете IntelliJ IDEA впервые.
Примите лицензионное соглашение.
Активируйте лицензию (гражданам РФ при необходимости используя VPN).

1. Откройте IntelliJ IDEA.
2. Затем File(Меню) → New → Project
3. В открывшемся модальном окне выберете: Maven(Build system) - сorretto - 19(2);
4. Выбрать название проекта и нажать Create.

## ▶️ После того как Вы нажали **Create** и проект открылся в IntelliJ IDEA:

- **Дождитесь загрузки зависимостей** — Maven скачает Selenium, TestNG и WebDriverManager. Статус виден внизу окна IDEA в панели Maven.
- **Запустите базовый тест** — нажмите ▶️ рядом с `BasicTest.java`. Должен открыться Chrome и выполниться тест на Google.
- **Убедитесь, что тест прошёл** — в окне Run отобразится `PASSED` и вывод `Page title: Google`.
- **Начинайте писать свои тесты** — создавайте новые классы в `src/test/java` по аналогии с `BasicTest`.

Теперь проект полностью готов к разработке автотестов.

# Selenium Java Client


# 🖥 Selenium Server Standalone
Selenium Server — это центральный хаб, который позволяет управлять браузерами удалённо. Данный инструмент необходим, если вы планируете запускать тесты на разных браузерах и использовать Grid.

## 📥 Скачивание

### Вариант А: Через Maven (рекомендуется)

Добавьте зависимость в pom.xml (аналогично Selenium Client):

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-server</artifactId>
    <version>4.19.1</version>
</dependency>
```
### Вариант Б: Ручная загрузка

* Перейдите на [сайт загрузки Selenium](https://www.selenium.dev/downloads/).
* В разделе Selenium Client & WebDriver Language Bindings найдите блок Java.
* Скачайте файл selenium-server-{version}.jar.

## 🛠 Способы установки и запуска
Способ 1: Запуск через Java (локально)
После добавления в pom.xml сервер можно запустить из командной строки:

```bash
java -jar selenium-server-4.19.1.jar
```

Или через Maven (либо через [сайт Maven](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)):
```bash
mvn exec:java -Dexec.mainClass="org.openqa.selenium.grid.main.Main"
```

По умолчанию сервер работает на порту 4444 и будет доступен по адресу http://localhost:4444.


## 〽️ Проверьте работу
После запуска в консоли появится сообщение о старте сервера. 
Откройте в браузере адрес:
```text
http://localhost:4444/grid/console
```
Если страница загрузилась и вы видите веб-интерфейс — сервер работает корректно. :white_check_mark:
## Пример:
```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class RemoteTest {
    public static void main(String[] args) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        
        WebDriver driver = new RemoteWebDriver(
            new URL("http://localhost:4444"), 
            capabilities
        );
        
        try {
            driver.get("https://www.google.com");
            System.out.println("Page title: " + driver.getTitle());
        } finally {
            driver.quit();
        }
    }
}
```
# Chrome Driver - установка на ПК с ОС Windows

## 👓 Проверьте версию Вашего браузера Google Chrome 
Для этого необходимо: 
* открыть браузер и в правом верхнем углу нажать на кнопку "Настройка и управление Google Chrome"  ⋮ → "Справка" → "О браузере Google Chrome".
* далее браузер должен автоматически скачать последние обновления и отобразить кнопку "Перезапустить". 
* нажимаем кнопку "Перезапустить" (не забудьте перед этим сохранить все не сохраненные файлы).
После перезапуска нам потребуется запомнить или скопировать номер последней версии браузера.

## 💻 **Скачиваем подходящий драйвер**  
   * Теперь идём на [официальный сайт Chrome Driver](https://sites.google.com/chromium.org/driver/getting-started).
   * Находим на странийе гиперссылку downloads и выбираем(кликаем) версию, которая идеально подходит под ваш браузер.
   * Далее скачайте архив с названием `chromedriver_win32.zip`.

## 📂 **Распаковка и настройка**  
   Осталось сделать драйвер доступным для программы.
   * Распакуйте скачанный ZIP-архив.
   * Переместите файл `chromedriver.exe` в удобную папку (например, в корень вашего проекта).
   * **Важно:** добавьте путь к этой папке в переменную окружения `PATH`. Так вы сможете запускать драйвер из любой консоли.
Либо с помощью WebDriverManager:
* Просто вставьте этот блок в ваш `pom.xml` в секцию `<dependencies>`::
 ```xml
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>6.1.0</version>
</dependency>
```
Далее в нашем коде импортируем нужные классы и запускаем автоматическую настройку:
```java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestExample {
    public static void main(String[] args) {
        // автоматическая загрузки драйвера
        WebDriverManager.chromedriver().setup();

        // Теперь можно спокойно создавать драйвер
        WebDriver driver = new ChromeDriver();

        // Дальнейший код
    }
}
```
### ⚠️ На что обратить внимание 

1. **Драйвер должен быть** — WebDriverManager сам его скачает, но если что-то пошло не так, проверьте, есть ли драйвер для вашего браузера (например, `chromedriver.exe`).
2. **Следите за версиями** — Selenium и WebDriver должны «дружить» между собой. Если версии не совпадают, тесты могут не запуститься.
3. **Пользуйтесь автоматикой** — не мучайтесь с ручной установкой, пусть `WebDriverManager` всё сделает за вас. Это быстрее и надежнее.
4. **Если всё же вручную** — не забудьте закинуть все файлы из папки `libs/` в проект, иначе могут быть ошибки зависимостей.
5. **Следите за совместимостью версий Selenium и WebDriver
   
### Примеры тестов:
 * Выбор определенного чекбокса
```java
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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebDriverCheckboxes {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String TEST_URL = "https://www.urn.su/ui/basic_test/";
    private static final String CHECKBOXES_ID = "cerseiId";

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(TEST_URL);
    }

    @Test
    void clickCheckboxesById() {
        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(By.id(CHECKBOXES_ID))
        );
        checkbox.click();
        assertTrue(checkbox.isSelected(), "Чекбокс не был выбран");

    }
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
```
 * Клик определенного радиобаттона
```java
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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebDriverCheckboxes {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String TEST_URL = "https://www.urn.su/ui/basic_test/";
    private static final String CHECKBOXES_ID = "cerseiId";

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(TEST_URL);
    }

    @Test
    void clickCheckboxesById() {
        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(By.id(CHECKBOXES_ID))
        );
        checkbox.click();
        assertTrue(checkbox.isSelected(), "Чекбокс не был выбран");

    }
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
```
* Поиск по CSS селектору
```java
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

public class TestItalia {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final String TEST_URL = "https://www.urn.su/ui/basic_test/";
    private static final String LINK_SELECTOR = "a[class='march8']";
    private static final String EXPECTED_TITLE = "8 марта в Италии в 2026 году";


    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();// на весь экран окно
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));//задержка на 10 сек
        driver.get(TEST_URL);
    }

    @Test
    void clickLinkByCssSelectorAndCheckTitle() {
        WebElement march8Link = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(LINK_SELECTOR))
        );
        ((JavascriptExecutor) driver).executeScript(// браузер пролистывает до конкретного элемента с которым работаем
                "arguments[0].scrollIntoView({block: 'center'});",
                march8Link
        );
        wait.until(ExpectedConditions.elementToBeClickable(march8Link)).click();
        wait.until(ExpectedConditions.titleIs(EXPECTED_TITLE));// ждем пока заголовок станет равным нашему заголовку
        String actualTitle = driver.getTitle();
        assertEquals(EXPECTED_TITLE, actualTitle, "Заголовок не совпал");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
```

