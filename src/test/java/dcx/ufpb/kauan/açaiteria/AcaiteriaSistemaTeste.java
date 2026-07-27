package dcx.ufpb.kauan.açaiteria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AcaiteriaSistemaTeste {
    private PedidoService sistema;
    private List<Produto> pedidos;

    @BeforeEach
    public void iniciarSistema() {
        sistema = new PedidoService();
        pedidos = new ArrayList<>();
        pedidos.add(new Produto("001", "Copo 300ml Tradicional", 10.00));
        pedidos.add(new Produto("002", "Tigela 700ml", 19.00));
    }

    @Test
    public void testeCadastrarCliente() {
        Pedido pedido = sistema.cadastrarPedido("Gabriel", pedidos);
        assertEquals("Gabriel", pedido.getNomeCliente());
        assertEquals("PENDENTE", pedido.getStatus());
    }

    @Test
    public void testeFinalizarPedido() {
        Pedido pedidoC1 = sistema.cadastrarPedido("Pedro", pedidos);
        boolean pedidoC1Finalizou = sistema.finalizarPedido(pedidoC1.getIdPedido());
        assertTrue(pedidoC1Finalizou, "O pedido do cliente chamado Pedro foi finalizado com sucesso e retornou TRUE");
        assertEquals("FINALIZADO", pedidoC1.getStatus());
    }

    @Test
    public void testeFluxoSistema() {
        sistema.cadastrarPedido("Matheus", pedidos);
        sistema.cadastrarPedido("Kauan", pedidos);
        assertEquals(2.0, sistema.quantidadeTotalPedidos());
    }

    @Test
    public void testeCadastrarProduto() {
        Produto p1 = new Produto("002", "Copo 500ml Campeao", 14.00);
        assertEquals(14.00, p1.getPreco());
    }

    @Test
    public void testePesquisarPeloNome() {
        sistema.cadastrarPedido("Natan", pedidos);
        List<Pedido> resultado = sistema.pesquisarPorNome("Natan");
        assertEquals("Natan", resultado.get(0).getNomeCliente());
    }
}
