package br.com.fitlife.model;

/**
 * Plano mensal: paga apenas o valor base.
 */
public class PlanoMensal extends Plano {

    public PlanoMensal() {
        super("Mensal", 100.0);
    }

    @Override
    public double calcularMensalidade() {
        return valorBase;
    }
}
