package br.com.fitlife.model;

import br.com.fitlife.exception.TreinoInvalidoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Cliente da academia FitLife, com validação de dados,
 * plano associado (associação) e lista de treinos (composição).
 */
public class Cliente {

    private static final int IDADE_MINIMA = 15;

    private String nome;
    private String email;
    private int idade;
    private Plano plano;
    private final List<Treino> treinos = new ArrayList<>();

    public Cliente(String nome, String email, int idade) {
        validarDados(nome, email, idade);
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public Cliente(String nome, String email, int idade, Plano plano) {
        this(nome, email, idade);
        associarPlano(plano);
    }

    private static void validarDados(String nome, String email, int idade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório!");
        }
        if (email == null || email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido!");
        }
        if (idade < IDADE_MINIMA) {
            throw new IllegalArgumentException("Idade mínima é " + IDADE_MINIMA + " anos!");
        }
    }

    /** Revalida os dados atuais do cliente. */
    public void validarDados() {
        validarDados(nome, email, idade);
    }

    public void associarPlano(Plano plano) {
        if (plano == null) {
            throw new IllegalArgumentException("Plano inválido!");
        }
        this.plano = plano;
    }

    public void adicionarTreino(Treino treino) {
        if (treino == null) {
            throw new TreinoInvalidoException("Treino inválido!");
        }
        treinos.add(treino);
    }

    public double calcularMensalidade() {
        if (plano == null) {
            throw new IllegalStateException("Cliente não possui plano associado!");
        }
        return plano.calcularMensalidade();
    }

    public void exibirDados() {
        System.out.println("Cliente: " + nome);
        System.out.println("E-mail: " + email);
        System.out.println("Idade: " + idade);
        System.out.println("Plano: " + (plano != null ? plano.getNome() : "nenhum"));
        treinos.forEach(Treino::exibirTreino);
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarDados(nome, this.email, this.idade);
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validarDados(this.nome, email, this.idade);
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        validarDados(this.nome, this.email, idade);
        this.idade = idade;
    }

    public Plano getPlano() {
        return plano;
    }

    public List<Treino> getTreinos() {
        return Collections.unmodifiableList(treinos);
    }

    @Override
    public String toString() {
        return String.format("Cliente{nome='%s', email='%s', idade=%d, plano=%s, treinos=%d}",
                nome, email, idade, plano != null ? plano.getNome() : "nenhum", treinos.size());
    }
}
