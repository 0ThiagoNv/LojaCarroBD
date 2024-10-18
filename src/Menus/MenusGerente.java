package Menus;

import Entidades.Automovel;
import Entidades.Funcionario;

import java.util.Scanner;

import static Entidades.Automovel.listaAutomoveis;
import static Entidades.Funcionario.listaFuncionariosCadastrados;
import static Menus.MenusConcessionaria.menuPrincipal;
import static Utilidades.Constantes.GERENTE;
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
<<<<<<< HEAD
    public static void menuGerenteInicio(){
        System.out.println("------------------");
        System.out.println("1- Adicionar funcionário");
        System.out.println("2- Exibir Funcionários");
        System.out.println("3- Editar funcionário");
        System.out.println("4- Adicionar Automóvel");
        System.out.println("5- Exibir Automóveis");
        System.out.println("6- Editar Automóvel");
        System.out.println("7- Sair do programa");
        System.out.println("------------------");
        int escolhaMenuGerenteInicio = scan.nextInt();
        while(escolhaMenuGerenteInicio != 1 && escolhaMenuGerenteInicio != 2 &&
                escolhaMenuGerenteInicio != 3 && escolhaMenuGerenteInicio != 4 &&
                escolhaMenuGerenteInicio != 5 && escolhaMenuGerenteInicio != 6 &&
                escolhaMenuGerenteInicio != 7){
            System.out.println("Digite novamente, valor invalido");
            escolhaMenuGerenteInicio = scan.nextInt();
        }
        switch (escolhaMenuGerenteInicio){
            case 1:
                adicionarFuncionario();
                break;
            case 2:
                exibirFuncionarios();
                break;
            case 3:
                editarFuncionario();
                break;
            case 4:
                adicionarAutomovel();
                break;
            case 5:
                exibirAutomoveis();
                break;
            case 6:
                editarAutomovel();
                break;
            case 7:
                System.out.println("Saindo do programa...");
                menuPrincipal();
                break;
        }
        menuGerenteInicio();
    }
    public static void adicionarFuncionario(){
        System.out.println("Digite o nome: ");
        scan.nextLine();
        String nome = scan.nextLine();

        System.out.println("Digite o cpf(xxxxxxxxxxx): ");
        String cpf = scan.nextLine();
        verificacaoCPF(cpf);

        System.out.println("Digite o telefone(9xxxxxxxx): ");
        String telefone = scan.nextLine();
        verificacaoTelefone(telefone);

        System.out.println("Digite o cargo: ");
        String cargo = scan.nextLine().toUpperCase();

        System.out.println("Digite o salario: ");
        double salario = scan.nextDouble();

        listaFuncionariosCadastrados.add(new Funcionario(nome, cpf, telefone,
                cargo, salario));
        System.out.println("Cadastro feito com sucesso");
    }
    public static void exibirFuncionarios(){
        for(Funcionario funcionarioCadastrado : listaFuncionariosCadastrados){
            System.out.println(funcionarioCadastrado);
        }
    }
    public static void editarFuncionario(){
        System.out.println("Digite o id do funcionario que deseja alterar: ");
        Integer idFuncionarioAlterar = scan.nextInt();
        Funcionario funcionarioAlterado = null;
        for(Funcionario funcionarioCadastrado : listaFuncionariosCadastrados){
            if(funcionarioCadastrado.getId().equals(idFuncionarioAlterar)){
                funcionarioAlterado = funcionarioCadastrado;
                break;
            }
        }
        if(funcionarioAlterado == null){
            System.out.println("este Funcionario não está cadastrado");
        }
        if(funcionarioAlterado != null){
            System.out.println("---------------------------");
            System.out.println("O que você deseja alterar: ");
            System.out.println("1- alterar cargo");
            System.out.println("2- alterar salario");
            System.out.println("3- excluir funcionario");
            System.out.println("4- voltar");
            System.out.println("---------------------------");
            int escolhaAlterar = scan.nextInt();
            while (escolhaAlterar != 1 && escolhaAlterar != 2 &&
                    escolhaAlterar != 3 && escolhaAlterar != 4) {
                System.out.println("Digite novamente, apenas 1,2,3 ou 4");
                escolhaAlterar = scan.nextInt();
            }
            if(escolhaAlterar == 1){
                System.out.println("Cargo atual do funcionário: "+ funcionarioAlterado.getCargo());
                System.out.println("Digite o cargo novo do funcionario: ");
                String cargoNovo = scan.next();
                funcionarioAlterado.setCargo(cargoNovo);
                System.out.println("Cargo alterado com sucesso");
            }
            if(escolhaAlterar == 2){
                System.out.println("Salário atual do funcionário: "+ funcionarioAlterado.getSalario());
                System.out.println("Digite o salario novo do funcionario: ");
                double salarioNovo = scan.nextDouble();
                funcionarioAlterado.setSalario(salarioNovo);
                System.out.println("Salario alterado com sucesso");
            }
            if(escolhaAlterar == 3){
                listaFuncionariosCadastrados.remove(funcionarioAlterado);
                System.out.println("Funcionario excluido");
            }
            if(escolhaAlterar == 4){
                menuGerenteInicio();
            }
        }
    }
    public static void adicionarAutomovel(){
        System.out.println("Digite o nome: ");
        scan.nextLine();
        String nomeAutomovel = scan.nextLine();

        System.out.println("Digite o chassi: ");
        String chassi = scan.nextLine();

        System.out.println("o carro é novo? ");
        boolean novo = scan.nextBoolean();

        System.out.println("Digite a placa: ");
        scan.nextLine();
        String placa = scan.nextLine();

        System.out.println("Digite o valor: ");
        double valor = scan.nextDouble();

        listaAutomoveis.add(new Automovel(nomeAutomovel, chassi, novo, placa, valor));
        System.out.println("Cadastro feito com sucesso");
    }
    public static void exibirAutomoveis(){
        for(Automovel automovelCadastrado : listaAutomoveis){
            System.out.println(automovelCadastrado);
        }
    }
    public static void editarAutomovel(){
        System.out.println("Digite o id do automovel que deseja alterar: ");
        int idAutomovelAlterar = scan.nextInt();
        Automovel automovelAlterado = null;
        for(Automovel automovel : listaAutomoveis){
            if(automovel.getId().equals(idAutomovelAlterar)){
                automovelAlterado = automovel;
                break;
            }
        }
        if(automovelAlterado == null){
            System.out.println("Este automovel não está cadastrado");
        }
        if(automovelAlterado != null){
            System.out.println("o que você deseja alterar no automovel: ");
            System.out.println("1- alterar valor");
            System.out.println("2- alterar chassi");
            System.out.println("3- alterar placa");
            System.out.println("4- voltar");
            int escolhaAutomovelAlterado = scan.nextInt();

            while (escolhaAutomovelAlterado != 1 && escolhaAutomovelAlterado != 2 &&
                    escolhaAutomovelAlterado != 3 && escolhaAutomovelAlterado != 4) {
                System.out.println("Digite novamente, apenas 1,2,3 ou 4");
                escolhaAutomovelAlterado = scan.nextInt();
            }
            if(escolhaAutomovelAlterado == 1){
                System.out.println("valor atual: "+ automovelAlterado.getValor());
                System.out.println("Digite o valor novo: ");
                double valorNovo = scan.nextDouble();
                automovelAlterado.setValor(valorNovo);
            }
            if(escolhaAutomovelAlterado == 2){
                System.out.println("chassi atual: "+ automovelAlterado.getChassi());
                System.out.println("Digite o chassi novo: ");
                String chassiNovo = scan.next();
                automovelAlterado.setChassi(chassiNovo);
            }
            if(escolhaAutomovelAlterado == 3){
                System.out.println("placa atual: "+ automovelAlterado.getPlaca());
                System.out.println("Digite a placa nova: ");
                String placaNova = scan.next();
                automovelAlterado.setPlaca(placaNova);
            }
            if(escolhaAutomovelAlterado == 4){
                menuGerenteInicio();
            }
        }
=======

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
>>>>>>> ccf2626ae69e2ace3af7b80751fc5483795e2cb5
    }
}

