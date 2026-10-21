package br.com.fitlife.model;

import java.time.LocalDate;

/**
 * Registro de um pagamento realizado.
 */
public class Pagamento {

    private final Cliente cliente;
    private final double valor;
    private final LocalDate data;
    private final String forma;

    public Pagamento(Cliente cliente, double valor, String forma) {
        this.cliente = cliente;
        this.valor = valor;
        this.forma = forma;
        this.data = LocalDate.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public String getForma() {
        return forma;
    }

    public void exibirComprovante() {
        System.out.println("----- COMPROVANTE -----");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.printf("Valor: R$ %.2f%n", valor);
        System.out.println("Data: " + data);
        System.out.println("Forma: " + forma);
        System.out.println("-----------------------");
    }
}
