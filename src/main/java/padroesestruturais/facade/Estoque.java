package padroesestruturais.facade;

public class Estoque extends Departamento {
    private static final Estoque estoque = new Estoque();

    private Estoque() {
    }

    public static Estoque getInstancia() {
        return estoque;
    }
}