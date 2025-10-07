# Projeto de Automação de Testes Web - Blog do Agi

### Este projeto contém testes automatizados para a funcionalidade de busca do [Blog do Agibank](https://blogdoagi.com.br/)

## Tecnologias Utilizadas
* **Linguagem**: Java
* **Automação de Navegador**: Selenium WebDriver
* **Framework de Teste**: TestNG
* **Gerenciador de Dependências**: Maven
* **Gerenciador de Drivers**: WebDriverManager
* **Relatórios:** ExtentReports

## Pré-requisitos
Para executar este projeto, você precisa ter instalado:
* JDK 11 ou superior
* Apache Maven

## Como Configurar o Projeto
1.  Clone este repositório:
    ```bash
    git clone https://github.com/BrendhaMichels/teste_tecnico_agibank_web.git
    ```
2.  Navegue até a pasta do projeto:
    ```bash
    cd teste_tecnico_agibank
    ```
3.  O Maven irá baixar todas as dependências automaticamente.

## Como Executar os Testes
Você pode executar os testes através da linha de comando com o Maven:
```bash
   mvn test
```
Os testes serão executados no navegador Google Chrome por padrão.

## Cenários de Teste Automatizados 
1.  **Busca por termo existente**: Verifica se ao pesquisar um termo válido, a página de resultados é carregada corretamente.
2.  **Busca por termo inexistente**: Verifica se ao pesquisar por um termo que não possui resultados, uma mensagem apropriada é exibida.
3.  **Busca case-insensitive**: Garante que a busca não diferencia letras maiúsculas de minúsculas, validando que uma pesquisa por "Investimentos" também retorna resultados.
4.  **Paginação dos resultados**: Valida se, para buscas com múltiplos resultados, a funcionalidade de navegar para a "próxima página" funciona e atualiza a URL corretamente.