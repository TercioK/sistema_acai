package dcx.ufpb.tercio.açaiteria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CardapioServiceTeste {
    private CardapioService sistemaCardapio;

    @BeforeEach
    public void iniciarSistema() {
        sistemaCardapio = new CardapioService();
        sistemaCardapio.adicionarItem("001", "Copo 300ml Tradicional", 10.00);
        sistemaCardapio.adicionarItem("002", "Copo 500ml Campeão", 14.00);
        sistemaCardapio.adicionarItem("003", "Tigela 700ml Família", 19.00);
    }

    @Test
    public void testeAdicionarItem() {
        sistemaCardapio.adicionarItem("002", "Copo 500ml Campeao", 14.00);

        Produto prod = sistemaCardapio.buscarItem("002");
        assertEquals("Copo 500ml Campeao", prod.getNome());
        assertEquals(14.00, prod.getPreco());
    }

    @Test
    public void testeRemoverItem() {
        sistemaCardapio.adicionarItem("003", "Tigela 700ml", 19.00);

        boolean removido = sistemaCardapio.removerItem("003");
        assertTrue(removido);
    }

    @Test
    public void testeBuscarItemExistente() {
        Produto produto = sistemaCardapio.buscarItem("001");

        assertEquals("001", produto.getCodigo());
        assertEquals("Copo 300ml Tradicional", produto.getNome());
        assertEquals(10.00, produto.getPreco());
    }

    @Test
    public void testeBuscarTodosItens() {
        assertEquals(3, sistemaCardapio.getCardapio().size(), "Deveria haver 3 itens cadastrados no cardápio!!");
        assertTrue(sistemaCardapio.getCardapio().containsKey("003"));
    }

    @Test
    public void testeNovoItem() {
        Map<String, Produto> novoCardapio = new HashMap<>();
        novoCardapio.put("004", new Produto("004", "Açaí Especial Trufado", 25.00));
        sistemaCardapio.setCardapio(novoCardapio);
        Produto prodNovo = sistemaCardapio.buscarItem("004");
        assertEquals("Açaí Especial Trufado", prodNovo.getNome());
    }
}
