# Amazon Corretto (JDK) + IntelliJ IDEA + Maven + Selenium Java Client + ChromeDriver + Selenium Server Standalone

<p align="center"><a href="https://selenium.dev"><img src="https://selenium.dev/images/selenium_logo_square_green.png" width="100" alt="Selenium"/></a></p>

<p align="center"><b>Универсальный фреймворк для автоматизации работы с браузером<br>и проведения автоматизированного тестирования</b></p>

<p align="center"><a href="https://seleniumbase.io"><img src="https://img.shields.io/badge/docs-seleniumbase.io-11BBAA.svg" alt="SeleniumBase Docs"/></a></p>

[(Текст который станет link)](https://kristallik-sar.gosuslugi.ru/)

# Selenium Java Stack: Amazon Corretto + IntelliJ IDEA + Maven + ChromeDriver + Selenium Server

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

- **ОС:** Windows / macOS / Linux.
- **Amazon Corretto JDK:** 11 или 17 (LTS).
- **IntelliJ IDEA Community/Ultimate.**
- **Maven 3.6+.**
- **Google Chrome** (совместимой версии с ChromeDriver).

---

## 📥 Установка Amazon Corretto (JDK)

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

## 💡 Установка IntelliJ IDEA
 Руководство по установке IDE для разработки на языке Java и других языках программирования. 
 Официальный сайт JetBrains с российский IP-адресов может быть не доступен. В случае блокирования данного сайта, для скачивания IDE и активации лицензии рекомедуется воспользоваться VPN.

📥 Скачивание IntelliJ IDEA
1. Откройте официальный сайт Jetbrains - https://www.jetbrains.com/idea/download/;
2. Скачать версию Ultimate, так как она предоставляет более полный набор инструментов для разработки и автоматизации тестирования, включая поддержку фреймворков и баз данных.
3. Выберите необходимую веерсию ОС (Windows или MacOS). 

#💡 Настройка IntelliJ IDEA

Откройте IntelliJ IDEA.

File → New → Project → Maven.

Укажите:

GroupId: com.example.selenium

ArtifactId: selenium-java-demo

В настройках проекта (File → Project Structure → Project) укажите SDK: путь к Amazon Corretto.

Импортируйте проект как Maven (если уже создан).







## 1. Глава 1

Настройка IntelliJ IDEA
Откройте IntelliJ IDEA.

File → New → Project → Maven.

Укажите:

GroupId: com.example.selenium

ArtifactId: selenium-java-demo

В настройках проекта (File → Project Structure → Project) укажите SDK: путь к Amazon Corretto.

Импортируйте проект как Maven (если уже создан).


Тестирование сайта `Кисталик` проходит относительно успешно!
При тестировании использовались следующие фрэймворки:
* IntelliJ IDE
* Selenium
* И язык JAVA

  ![Chrome](https://raw.githubusercontent.com/alrra/browser-logos/main/src/chrome/chrome_24x24.png) Chrome

```
Текст для быстрого копирования
```
* Один из пунктов
  * под пункт
  * и следующий
  * найди время чем всё заполнить

```bash
cd..
```

<p align="center"> <img  width="100" height="120" alt="istockphoto-1453829654-612x612" src="https://github.com/user-attachments/assets/779e46ac-261d-4360-a45e-7789d2a41bee" /> </p>

```java
System.out.println("Hello");
```
