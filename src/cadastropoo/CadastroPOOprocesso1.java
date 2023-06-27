package cadastropoo;

/**
 *
 * @author Windows 10
 */
import model.*;

import java.io.IOException;

// 1º Procedimento test 1

public class CadastroPOOprocesso1 {
    public static void main(String[] args) {
        String arquivo = "dados.ser";

        // Testando repositório de pessoas físicas
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        repo1.inserir(new PessoaFisica(1, "João", "123456789", 30));
        repo1.inserir(new PessoaFisica(2, "Maria", "987654321", 25));

        try {
            repo1.persistir(arquivo);
        } catch (IOException e) {
            System.out.println("Erro ao persistir os dados: " + e.getMessage());
        }

        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        try {
            repo2.recuperar(arquivo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
        }

        System.out.println("Pessoas Físicas recuperadas:");
        for (PessoaFisica pessoaFisica : repo2.obterTodos()) {
            pessoaFisica.exibir();
            System.out.println();
        }

        // Testando repositório de pessoas jurídicas
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        repo3.inserir(new PessoaJuridica(1, "Empresa A", "1234567890"));
        repo3.inserir(new PessoaJuridica(2, "Empresa B", "9876543210"));

        try {
            repo3.persistir(arquivo);
        } catch (IOException e) {
            System.out.println("Erro ao persistir os dados: " + e.getMessage());
        }

        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        try {
            repo4.recuperar(arquivo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
        }

        System.out.println("Pessoas Jurídicas recuperadas:");
        for (PessoaJuridica pessoaJuridica : repo4.obterTodos()) {
            pessoaJuridica.exibir();
            System.out.println();
        }
    }
}
