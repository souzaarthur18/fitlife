package br.com.fitlife.service;

import br.com.fitlife.model.Cliente;
import br.com.fitlife.model.Pagamento;

/**
 * Regras de negócio do pagamento da mensalidade.
 */
public class PagamentoService {

    public Pagamento processarPagamento(Cliente cliente) {
        return processarPagamento(cliente, "Cartão");
    }

    public Pagamento processarPagamento(Cliente cliente, String forma) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente inválido!");
        }
        if (cliente.getPlano() == null) {
            throw new IllegalStateException("Cliente não possui plano associado!");
        }
        if (forma == null || forma.isBlank()) {
            throw new IllegalArgumentException("Forma de pagamento é obrigatória!");
        }

        double valor = cliente.getPlano().calcularMensalidade();

        System.out.println("Processando pagamento...");
        System.out.printf("Cliente: %s%n", cliente.getNome());
        System.out.printf("Valor: R$ %.2f%n", valor);
        System.out.println("Pagamento realizado com sucesso!");

        return new Pagamento(cliente, valor, forma);
    }
}
