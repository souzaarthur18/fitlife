package br.com.fitlife.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlanoTest {

    @Test
    public void deveCalcularMensalidadeDoPlanoMensal() {
        Plano plano = new PlanoMensal();
        assertEquals(100.0, plano.calcularMensalidade());
    }

    @Test
    public void deveCalcularMensalidadeDoPlanoPremium() {
        Plano plano = new PlanoPremium();
        assertEquals(250.0, plano.calcularMensalidade());
    }

    @Test
    public void deveRetornarNomeDoPlano() {
        assertEquals("Mensal", new PlanoMensal().getNome());
        assertEquals("Premium", new PlanoPremium().getNome());
    }

    @Test
    public void devePermitirPolimorfismoComInterface() {
        List<Calculavel> planos = List.of(new PlanoMensal(), new PlanoPremium());
        double total = 0;
        for (Calculavel plano : planos) {
            total += plano.calcularMensalidade();
        }
        assertEquals(350.0, total);
    }
}
