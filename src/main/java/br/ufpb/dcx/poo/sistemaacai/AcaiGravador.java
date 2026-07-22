package br.ufpb.dcx.poo.sistemaacai;

import java.io.*;
import java.util.Map;

public class AcaiGravador {
    public static final String NOME_ARQUIVO_PRODUTOS = "produtos.dat";

    public void salvarProdutos(Map<String, AcaiProdutos> produtos) throws IOException {
        File arquivo = new File(NOME_ARQUIVO_PRODUTOS);

        ObjectOutputStream gravador = null;
        try {
            gravador = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO_PRODUTOS));
            gravador.writeObject(produtos);
        } finally {
            if (gravador!=null){
                gravador.close();
            }
        }
    }

    public Map<String, AcaiProdutos> recuperarProdutos() throws IOException {
        ObjectInputStream leitor = null;
        try {
            leitor = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO_PRODUTOS));
            Map<String, AcaiProdutos> produtosRecuperados = (Map<String, AcaiProdutos>) leitor.readObject();

            return produtosRecuperados;
        } catch(ClassNotFoundException e) {
            throw new IOException("Classe desconhecida: " + e.getMessage());
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }

    }
}