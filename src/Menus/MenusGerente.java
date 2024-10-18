package Menus;

import Entidades.Automovel;
import Entidades.Funcionario;

import java.util.Scanner;

import static Entidades.Funcionario.getListaFuncionariosCadastrados;
import static Entidades.Funcionario.listaFuncionariosCadastrados;
import static Utilidades.Constantes.GERENTE;
import static Utilidades.UtilidadesAutomoveis.listaAutomoveis;
import static Utilidades.Verificadores.*;

public class MenusGerente {
    static Scanner scan = new Scanner(System.in);

    public static void menuGerenteCadastro() {
        System.out.println("Insira seu nome: ");
        String nome = scan.nextLine();

        System.out.println("Insira seu email: ");
        String email = scan.nextLine();
        verificacaoEmail(email);

        System.out.println("Insira sua senha: ");
        String senha = scan.nextLine();

        System.out.println("Insira seu CPF(xxxxxxxxxxx): ");
        String cpf = scan.nextLine();
        verificacaoCPF(cpf);

        System.out.println("Insira seu telefone(9xxxxxxxx): ");
        String telefone = scan.nextLine();
        verificacaoTelefone(telefone);

        System.out.println("Digite seu cargo: ");
        String cargo = scan.nextLine().toUpperCase();
        if (!cargo.equals(GERENTE)) {
            System.out.println("Apenas GERENTES podem utilizar o sistema");
            System.exit(0);
        }
        System.out.println("Digite seu salario: ");
        double salario = scan.nextDouble();

        listaFuncionariosCadastrados.add(new Funcionario(email, senha, cpf, nome,
                telefone, cargo, salario));
    }

