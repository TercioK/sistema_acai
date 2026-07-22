package br.ufpb.dcx.poo.sistemaacai;

import javax.swing.*;
import java.awt.*;

public class AcaiUserMenu extends JFrame{
    JLabel linha1, linha2;
    ImageIcon addImg = new ImageIcon("./assets/imgs/icons/add_person.png");
    ImageIcon pesqImg = new ImageIcon("./assets/imgs/icons/search_person.png");
    ImageIcon removeImg = new ImageIcon("./assets/imgs/icons/remove_person.png");
    ImageIcon addFile = new ImageIcon("/assets/imgs/icons/add_file.png");
    ImageIcon recoveryFile = new ImageIcon("/assets/imgs/icons/remove_file.png");
    String getFuncionario = "";

    JButton botaoCadastrar, botaoRemover, botaoPesquisarTodos, botaoPesquisarPorNome, botaoSalvarArquivos, botaoRecuperarArquivos, botaoTrocarFuncionario;
    public AcaiUserMenu() {
        if (getFuncionario == "") {
            getFuncionario = JOptionPane.showInputDialog(this, "Digite o nome do Funcionario:");
        }

        SistemaAcai sistema = new SistemaAcai();
        setTitle("Sistema Loja de Açai");
        setSize(500, 500);
        setLocation(150, 150);
        setResizable(false);
        getContentPane().setBackground(Color.pink);

        // BTNS
        botaoCadastrar = new JButton("Cadastrar", addImg);
        //botaoCadastrar.addActionListener();
        botaoRemover = new JButton("Remover", removeImg);
        botaoPesquisarTodos = new JButton("Pesquisar Todos", pesqImg);
        botaoPesquisarPorNome = new JButton("Pesquisar pelo Nome", pesqImg);
        botaoSalvarArquivos = new JButton("Salvar em Arquivo", addFile);
        botaoRecuperarArquivos = new JButton("Recuperar Arquivo", recoveryFile);
        botaoTrocarFuncionario = new JButton("Trocar Funcionario", recoveryFile);
        // Adicionar as coisas
        getContentPane().setLayout(new GridLayout(3, 2));
        getContentPane().add(botaoCadastrar);
        getContentPane().add(botaoRemover);
        getContentPane().add(botaoPesquisarTodos);
        getContentPane().add(botaoPesquisarPorNome);
        getContentPane().add(botaoSalvarArquivos);
        getContentPane().add(botaoRecuperarArquivos);
        getContentPane().add(botaoTrocarFuncionario);

        botaoCadastrar.addActionListener(e -> {
            try {
                String getNome = JOptionPane.showInputDialog(this, "Nome do Cliente:");
                String getID = JOptionPane.showInputDialog(this, "ID do Cliente:");
                String getCategoria = JOptionPane.showInputDialog(this, "Categoria:");
                String getProduto = JOptionPane.showInputDialog(this, "Produto:");
                double getPreco = Double.parseDouble(JOptionPane.showInputDialog(this, "Preço do Produto:"));
                int getQuant = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantidade:"));

                sistema.cadastrarNovoPedido(getNome, getID, getFuncionario, getCategoria, getProduto, getPreco, getQuant);
                JOptionPane.showMessageDialog(this, "Pedido cadastrado com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro nos dados informados. Tente novamente.");
            }
        });

        botaoRemover.addActionListener(e -> {
            try {
                String getNome = JOptionPane.showInputDialog(this, "Nome do Pedido:");

                sistema.removerProdutoPeloNome(getNome);
                JOptionPane.showMessageDialog(this, "Pedido foi removido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro nos dados informados. Tente novamente.");
            }
        });

        botaoPesquisarTodos.addActionListener(e -> {
            try {
                sistema.listarTodosProdutoLista();
                JOptionPane.showMessageDialog(this, "Pedidos foram listados no terminal do programa!!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Parece que a lista esta vazia. Tente cadastrar produtos! :(");
            }
        });

        botaoPesquisarPorNome.addActionListener(e -> {
            String getNomeProduto = JOptionPane.showInputDialog(this, "Nome do Pedido:");
            try {
                sistema.pegarTodosProdutosCom(getNomeProduto);
                JOptionPane.showMessageDialog(this, "Pedidos foram listados no terminal do programa!!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Parece que a lista esta vazia. Tente cadastrar produtos! :(");
            }
        });

        botaoSalvarArquivos.addActionListener(e -> {
            try {
                sistema.salvarDados();
                JOptionPane.showMessageDialog(this, "Os dados dos produtos foram salvos com sucesso!!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        botaoRecuperarArquivos.addActionListener(e -> {
            try {
                sistema.recuperarDados();
                JOptionPane.showMessageDialog(this, "Os dados dos produtos foram recuperados com sucesso!!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }
}
