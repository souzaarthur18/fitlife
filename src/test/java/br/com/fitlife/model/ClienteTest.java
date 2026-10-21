package br.com.fitlife.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void deveCadastrarClienteValido() {
        Cliente cliente = new Cliente("João Silva", "joao@email.com", 25);
        assertEquals("João Silva", cliente.getNome());
        assertEquals("joao@email.com", cliente.getEmail());
        assertEquals(25, cliente.getIdade());
    }

    @Test
    public void naoDeveCadastrarClienteMenorDeIdade() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente("João", "joao@email.com", 14));
    }

    @Test
    public void naoDeveCadastrarClienteComNomeVazio() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente("  ", "joao@email.com", 20));
    }

    @Test
    public void naoDeveCadastrarClienteComNomeNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente(null, "joao@email.com", 20));
    }

    @Test
    public void naoDeveCadastrarEmailInvalido() {
        Throwable erro = assertThrows(IllegalArgumentException.class,
                () -> new Cliente("João Silva", "email-invalido", 20));
        assertEquals("E-mail inválido!", erro.getMessage());
    }

    @Test
    public void deveAceitarIdadeMinima() {
        assertDoesNotThrow(() -> new Cliente("João", "joao@email.com", 15));
    }

    @Test
    public void deveAssociarPlanoAoCliente() {
        Cliente cliente = new Cliente("João", "joao@email.com", 20);
        cliente.associarPlano(new PlanoPremium());
        assertEquals("Premium", cliente.getPlano().getNome());
        assertEquals(250.0, cliente.calcularMensalidade());
    }

    @Test
    public void naoDeveAssociarPlanoNulo() {
        Cliente cliente = new Cliente("João", "joao@email.com", 20);
        assertThrows(IllegalArgumentException.class, () -> cliente.associarPlano(null));
    }

    @Test
    public void naoDeveCalcularMensalidadeSemPlano() {
        Cliente cliente = new Cliente("João", "joao@email.com", 20);
        assertThrows(IllegalStateException.class, cliente::calcularMensalidade);
    }

    @Test
    public void deveAdicionarTreinoAoCliente() {
        Cliente cliente = new Cliente("João", "joao@email.com", 20);
        cliente.adicionarTreino(new Treino("Treino A", 4, 12));
        assertEquals(1, cliente.getTreinos().size());
    }

    @Test
    public void setterDeveValidarDados() {
        Cliente cliente = new Cliente("João", "joao@email.com", 20);
        assertThrows(IllegalArgumentException.class, () -> cliente.setIdade(10));
        assertEquals(20, cliente.getIdade());
    }
}
