package br.com.fitlife.model;

import br.com.fitlife.exception.TreinoInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreinoTest {

    @Test
    public void deveAdicionarExercicio() {
        Treino treino = new Treino("Treino A", 4, 12);
        treino.adicionarExercicio(new Exercicio("Supino", "Peito"));
        assertEquals(1, treino.getExercicios().size());
    }

    @Test
    public void deveRemoverExercicio() {
        Treino treino = new Treino("Treino A", 4, 12);
        Exercicio supino = new Exercicio("Supino", "Peito");
        treino.adicionarExercicio(supino);
        assertTrue(treino.removerExercicio(supino));
        assertTrue(treino.getExercicios().isEmpty());
    }

    @Test
    public void naoDeveCriarTreinoSemNome() {
        assertThrows(TreinoInvalidoException.class, () -> new Treino("", 4, 12));
    }

    @Test
    public void naoDeveCriarTreinoComSeriesInvalidas() {
        assertThrows(TreinoInvalidoException.class, () -> new Treino("Treino A", 0, 12));
    }

    @Test
    public void naoDeveAdicionarExercicioNulo() {
        Treino treino = new Treino("Treino A", 4, 12);
        assertThrows(TreinoInvalidoException.class, () -> treino.adicionarExercicio(null));
    }

    @Test
    public void listaDeExerciciosNaoDeveSerModificavelExternamente() {
        Treino treino = new Treino("Treino A", 4, 12);
        assertThrows(UnsupportedOperationException.class,
                () -> treino.getExercicios().add(new Exercicio("Supino", "Peito")));
    }
}
