package br.com.fitlife.model;

/**
 * Plano premium: valor base acrescido de adicional de benefícios.
 */
public class PlanoPremium extends Plano {

    private static final double ADICIONAL_PREMIUM = 50.0;

    public PlanoPremium() {
        super("Premium", 200.0);
    }

    @Override
    public double calcularMensalidade() {
        return valorBase + ADICIONAL_PREMIUM;
    }
}
