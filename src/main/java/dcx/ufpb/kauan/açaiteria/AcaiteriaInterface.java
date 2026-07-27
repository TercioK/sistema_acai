package dcx.ufpb.kauan.açaiteria;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AcaiteriaInterface {
    /**
     * Cadastra um novo pedido na Açaiteria.
     * @param nomeCliente Nome do cliente responsável pelo pedido.
     * @param itens Lista de produtos adicionados ao pedido.
     * @return O objeto Pedido criado e armazenado.
     * @throws IllegalArgumentException Caso o nome ou a lista de itens sejam invalidos, esse Exception vai trabalhar com o erro.
     */
    Pedido cadastrarPedido(String nomeCliente, List<Produto> itens) throws IllegalArgumentException;
    /**
     * Remove um pedido do sistema através do ID.
     * @param idPedido Código do pedido a ser removido.
     * @return true se o pedido foi localizado e removido, false caso contrário.
     */
    boolean removerPedido(String idPedido);
    /**
     * Pesquisa pedidos por parte do nome do cliente.
     * @param nome Nome do cliente para pesquisa.
     * @return Lista de pedidos correspondentes a busca.
     */
    List<Pedido> pesquisarPorNome(String nome);
    /**
     * Pesquisa pedidos realizados em uma data específica.
     * @param data Data exata da realização dos pedidos.
     * @return Lista de pedidos correspondente a data informada.
     */
    List<Pedido> pesquisarPorData(LocalDate data);
    /**
     * Pesquisa pedidos filtrando pelo seu status (ex: PENDENTE, FINALIZADO).
     * @param status Situação do pedido.
     * @return Lista de pedidos com o status correspondente.
     */
    List<Pedido> pesquisarPorStatus(String status);
    /**
     * Altera o status de um pedido pendente para "FINALIZADO".
     * @param idPedido Código do pedido a ser finalizado.
     * @return true se a finalização foi realizada com sucesso, false caso contrário.
     */
    boolean finalizarPedido(String idPedido);
    /**
     * Retorna o mapa contendo todos os pedidos no sistema.
     * @return Map onde a chave é o ID do pedido e o valor é o objeto Pedido.
     */
    Map<String, Pedido> getPedidos();;
    /**
     * Atualiza o mapa de pedidos do sistema.
     * @param pedidos Novo mapa de pedidos a ser associados.
     */
    void setPedidos(Map<String, Pedido> pedidos);
    /**
     * Adiciona um objeto Pedido existente diretamente ao mapa de pedidos.
     * @param novoPedido Objeto do tipo Pedido a ser adicionado.
     */
    void adicionarPedido (Pedido novoPedido);
    /**
     * Retorna a quantidade total de pedidos atualmente cadastrados.
     * @return Valor em numero (double) com o total de pedidos registrados.
     */
    double quantidadeTotalPedidos();
    /**
     * Verifica a quantidade de pedidos feitos no sistema e verifica tamanho da lista.
     * @return Lista de pedidos ()Size.
     */
}
