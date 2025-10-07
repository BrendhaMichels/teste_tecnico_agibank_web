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
        Assert.assertEquals(actualTitle.toLowerCase(), expectedTitleText.toLowerCase());
        Assert.assertTrue(searchResultsPage.getResultsCount() > 0);
    }

    @Test(description = "Cenário 2: Realizar uma busca por um termo que não retorna resultados.")
    public void testSearchForNonExistingTerm() {
        HomePage homePage = new HomePage(driver);
        String searchTerm = "TermoInexistente12345";
        homePage.performSearch(searchTerm);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        String expectedMessage = "Lamentamos, mas nada foi encontrado para sua pesquisa, tente novamente com outras palavras.";
        String actualMessage = searchResultsPage.getNoResultsMessageText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(description = "Cenário 3: Validar que a busca é insensível a maiúsculas/minúsculas.")
    public void testSearchIsCaseInsensitive() {
        HomePage homePage = new HomePage(driver);
        String searchTerm = "Investimentos"; // Usando letra maiúscula
        homePage.performSearch(searchTerm);

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        Assert.assertTrue(searchResultsPage.getResultsCount() > 0,
                "A busca com letra maiúscula não retornou resultados.");
        Assert.assertTrue(searchResultsPage.getResultsTitle().toLowerCase().contains(searchTerm.toLowerCase()),
                "O título da página não corresponde à busca com letra maiúscula.");
    }

    @Test(description = "Cenário 4: Validar a paginação dos resultados da busca.")
    public void testSearchPagination() {
        HomePage homePage = new HomePage(driver);
        String searchTerm = "investimentos";
        homePage.performSearch(searchTerm);

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        // Clica para ir para a próxima página
        searchResultsPage.goToNextPage();

        // Verifica se a URL agora contém a indicação da página 2
        Assert.assertTrue(searchResultsPage.getCurrentUrl().contains("page/2/"),
                "A URL não foi atualizada para a página 2 após clicar em 'próxima'.");
    }
}