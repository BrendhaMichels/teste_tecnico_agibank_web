package com.agi.blog.tests;

import com.agi.blog.base.BaseTest;
import com.agi.blog.pages.HomePage;
import com.agi.blog.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(description = "Cenário 1: Realizar uma busca por um termo existente e validar os resultados.")
    public void testSearchForExistingTerm() {
        HomePage homePage = new HomePage(driver);
        String searchTerm = "investimentos";

        homePage.performSearch(searchTerm);

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        String expectedTitleText = "Resultados encontrados para: " + searchTerm;
        String actualTitle = searchResultsPage.getResultsTitle();
        Assert.assertEquals(actualTitle.toLowerCase(), expectedTitleText.toLowerCase(),
                "O título da página de resultados não corresponde ao esperado.");

        Assert.assertTrue(searchResultsPage.getResultsCount() > 0,
                "A busca não retornou nenhum artigo como resultado.");
    }

    @Test(description = "Cenário 2: Realizar uma busca por um termo que não retorna resultados.")
    public void testSearchForNonExistingTerm() {
        HomePage homePage = new HomePage(driver);
        String searchTerm = "TermoInexistente12345";

        homePage.performSearch(searchTerm);

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        String expectedMessage = "Lamentamos, mas nada foi encontrado para sua pesquisa, tente novamente com outras palavras.";
        String actualMessage = searchResultsPage.getNoResultsMessageText();

        Assert.assertEquals(actualMessage, expectedMessage, "A mensagem de 'Nenhum resultado' não corresponde à esperada.");
    }
}