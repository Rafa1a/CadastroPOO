package cadastropoo;

/**
 *
 * @author Windows 10
 */
import model.*;

import java.io.IOException;

import java.util.Scanner;

// 2º Procedimento resultado FINAL 
public class CadastroPOO {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PessoaFisicaRepo repoPessoaFisica = new PessoaFisicaRepo();
    private static final PessoaJuridicaRepo repoPessoaJuridica = new PessoaJuridicaRepo();
    private static final String arquivoPrefixo = "dados";

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            System.out.println("Opções:");
            System.out.println("1. Incluir");
            System.out.println("2. Alterar");
            System.out.println("3. Excluir");
            System.out.println("4. Exibir pelo ID");
            System.out.println("5. Exibir todos");
            System.out.println("6. Salvar dados");
            System.out.println("7. Recuperar dados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> incluir();
                    case 2 -> alterar();
                    case 3 -> excluir();
                    case 4 -> exibirPorId();
                    case 5 -> exibirTodos();
                    case 6 -> salvarDados();
                    case 7 -> recuperarDados();
                    case 0 -> executando = false;
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (IOException e) {
                System.out.println("Erro de entrada/saída: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void incluir() throws IOException {
        System.out.println();
        System.out.println("Escolha o tipo:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.print("Digite o número correspondente: ");
        System.out.println();

        int tipo = Integer.parseInt(scanner.nextLine());

        switch (tipo) {
            case 1 ->                 {
                    System.out.print("Digite o ID da Pessoa Física: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Digite o nome da Pessoa Física: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF da Pessoa Física: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Digite a idade da Pessoa Física: ");
                    int idade = Integer.parseInt(scanner.nextLine());
                    PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf, idade);
                    repoPessoaFisica.inserir(pessoaFisica);
                    System.out.println();
                }
            case 2 ->                 {
                    System.out.print("Digite o ID da Pessoa Jurídica: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Digite o nome da Pessoa Jurídica: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CNPJ da Pessoa Jurídica: ");
                    String cnpj = scanner.nextLine();
                    PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
                    repoPessoaJuridica.inserir(pessoaJuridica);
                    System.out.println();
                }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void alterar() throws IOException {
        System.out.println();
        System.out.println("Escolha o tipo:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.print("Digite o número correspondente: ");
        System.out.println();

        int tipo = Integer.parseInt(scanner.nextLine());

        switch (tipo) {
            case 1 ->                 {
                    System.out.print("Digite o ID da Pessoa Física: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    PessoaFisica pessoaFisica = repoPessoaFisica.obter(id);
                    if (pessoaFisica != null) {
                        System.out.println("Dados atuais:");
                        pessoaFisica.exibir();
                        
                        System.out.print("Digite o novo nome da Pessoa Física: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Digite o novo CPF da Pessoa Física: ");
                        String novoCpf = scanner.nextLine();
                        System.out.print("Digite a nova idade da Pessoa Física: ");
                        int novaIdade = Integer.parseInt(scanner.nextLine());
                        
                        pessoaFisica.setNome(novoNome);
                        pessoaFisica.setCpf(novoCpf);
                        pessoaFisica.setIdade(novaIdade);
                        
                        repoPessoaFisica.alterar(pessoaFisica);
                        System.out.println("Pessoa Física alterada com sucesso.");
                        System.out.println();
                    } else {
                        System.out.println("Pessoa Física não encontrada.");
                    }                      }
            case 2 ->                 {
                    System.out.print("Digite o ID da Pessoa Jurídica: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    PessoaJuridica pessoaJuridica = repoPessoaJuridica.obter(id);
                    if (pessoaJuridica != null) {
                        System.out.println("Dados atuais:");
                        pessoaJuridica.exibir();
                        
                        System.out.print("Digite o novo nome da Pessoa Jurídica: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Digite o novo CNPJ da Pessoa Jurídica: ");
                        String novoCnpj = scanner.nextLine();
                        
                        pessoaJuridica.setNome(novoNome);
                        pessoaJuridica.setCnpj(novoCnpj);
                        
                        repoPessoaJuridica.alterar(pessoaJuridica);
                        System.out.println("Pessoa Jurídica alterada com sucesso.");
                        System.out.println();
                    } else {
                        System.out.println("Pessoa Jurídica não encontrada.");
                    }                      }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void excluir() throws IOException {
        System.out.println();
        System.out.println("Escolha o tipo:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.print("Digite o número correspondente: ");
        System.out.println();

        int tipo = Integer.parseInt(scanner.nextLine());

        switch (tipo) {
            case 1 ->                 {
                    System.out.print("Digite o ID da Pessoa Física: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    PessoaFisica pessoaFisica = repoPessoaFisica.obter(id);
                    if (pessoaFisica != null){
                        pessoaFisica.exibir();
                        System.out.println("1. Excluir");
                        System.out.println("2. Não Excluir");
                        int tipo1 = Integer.parseInt(scanner.nextLine());
                        
                        switch (tipo1) {
                            case 1 -> {
                                repoPessoaFisica.excluir(id);
                                System.out.println("Pessoa Física excluída com sucesso.");
                                System.out.println();
                            }
                            case 2 -> {
                                excluir();
                                System.out.println();
                            }
                            default -> System.out.println("Opção inválida. Tente novamente.");
                        }
                        
                    }else {
                        System.out.println("Pessoa Física não encontrada");
                        System.out.println();
                    }                      }
            case 2 ->                 {
                    System.out.print("Digite o ID da Pessoa Jurídica: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    PessoaJuridica pessoaJuridica = repoPessoaJuridica.obter(id);
                    if (pessoaJuridica != null){
                        pessoaJuridica.exibir();
                        System.out.println("1. Excluir");
                        System.out.println("2. Não Excluir");
                        int tipo1 = Integer.parseInt(scanner.nextLine());
                        
                        switch (tipo1) {
                            case 1 -> {
                                repoPessoaJuridica.excluir(id);
                                System.out.println("Pessoa Jurídica excluída com sucesso.");
                                System.out.println();
                            }
                            case 2 -> {
                                excluir();
                                System.out.println();
                            }
                            default -> System.out.println("Opção inválida. Tente novamente.");
                        }
                    }else {
                        System.out.println("Pessoa Jurídica não encontrada");
                        System.out.println();
                    }                      }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void exibirPorId() throws IOException {
        System.out.println();
        System.out.println("Escolha o tipo:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.print("Digite o número correspondente: ");
        System.out.println();

        int tipo = Integer.parseInt(scanner.nextLine());

        switch (tipo) {
            case 1 ->                 {
                    System.out.print("Digite o ID da Pessoa Física: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    PessoaFisica pessoaFisica = repoPessoaFisica.obter(id);
                    if (pessoaFisica != null) {
                        pessoaFisica.exibir();
                    } else {
                        System.out.println();
                        System.out.println("Pessoa Física não encontrada.");
                    }                      }
            case 2 ->                 {
                    System.out.print("Digite o ID da Pessoa Jurídica: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    PessoaJuridica pessoaJuridica = repoPessoaJuridica.obter(id);
                    if (pessoaJuridica != null) {
                        pessoaJuridica.exibir();
                    } else {
                        System.out.println();
                        System.out.println("Pessoa Jurídica não encontrada.");
                    }                      }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void exibirTodos() throws IOException {
        System.out.println();
        System.out.println("Escolha o tipo:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.print("Digite o número correspondente: ");
        System.out.println();

        int tipo = Integer.parseInt(scanner.nextLine());

        switch (tipo) {
            case 1 -> {
                for (PessoaFisica pessoaFisica : repoPessoaFisica.obterTodos()) {
                    pessoaFisica.exibir();
                    System.out.println();
                }
            }
            case 2 -> {
                for (PessoaJuridica pessoaJuridica : repoPessoaJuridica.obterTodos()) {
                    pessoaJuridica.exibir();
                    System.out.println();
                }
            }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void salvarDados() {
        try {
            repoPessoaFisica.persistir(arquivoPrefixo + ".fisica.bin");
            repoPessoaJuridica.persistir(arquivoPrefixo + ".juridica.bin");
            System.out.println("Dados salvos com sucesso.");
            System.out.println();
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    private static void recuperarDados() {
        try {
            repoPessoaFisica.recuperar(arquivoPrefixo + ".fisica.bin");
            repoPessoaJuridica.recuperar(arquivoPrefixo + ".juridica.bin");
            System.out.println("Dados recuperados com sucesso.");
            System.out.println();
        } catch (IOException e) {
            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados: classe não encontrada.");
        }
    }
    
}
