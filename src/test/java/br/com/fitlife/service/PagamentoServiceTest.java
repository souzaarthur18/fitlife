package br.com.fitlife.service;

import br.com.fitlife.model.Cliente;
import br.com.fitlife.model.Pagamento;
import br.com.fitlife.model.PlanoMensal;
import br.com.fitlife.model.PlanoPremium;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PagamentoServiceTest {

    private final PagamentoService service = new PagamentoService();

    @Test
    public void deveProcessarPagamentoDoPlanoMensal() {
        Cliente cliente = new Cliente("João", "joao@email.com", 20, new PlanoMensal());
        Pagamento pagamento = service.processarPagamento(cliente);
        assertEquals(100.0, pagamento.getValor());
        assertEquals(cliente, pagamento.getCliente());
    }

    @Test
    public void deveProcessarPagamentoDoPlanoPremium() {
        Cliente cliente = new Cliente("Maria", "maria@email.com", 30, new PlanoPremium());
        Pagamento pagamento = service.processarPagamento(cliente, "Pix");
        assertEquals(250.0, pagamento.getValor());
        assertEquals("Pix", pagamento.getForma());
    }

    @Test
    public void naoDeveProcessarPagamentoDeClienteNulo() {
        Throwable erro = assertThrows(IllegalArgumentException.class,
                () -> service.processarPagamento(null));
        assertEquals("Cliente inválido!", erro.getMessage());
    }

    @Test
    public void naoDeveProcessarPagamentoSemPlano() {
        Cliente cliente = new Cliente("João", "joao@email.com", 20);
        assertThrows(IllegalStateException.class, () -> service.processarPagamento(cliente));
    }

    @Test
    public void naoDeveProcessarPagamentoSemFormaDePagamento() {
        Cliente cliente = new Cliente("João", "joao@email.com", 20, new PlanoMensal());
        assertThrows(IllegalArgumentException.class,
                () -> service.processarPagamento(cliente, " "));
    }
}
