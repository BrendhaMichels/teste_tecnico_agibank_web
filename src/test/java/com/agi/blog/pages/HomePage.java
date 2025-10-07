package com.agi.blog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions; // Importe a classe Actions
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By searchIcon = By.cssSelector("a.astra-search-icon");
    private By searchInput = By.id("search-field");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void performSearch(String searchTerm) {
        // Espera até que o ícone de busca esteja presente e clicável
        WebElement iconElement = wait.until(ExpectedConditions.elementToBeClickable(searchIcon));

        Actions actions = new Actions(driver);
        actions.moveToElement(iconElement).click().perform();

        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(searchInput));

        // Digita e submete a busca
        searchField.sendKeys(searchTerm);
        searchField.submit();
    }
}