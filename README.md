# Criando um Banco Digital com Java e Orientação a Objeto

## 02/08/2021 

Desafio: Considerando nosso conhecimento no domínio bancário, iremos abstrair uma solução Orientada a Objetos em Java. Para isso, vamos interpretar o seguinte cenário:
“Um banco oferece aos seus clientes dois tipos de contas (corrente e poupança), as quais possuem as funcionalidades de depósito, saque e transferência (entre contas da própria instituição).”

Foi feita:
- Implementação de validações para impedir saques que deixem saldo negativo e depósitos com valores inválidos.  
- Transferências agora verificam saldo antes de serem realizadas.  
- Adicionado um **histórico de transações** para registrar depósitos, saques e transferências.  
- Criado o método `imprimirExtrato()` para exibir todas as transações realizadas em uma conta.  
- Na classe `Banco`, foi adicionado um construtor para definir o nome do banco e inicializar a lista de contas.  
- Criados métodos para adicionar contas, listar todas as contas e buscar uma conta específica pelo número.  