package padroesestruturais.facade;

import java.util.ArrayList;
import java.util.List;

public abstract class Departamento {
    private final List<Pedido> pedidosComPendencia = new ArrayList<>();

    public void addPedidoPendente(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo.");
        }
        if (!pedidosComPendencia.contains(pedido)) {
            pedidosComPendencia.add(pedido);
        }
    }

    public boolean removerPedidoPendente(Pedido pedido) {
        return pedidosComPendencia.remove(pedido);
    }

    public boolean verificarPedidoComPendencia(Pedido pedido) {
        return pedidosComPendencia.contains(pedido);
    }

    public void limparPendencias() {
        pedidosComPendencia.clear();
    }
}