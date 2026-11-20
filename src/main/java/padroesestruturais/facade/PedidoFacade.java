package padroesestruturais.facade;

public class PedidoFacade {
    public static boolean verificarLiberacao(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo.");
        }
        if (Estoque.getInstancia().verificarPedidoComPendencia(pedido)) {
            return false;
        }
        if (Pagamento.getInstancia().verificarPedidoComPendencia(pedido)) {
            return false;
        }
        if (Antifraude.getInstancia().verificarPedidoComPendencia(pedido)) {
            return false;
        }
        return true;
    }
}