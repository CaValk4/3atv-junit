# Quais desafios você encontrou ao testar os métodos?
 > Acredito que um dos grandes desafios é tratar a validação de excessões sem deixar nenhuma situação especifica para trás, pois só assim o sistema será testado de forma correta.
 > os métodos que manipulam as listas  como a de filtrar produtos em estoque também deve ter uma certa atenção pois exige que os produtos sejam filtrados corretamente, é de fato um controle mais severo.

 #  Houve alguma funcionalidade que precisou ser ajustada após criar os testes? Por quê?

 
> Ao escrever os testes, percebi que o código original não tratava corretamente algumas entradas inválidas, como descontos negativos, o que poderia causar erros no sistema. Também ficou claro que o código precisava lançar exceções em situações como lista nula, o que foi ajustado para garantir mais robustez. Além disso, o método de ordenação de preços precisava verificar se o argumento não era nulo para evitar erros em tempo de execução.

# Como os testes ajudam a garantir a qualidade do software em cenários reais?

> Os testes garantem a qualidade do software ao identificar erros antes do uso real. Eles simulam cenários do dia a dia, garantindo que o sistema funcione corretamente e evitando surpresas. Isso também ajuda a melhorar a performance e a prevenir novos erros com mudanças no código.