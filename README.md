# Projeto de Automação de Testes Web - Blog do Agi

### Este projeto contém testes automatizados para a funcionalidade de busca do [Blog do Agibank](https://blogdoagi.com.br/)

## Tecnologias Utilizadas
* **Linguagem**: Java
* **Automação de Navegador**: Selenium WebDriver
* **Framework de Teste**: TestNG
* **Gerenciador de Dependências**: Maven
* **Gerenciador de Drivers**: WebDriverManager

## Pré-requisitos
Para executar este projeto, você precisa ter instalado:
* JDK 11 ou superior
* Apache Maven

## Como Configurar o Projeto
1.  Clone este repositório:
    ```bash
    git clone <URL_DO_SEU_REPOSITORIO>
    ```
2.  Navegue até a pasta do projeto:
    ```bash
    cd <NOME_DA_PASTA>
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