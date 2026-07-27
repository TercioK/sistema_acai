# 🍧 Açaí Mania - Sistema de Gerenciamento de Açaiteria

O **Açaí Mania** é uma aplicação Java para gerenciamento de vendas e atendimento de açaiterias. O sistema conta com interface gráfica em Java Swing, suporte a consultas rápidas via Java Streams, persistência de dados em arquivos binários e arquitetura baseada no padrão **Fachada (Façade)**.

---

## 🛠️ Recursos e Funcionalidades

### 1. 🛒 | Gestão de Pedidos
- **Cadastro de Pedidos:** Registro de novos pedidos associando o nome do cliente aos produtos selecionados, com cálculo automático do valor total e status inicial `PENDENTE`.
- **Finalização e Cobrança:** Alteração do status do pedido para `FINALIZADO` após a confirmação do pagamento.
- **Cancelamento/Remoção:** Exclusão de pedidos da fila através do ID identificador.

### 2. 📋 | Gerenciamento do Cardápio
- **Adição e Remoção de Itens:** Inclusão e exclusão de copos, barcas, frutas e adicionais no cardápio do sistema com código, nome e preço.
- **Cardápio Online (Interface do Cliente):** Visualização interativa e categorizada das opções do cardápio em abas (`Copos & Tigelas`, `Barcas Especiais` e `Adicionais & Frutas`).

### 3. 🔍 | Buscas e Consultas Avançadas (Java Streams)
- **Pesquisa por Nome:** Filtro de pedidos por nome ou trecho do nome do cliente (case-insensitive).
- **Pesquisa por Data:** Filtro de pedidos realizados em uma data específica (`dd/MM/yyyy`).
- **Pesquisa por Status:** Listagem de pedidos filtrando por `PENDENTE` ou `FINALIZADO`.

### 4. 💾 | Persistência e Recuperação de Dados
- **Serialização de Objetos:** Salva e carrega o estado completo do cardápio e dos pedidos em arquivo binário (`acaimania_dados.dat`) com auxílio do `ArquivoService`.

---

## 🏗️ Estrutura do Projeto

```text
dcx.ufpb.kauan.açaiteria
├── AcaiteriaInterface.java   # Interface Fachada que define o contrato do sistema
├── PedidoService.java        # Implementação da lógica de negócios e gerenciamento dos pedidos (Map / Streams)
├── CardapioService.java      # Gerenciamento de itens e produtos do cardápio
├── ArquivoService.java       # Serviço de persistência e leitura em arquivo binário (.dat)
├── Pedido.java               # Classe de entidade que representa um pedido do cliente
├── Produto.java              # Classe de entidade para itens do cardápio
├── TelaAcaiMania.java        # Interface Gráfica principal de gerenciamento (Swing)
└── TelaClienteSite.java      # Interface Gráfica secundária de exibição do cardápio para clientes