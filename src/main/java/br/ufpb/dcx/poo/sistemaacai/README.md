# Sistema para Gerenciar Açai

Isso é um mini sistema desenvolvido em Java para o gerenciamento de uma Loja de Açai, que implementa varias funçoes de adicionar pedido, remover pedido, listar pedidos, salvar pedidos e recuperar os mesmos.

## 🚀 Funcionalidades
- **Cadastrar Pedido**: Adiciona um novo pedido com varias informaçoes basicas.
- **Pesquisar Pedido**: Retorna todos os pedidos, tanto em geral, ou com nome do Cliente.
- **Remover Pedido**: Exclui um pedido do sistema pelo nome (lança exceção caso não exista).
- **Persistência de Dados**: Salva e recupera o estado da agenda em um arquivo binário (`dados.dat`).

## 🛠️ Estrutura do Projeto (Pasta `sistemaacai`)
- `AcaiGravador`: Classe responsável pela serialização e desserialização dos dados.
- `AcaiInterface`: Interface que define as operações do sistema.
- `AcaiProdutos`: Classe que representa a entidade do sistema (deve ser `Serializable`).
- `NaoEncontradoProdutoException`: Exceção personalizada para tratamento de erros.
- `ProgramaAcai`: A parte principal do sistema, onde tudo sempre vai ser executado para o cliente.
- `SemProdutosException`: Exceção personalizada para tratamento de erros.
- `SistemaAcai`: Onde esta toda a base do sistema, pra adicionar, remover, pegar dados e remover dados.