package br.com.fitlife.model;

/**
 * Classe abstrata que generaliza os planos da academia.
 * Cada plano concreto define sua própria regra de mensalidade.
 */
public abstract class Plano implements Calculavel {

    protected String nome;
    protected double valorBase;

    public Plano(String nome, double valorBase) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do plano é obrigatório!");
        }
        if (valorBase <= 0) {
            throw new IllegalArgumentException("Valor base deve ser maior que zero!");
        }
        this.nome = nome;
        this.valorBase = valorBase;
    }

    public String getNome() {
        return nome;
    }

    public double getValorBase() {
        return valorBase;
    }

    @Override
    public abstract double calcularMensalidade();

    @Override
    public String toString() {
        return String.format("Plano %s (R$ %.2f)", nome, calcularMensalidade());
    }
}
