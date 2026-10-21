package br.com.fitlife.model;

public class Exercicio {

    private final String nome;
    private final String grupoMuscular;

    public Exercicio(String nome, String grupoMuscular) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do exercício é obrigatório!");
        }
        if (grupoMuscular == null || grupoMuscular.isBlank()) {
            throw new IllegalArgumentException("Grupo muscular é obrigatório!");
        }
        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
    }

    public String getNome() {
        return nome;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void exibirDetalhes() {
        System.out.printf("  - %s (%s)%n", nome, grupoMuscular);
    }

    @Override
    public String toString() {
        return nome + " [" + grupoMuscular + "]";
    }
}
