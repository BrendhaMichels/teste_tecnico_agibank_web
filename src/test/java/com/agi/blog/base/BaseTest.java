package com.agi.blog.base;

import com.agi.blog.reports.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; // Importe a classe de Opções
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        if (System.getenv("GITHUB_ACTIONS") != null) {
            options.addArguments("--headless");
        }

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://blogdoagi.com.br/");

        handleCookieBanner();
    }

    private void handleCookieBanner() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            By cookieAcceptButton = By.id("cookie-notice-accept");
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("Banner de cookies não encontrado ou já aceito.");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}