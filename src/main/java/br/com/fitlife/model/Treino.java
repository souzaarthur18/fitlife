package br.com.fitlife.model;

import br.com.fitlife.exception.TreinoInvalidoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Treino de um cliente. Mantém uma lista de exercícios (agregação).
 */
public class Treino {

    private final String nome;
    private final int series;
    private final int repeticoes;
    private final List<Exercicio> exercicios = new ArrayList<>();

    public Treino(String nome, int series, int repeticoes) {
        if (nome == null || nome.isBlank()) {
            throw new TreinoInvalidoException("Nome do treino é obrigatório!");
        }
        if (series <= 0) {
            throw new TreinoInvalidoException("Séries deve ser maior que zero!");
        }
        if (repeticoes <= 0) {
            throw new TreinoInvalidoException("Repetições deve ser maior que zero!");
        }
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public void adicionarExercicio(Exercicio exercicio) {
        if (exercicio == null) {
            throw new TreinoInvalidoException("Exercício inválido!");
        }
        exercicios.add(exercicio);
    }

    public boolean removerExercicio(Exercicio exercicio) {
        return exercicios.remove(exercicio);
    }

    public String getNome() {
        return nome;
    }

    public int getSeries() {
        return series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public List<Exercicio> getExercicios() {
        return Collections.unmodifiableList(exercicios);
    }

    public void exibirTreino() {
        System.out.printf("Treino: %s (%dx%d)%n", nome, series, repeticoes);
        exercicios.forEach(Exercicio::exibirDetalhes);
    }

    @Override
    public String toString() {
        return String.format("Treino{nome='%s', series=%d, repeticoes=%d, exercicios=%d}",
                nome, series, repeticoes, exercicios.size());
    }
}
