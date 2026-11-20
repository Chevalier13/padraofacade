package padroesestruturais.facade;

public class Pagamento extends Departamento {
    private static final Pagamento pagamento = new Pagamento();

    private Pagamento() {
    }

    public static Pagamento getInstancia() {
        return pagamento;
    }
}