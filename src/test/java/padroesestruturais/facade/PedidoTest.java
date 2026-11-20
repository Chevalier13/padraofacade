package padroesestruturais.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PedidoTest {

    @BeforeEach
    void limparDepartamentos() {
        Estoque.getInstancia().limparPendencias();
        Pagamento.getInstancia().limparPendencias();
        Antifraude.getInstancia().limparPendencias();
    }

    @Test
    void deveRetornarPendenciaEstoqueNaLiberacao() {
        Pedido pedido = new Pedido("PED-001");
        Estoque.getInstancia().addPedidoPendente(pedido);

        assertFalse(pedido.liberar());
    }

    @Test
    void deveRetornarPendenciaPagamentoNaLiberacao() {
        Pedido pedido = new Pedido("PED-002");
        Pagamento.getInstancia().addPedidoPendente(pedido);

        assertFalse(pedido.liberar());
    }

    @Test
    void deveRetornarPendenciaAntifraudeNaLiberacao() {
        Pedido pedido = new Pedido("PED-003");
        Antifraude.getInstancia().addPedidoPendente(pedido);

        assertFalse(pedido.liberar());
    }

    @Test
    void deveLiberarPedidoSemPendencias() {
        Pedido pedido = new Pedido("PED-004");

        assertTrue(pedido.liberar());
        assertEquals("PED-004", pedido.getCodigo());
    }

    @Test
    void deveLiberarPedidoAposRemoverPendencia() {
        Pedido pedido = new Pedido("PED-005");
        Antifraude.getInstancia().addPedidoPendente(pedido);

        assertFalse(pedido.liberar());
        assertTrue(Antifraude.getInstancia().removerPedidoPendente(pedido));
        assertTrue(pedido.liberar());
    }

    @Test
    void deveManterPedidoBloqueadoEnquantoExistirPendenciaEmOutroDepartamento() {
        Pedido pedido = new Pedido("PED-006");
        Estoque.getInstancia().addPedidoPendente(pedido);
        Pagamento.getInstancia().addPedidoPendente(pedido);

        Estoque.getInstancia().removerPedidoPendente(pedido);

        assertFalse(pedido.liberar());
    }

    @Test
    void deveLancarExcecaoParaCodigoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Pedido(null));
        assertThrows(IllegalArgumentException.class, () -> new Pedido("   "));
    }

    @Test
    void deveLancarExcecaoParaPedidoNuloNosDepartamentosOuFacade() {
        assertThrows(IllegalArgumentException.class, () -> Estoque.getInstancia().addPedidoPendente(null));
        assertThrows(IllegalArgumentException.class, () -> PedidoFacade.verificarLiberacao(null));
    }
}