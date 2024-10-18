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

    public static void menuGerenteCadastro(){
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
        if(!cargo.equals(GERENTE)){
            System.out.println("Apenas GERENTES podem utilizar o sistema");
            System.exit(0);
        }

        System.out.println("Digite seu salario: ");
        double salario = scan.nextDouble();

        listaFuncionariosCadastrados.add(new Funcionario(email, senha, cpf,nome,
                telefone, cargo, salario ));
    }
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
        String placa = scan.next();
        verificacaoPlacaAutomovel(placa);

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
    }
}