    public static void menuGerenteInicio() {
        while (true) {
            System.out.println("------------------");
            System.out.println("1- Add funcionário");
            System.out.println("2- Editar funcionário");
            System.out.println("3- Exibir funcionários");
            System.out.println("4- Add Automóveis");
            System.out.println("5- Editar Automóveis");
            System.out.println("6- Exibir Automóveis");
            System.out.println("7- Sair do programa");
            System.out.println("------------------");
            int escolha = scan.nextInt();
            scan.nextLine();

            switch (escolha) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    editarFuncionario();
                    break;
                case 3:
                    exibirFuncionarios();
                    break;
                case 4:
                    adicionarAutomovel();
                    break;
                case 5:
                    editarAutomovel();
                    break;
                case 6:
                    exibirAutomoveis();
                    break;
                case 7:
                    MenusConcessionaria.menuPrincipal();
                    break;
                default:
                    System.out.println("Escolha invalida. Tente novamente.");
            }
        }
    }

    private static void adicionarFuncionario() {
        System.out.println("Digite o nome: ");
        String nome = scan.nextLine();
        System.out.println("Digite o CPF (xxxxxxxxxxx): ");
        String cpf = scan.nextLine();
        verificacaoCPF(cpf);
        System.out.println("Digite o telefone (9xxxxxxxx): ");
        String telefone = scan.nextLine();
        verificacaoTelefone(telefone);
        System.out.println("Digite o cargo: ");
        String cargo = scan.nextLine().toUpperCase();
        System.out.println("Digite o salário: ");
        double salario = scan.nextDouble();
        scan.nextLine();

        Funcionario novoFuncionario = new Funcionario(nome, cpf, telefone, cargo, salario);
        getListaFuncionariosCadastrados().add(novoFuncionario);
        System.out.println("Cadastro feito com sucesso. ID do funcionário: " + novoFuncionario.getId());
    }

    private static void editarFuncionario() {
        System.out.println("Digite o ID do funcionário que deseja alterar: ");
        int idFuncionarioAlterar = scan.nextInt();
        scan.nextLine();
        Funcionario funcionarioAlterado = null;

        for (Funcionario funcionarioCadastrado : getListaFuncionariosCadastrados()) {
            if (funcionarioCadastrado.getId() == idFuncionarioAlterar) {
                funcionarioAlterado = funcionarioCadastrado;
                break;
            }
        }

        if (funcionarioAlterado == null) {
            System.out.println("Este funcionário não está cadastrado");
            return;
        }

        System.out.println("---------------------------");
        System.out.println("O que você deseja alterar: ");
        System.out.println("1- Alterar cargo");
        System.out.println("2- Alterar salário");
        System.out.println("3- Excluir funcionário");
        System.out.println("4- Voltar");
        System.out.println("---------------------------");
        int escolhaAlterar = scan.nextInt();
        scan.nextLine();

        switch (escolhaAlterar) {
            case 1:
                System.out.println("Cargo atual do funcionário: " + funcionarioAlterado.getCargo());
                System.out.println("Digite o novo cargo do funcionário: ");
                String cargoNovo = scan.nextLine();
                funcionarioAlterado.setCargo(cargoNovo);
                System.out.println("Cargo alterado com sucesso");
                break;
            case 2:
                System.out.println("Salário atual do funcionário: " + funcionarioAlterado.getSalario());
                System.out.println("Digite o novo salário do funcionário: ");
                double salarioNovo = scan.nextDouble();
                funcionarioAlterado.setSalario(salarioNovo);
                System.out.println("Salário alterado com sucesso");
                break;
            case 3:
                listaFuncionariosCadastrados.remove(funcionarioAlterado);
                System.out.println("Funcionário excluído");
                break;
            case 4:
                break;
            default:
                System.out.println("Escolha inválida.");
        }
    }

    private static void exibirFuncionarios() {
        if (listaFuncionariosCadastrados.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            System.out.println("Funcionários cadastrados:");
            for (Funcionario funcionario : listaFuncionariosCadastrados) {
                System.out.println(funcionario);
            }
        }
    }

    private static void adicionarAutomovel() {
        System.out.println("Digite o nome do automóvel: ");
        String nome = scan.nextLine();
        System.out.println("Digite o ID do automóvel: ");
        String id = scan.nextLine();
        System.out.println("Digite o chassi do automóvel: ");
        String chassi = scan.nextLine();
        System.out.println("Digite a placa do automóvel: ");
        String placa = scan.nextLine();
        System.out.println("Digite o valor do automóvel: ");
        double valor = scan.nextDouble();
        System.out.println("Digite a condição do automóvel (true/false): ");
        boolean novo = scan.nextBoolean();

        listaAutomoveis.add(new Automovel(nome, chassi, id, novo, placa, valor));
        System.out.println("Automóvel cadastrado com sucesso!");
    }

    private static void editarAutomovel() {
        System.out.println("Digite o ID do automóvel que deseja alterar: ");
        String idAutomovelAlterar = scan.nextLine();
        Automovel automovelAlterado = null;

        for (Automovel automovelCadastrado : listaAutomoveis) {
            if (automovelCadastrado.getId().equals(idAutomovelAlterar)) {
                automovelAlterado = automovelCadastrado;
                break;
            }
        }

        if (automovelAlterado == null) {
            System.out.println("Este automóvel não está cadastrado");
            return;
        }

        System.out.println("---------------------------");
        System.out.println("O que você deseja alterar: ");
        System.out.println("1- Alterar nome");
        System.out.println("2- Alterar chassi");
        System.out.println("3- Alterar placa");
        System.out.println("4- Alterar valor");
        System.out.println("5- Alterar condição (novo/usado)");
        System.out.println("6- Excluir automóvel");
        System.out.println("7- Voltar");
        System.out.println("---------------------------");
        int escolhaAlterar = scan.nextInt();
        scan.nextLine();

        switch (escolhaAlterar) {
            case 1:
                System.out.println("Nome atual do automóvel: " + automovelAlterado.getNome());
                System.out.println("Digite o novo nome do automóvel: ");
                String nomeNovo = scan.nextLine();
                automovelAlterado.setNome(nomeNovo);
                System.out.println("Nome alterado com sucesso");
                break;
            case 2:
                System.out.println("Chassi atual do automóvel: " + automovelAlterado.getChassi());
                System.out.println("Digite o novo chassi do automóvel: ");
                String chassiNovo = scan.nextLine();
                automovelAlterado.setChassi(chassiNovo);
                System.out.println("Chassi alterado com sucesso");
                break;
            case 3:
                System.out.println("Placa atual do automóvel: " + automovelAlterado.getPlaca());
                System.out.println("Digite a nova placa do automóvel: ");
                String placaNova = scan.nextLine();
                automovelAlterado.setPlaca(placaNova);
                System.out.println("Placa alterada com sucesso");
                break;
            case 4:
                System.out.println("Valor atual do automóvel: " + automovelAlterado.getValor());
                System.out.println("Digite o novo valor do automóvel: ");
                double valorNovo = scan.nextDouble();
                automovelAlterado.setValor(valorNovo);
                System.out.println("Valor alterado com sucesso");
                break;
            case 5:
                System.out.println("Condição atual do automóvel (true para novo, false para usado): " + automovelAlterado.isNovo());
                System.out.println("Digite a nova condição do automóvel (true/false): ");
                boolean novaCondicao = scan.nextBoolean();
                automovelAlterado.setNovo(novaCondicao);
                System.out.println("Condição alterada com sucesso");
                break;
            case 6:
                listaAutomoveis.remove(automovelAlterado);
                System.out.println("Automóvel excluído");
                break;
            case 7:
                break;
            default:
                System.out.println("Escolha inválida.");
        }
    }

    private static void exibirAutomoveis() {
        if (listaAutomoveis.isEmpty()) {
            System.out.println("Nenhum automóvel cadastrado.");
        } else {
            System.out.println("Automóveis cadastrados:");
            for (Automovel automovel : listaAutomoveis) {
                System.out.println(automovel);
            }
        }
    }
}

