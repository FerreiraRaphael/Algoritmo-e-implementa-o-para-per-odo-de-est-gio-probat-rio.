# Algoritmo período de estágio probatório.
Algoritmo e implementação para período de estágio probatório. () Responsável: Raphael de Brito. O estágio probabório é definido por um período de 36 meses a partir de determinada data. Contudo, a partir dessa data podem existir períodos de afastamento. Tais períodos de afastamento não contam para a consolidação dos 36 meses supracitados. O problema é definir qual a data de conclusão do estágio probatório, a partir de uma data de início, excluindo-se os períodos de afastamento. Entrada: (a) períodos de afastamento; (b) data de início; (c) quantidade de meses (total a ser efetivado após a data de início). Saída: data na qual a quantidade de meses a partir da data de entrada, excluindo-se os períodos de afastamento, é atingida. 

# Como usar

- 1 Baixe o .jar e inclua no seu projeto

  Download .jar (1.1): https://github.com/FerreiraRaphael/AlgoritmoEstagioProbatorio/releases/download/1.1/estagioProbatorio.jar

- 2 Classe EstagioProbatorio
  - `new EstagioProbatorio(EstagioProbatorio(List<Periodo> periodosAfastamento, LocalDate dataInicial))`
  - `periodos`: Uma lista da classe Periodo, com os períodos de afastamento.
  - `dataInicial`: Data inicial do estágio probatorio.
  - Metodos
    - `LocalDate getDataFinal` retorna a data final do estágio probatório, já calculando os períodos de afastamento

- 3 Classe Periodo
  - `new Periodo(LocalDate dataInicial, LocalDate dataFinal)`
