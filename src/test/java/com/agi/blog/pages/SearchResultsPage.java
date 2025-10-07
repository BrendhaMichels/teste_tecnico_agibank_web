package com.agi.blog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SearchResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By resultsTitle = By.className("page-title");
    private By resultArticles = By.tagName("article");
    private By noResultsParagraph = By.xpath("//p[contains(text(), 'Lamentamos, mas nada foi encontrado')]");


    private By nextPageLink = By.cssSelector(".nav-links .next");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getResultsTitle() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(resultsTitle));
        return titleElement.getText();
    }

    public int getResultsCount() {
        wait.until(ExpectedConditions.presenceOfElementLocated(resultArticles));
        List<WebElement> articles = driver.findElements(resultArticles);
        return articles.size();
    }

    public String getNoResultsMessageText() {
        WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(noResultsParagraph));
        return messageElement.getText();
    }

    public void goToNextPage() {
        WebElement nextLink = wait.until(ExpectedConditions.presenceOfElementLocated(nextPageLink));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", nextLink);
        js.executeScript("arguments[0].click();", nextLink);
    }

    public String getCurrentUrl() {
        wait.until(ExpectedConditions.urlContains("page/2/"));
        return driver.getCurrentUrl();
    }
}