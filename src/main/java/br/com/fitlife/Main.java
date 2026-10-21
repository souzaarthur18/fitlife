package br.com.fitlife;

import br.com.fitlife.model.Calculavel;
import br.com.fitlife.model.Cliente;
import br.com.fitlife.model.Exercicio;
import br.com.fitlife.model.Pagamento;
import br.com.fitlife.model.Plano;
import br.com.fitlife.model.PlanoMensal;
import br.com.fitlife.model.PlanoPremium;
import br.com.fitlife.model.Treino;
import br.com.fitlife.service.PagamentoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstração do módulo FitLife.
 */
public class Main {

    public static void main(String[] args) {
        PagamentoService pagamentoService = new PagamentoService();

        // 1 e 2. Cadastro de clientes e planos
        Plano mensal = new PlanoMensal();
        Plano premium = new PlanoPremium();

        Cliente joao = new Cliente("João Silva", "joao@email.com", 25);
        Cliente maria = new Cliente("Maria Souza", "maria@email.com", 30);

        // 3. Associação de plano ao cliente
        joao.associarPlano(mensal);
        maria.associarPlano(premium);

        // 4. Treinos
        Treino treinoA = new Treino("Treino A - Peito e Tríceps", 4, 12);
        treinoA.adicionarExercicio(new Exercicio("Supino reto", "Peito"));
        treinoA.adicionarExercicio(new Exercicio("Tríceps corda", "Tríceps"));
        joao.adicionarTreino(treinoA);

        Treino treinoB = new Treino("Treino B - Pernas", 3, 15);
        treinoB.adicionarExercicio(new Exercicio("Agachamento", "Pernas"));
        maria.adicionarTreino(treinoB);

        // 7. Exibição de informações
        System.out.println("=== CLIENTES ===");
        joao.exibirDados();
        System.out.println();
        maria.exibirDados();

        // Polimorfismo com a interface Calculavel
        System.out.println("\n=== POLIMORFISMO ===");
        List<Calculavel> planos = new ArrayList<>();
        planos.add(mensal);
        planos.add(premium);
        for (Calculavel plano : planos) {
            System.out.printf("Mensalidade: R$ %.2f%n", plano.calcularMensalidade());
        }

        // 5. Pagamentos
        System.out.println("\n=== PAGAMENTOS ===");
        Pagamento p1 = pagamentoService.processarPagamento(joao, "Pix");
        p1.exibirComprovante();
        System.out.println();
        Pagamento p2 = pagamentoService.processarPagamento(maria);
        p2.exibirComprovante();

        // 6. Validação de dados e tratamento de exceções
        System.out.println("\n=== VALIDAÇÕES ===");
        try {
            new Cliente("Pedro", "pedro@email.com", 14);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            new Cliente("", "x@email.com", 20);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            new Cliente("Ana", "email-invalido", 20);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            pagamentoService.processarPagamento(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Cliente semPlano = new Cliente("Carlos", "carlos@email.com", 40);
            pagamentoService.processarPagamento(semPlano);
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado no sistema.");
        }
    }
}
