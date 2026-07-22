package br.ufpb.dcx.poo.sistemaacai;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SistemaAcai implements AcaiInterface {
    private Map<String, AcaiProdutos> mapaProdutos;
    private AcaiGravador gravador;

    public SistemaAcai() {
        this.mapaProdutos = new HashMap<>();
        this.gravador = new AcaiGravador();
    }

    public void cadastrarNovoPedido(String nomeCliente, String idCliente, String funcionario, String categoria, String produto, double preco, int quantidade) {
        AcaiProdutos cadastrarNovo = new AcaiProdutos(nomeCliente, idCliente, funcionario, categoria, produto, preco, quantidade);

        this.mapaProdutos.put(idCliente, cadastrarNovo);
        System.out.println("Novo pedido foi cadastrado com sucesso! ID: " + idCliente + "Nome do Cliente: " + nomeCliente + "Pedido feito: " + produto);
    }

    public void removerProdutoPeloNome(String nomeDoPedido) throws NaoEncontradoProdutoException {
        if (mapaProdutos.isEmpty()) {
            throw new SemProdutosException("Me desculpe, mas a lista de Produto esta vazia no momento :(");
        }

        String encontrarId = null;

        for (AcaiProdutos r : this.mapaProdutos.values()) {
            if (r.getProdutoEscolhido().equalsIgnoreCase(nomeDoPedido)) {
                encontrarId = r.getIdDoCliente();
                break;
            }

            this.mapaProdutos.remove(encontrarId);
            System.out.println("Foi removido com sucesso o produto com nome: " + nomeDoPedido);
        }

        if (encontrarId == null ) {
            throw new NaoEncontradoProdutoException("Não foi encontrado o produto pra que seja removido! Nome do Produto: " + nomeDoPedido);
        }
    }

    public void listarTodosProdutoLista(){
        if (mapaProdutos.isEmpty()) {
            throw new SemProdutosException("Me desculpe, mas a lista de Produto esta vazia no momento :(");
        }
        
        for (AcaiProdutos p : this.mapaProdutos.values()) {
            System.out.println(p.toString());
        }
    }

    public AcaiProdutos pegarTodosProdutosCom(String nome) throws SemProdutosException {
        if (mapaProdutos.isEmpty()) {
            throw new SemProdutosException("Me desculpe, mas na tentativa de pegar produtos da lista, esta totalmente vazia!");
        }

        for (AcaiProdutos p : this.mapaProdutos.values()) {
            if (p.getProdutoEscolhido().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public void listarProdutosComNomeCliente(String nomeCliente) throws SemProdutosException {
        if (mapaProdutos.isEmpty()) {
            throw new SemProdutosException("Me desculpe, mas nao ha nenhum produto na lista. Tente cadastrar e tente mais tarde!");
        }

        boolean encontrouCliente = false;

        for (AcaiProdutos a : this.mapaProdutos.values()) {
            if (a.getNomeDoCliente().equalsIgnoreCase(nomeCliente)) {
                System.out.println(a.toString());
                encontrouCliente = true;
            }

            if (!encontrouCliente) {
                System.out.println("Nenhum cliente foi encontrado com o nome de " + nomeCliente + ". Por favor, verifique se escreveu certo ou se contem mesmo o Cliente na Lista!");
            }
        }
    }

    public boolean limparTodosPedidosDoCliente(String idCliente) throws SemProdutosException {
        if (this.mapaProdutos.isEmpty()) {
            throw new SemProdutosException("Me desculpe, mas esta vazia a lista de Pedidos!");
        }

        return this.mapaProdutos.values().removeIf(p -> p.getIdDoCliente().equalsIgnoreCase(idCliente));
    }

    public void salvarDados() throws IOException {
        this.gravador.salvarProdutos(this.mapaProdutos);
        System.out.println("Todas as informações foram salvas com sucesso! :)");
    }

    public void recuperarDados() throws IOException {
        this.mapaProdutos = this.gravador.recuperarProdutos();
        System.out.println("Todas os dados foram recuperados com sucesso!");
    }
}
