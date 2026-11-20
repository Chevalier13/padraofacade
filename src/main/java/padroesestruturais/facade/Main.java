package padroesestruturais.facade;

public class Main {
    public static void main(String[] args) {
        Pedido pedido1 = new Pedido("PED-1001");
        Pedido pedido2 = new Pedido("PED-1002");
        Pedido pedido3 = new Pedido("PED-1003");
        Pedido pedido4 = new Pedido("PED-1004");

        Estoque.getInstancia().addPedidoPendente(pedido2);
        Pagamento.getInstancia().addPedidoPendente(pedido3);
        Antifraude.getInstancia().addPedidoPendente(pedido4);

        exibirStatus(pedido1);
        exibirStatus(pedido2);
        exibirStatus(pedido3);
        exibirStatus(pedido4);

        Antifraude.getInstancia().removerPedidoPendente(pedido4);
        System.out.println("\nApós liberação do Antifraude:");
        exibirStatus(pedido4);
    }

    private static void exibirStatus(Pedido pedido) {
        String status = pedido.liberar() ? "LIBERADO PARA ENVIO" : "BLOQUEADO POR PENDÊNCIA";
        System.out.println("Pedido " + pedido.getCodigo() + ": " + status);
    }
}