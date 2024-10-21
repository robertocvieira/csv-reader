# Projeto de Processamento de Arquivos CSV

Este projeto permite ler um arquivo CSV, identificar padrões em suas linhas, e realizar operações como excluir ou exportar linhas com padrões selecionados. Ele usa a biblioteca OpenCSV para ler e escrever arquivos CSV e permite ao usuário escolher qual padrão deseja remover ou exportar.

## Funcionalidades

- **Leitura de Arquivo CSV**: O projeto lê um arquivo CSV fornecido pelo usuário e extrai dados para análise.
- **Identificação de Padrões**: As linhas do arquivo são analisadas para identificar padrões baseados em tipos de caracteres (números, letras maiúsculas/minúsculas, caracteres especiais, etc.).
- **Exclusão de Padrão**: Permite ao usuário remover todas as linhas que correspondem a um padrão selecionado.
- **Exportação de Padrão**: Permite ao usuário exportar todas as linhas que correspondem a um padrão específico para um novo arquivo CSV.

## Como Rodar
1. **Coloque o arquivo CSV desejado na pasta "putTheFileHere"**:
    - Antes de iniciar, adicione o arquivo CSV que você deseja processar na pasta `src/Main/java/putTheFileHere`.

2. **Altere o nome do arquivo na linha 23**:
    - Vá até o arquivo `Main.java` e substitua `"okajimaBadExample.csv"` pelo nome do arquivo CSV que você colocou na pasta `putTheFileHere`.

3. **Execute o programa**: 

    - Compile e execute o programa conforme as instruções. O sistema irá exibir um menu com opções para manipular o arquivo CSV:
        - **Opção 1**: Excluir todas as linhas que possuem o padrão selecionado e gerar um novo arquivo CSV sem essas linhas.
        - **Opção 2**: Exportar todas as linhas que possuem o padrão selecionado para um novo arquivo CSV.
        - **Opção 3**: Sair do programa.

4. **Saída do programa**:
    - Um novo arquivo CSV será gerado e salvo na pasta `outputs` com o nome correspondente à operação realizada (`exclude_operation_file.csv` ou `export_operation_file.csv`).
