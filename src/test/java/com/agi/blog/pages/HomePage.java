package com.agi.blog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By searchInput = By.id("search-field");
    private By searchForm = By.className("search-form");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void performSearch(String searchTerm) {
        // 1. Espera o campo de busca estar presente no HTML
        WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(searchInput));

        // 2. Usa JavaScript para colocar o texto no campo
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", searchField, searchTerm);

        // 3. Submete o formulário
        WebElement form = driver.findElement(searchForm);
        form.submit();
    }
}