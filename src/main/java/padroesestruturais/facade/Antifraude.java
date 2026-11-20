package padroesestruturais.facade;

public class Antifraude extends Departamento {
    private static final Antifraude antifraude = new Antifraude();

    private Antifraude() {
    }

    public static Antifraude getInstancia() {
        return antifraude;
    }
}