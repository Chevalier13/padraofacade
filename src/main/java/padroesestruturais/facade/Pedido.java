package padroesestruturais.facade;

public class Pedido {
    private final String codigo;

    public Pedido(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("O código do pedido é obrigatório.");
        }
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean liberar() {
        return PedidoFacade.verificarLiberacao(this);
    }
}