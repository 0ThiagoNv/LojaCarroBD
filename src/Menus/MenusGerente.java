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
        System.out.println("1- Add funcionario");
        System.out.println("2- Editar funcionario");
        System.out.println("3- Exibir Automóveis");
        System.out.println("4- Editar Automóveis");
        System.out.println("5- Sair do programa");
        System.out.println("------------------");
        int escolhaMenuGerenteInicio = scan.nextInt();
        if(escolhaMenuGerenteInicio == 1){
            System.out.println("Digite o nome: ");
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

            getListaFuncionariosCadastrados().add(new Funcionario(nome, cpf, telefone,
                    cargo, salario));
            System.out.println("Cadastro feito com sucesso");
        }
        if(escolhaMenuGerenteInicio == 2){
            System.out.println("Digite o id do funcionario que deseja alterar: ");
            String cpfFuncionarioAlterar = scan.nextLine();
            Funcionario funcionarioAlterado = null;
            for(Funcionario funcionarioCadastrado : getListaFuncionariosCadastrados()){
                if(funcionarioCadastrado.getCpf().equals(cpfFuncionarioAlterar)){
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

                if(escolhaAlterar == 1){
                    System.out.println("Cargo atual do funcionário: "+ funcionarioAlterado.getCargo());
                    System.out.println("Digite o cargo novo do funcionario: ");
                    String cargoNovo = scan.nextLine();
                    funcionarioAlterado.setCargo(cargoNovo);
                    System.out.println("Cargo alterado com sucesso");
                    menuGerenteInicio();
                }
                if(escolhaAlterar == 2){
                    System.out.println("Salário atual do funcionário: "+ funcionarioAlterado.getSalario());
                    System.out.println("Digite o salario novo do funcionario: ");
                    double salarioNovo = scan.nextDouble();
                    funcionarioAlterado.setSalario(salarioNovo);
                    System.out.println("Salario alterado com sucesso");
                    menuGerenteInicio();
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
        if(escolhaMenuGerenteInicio == 3){
            for(Automovel automovel : listaAutomoveis){
                System.out.println(automovel);
            }
        }
        if(escolhaMenuGerenteInicio == 4){
            System.out.println("Digite o chassi do automovel que deseja alterar: ");
            String chassiAutomovelAlterar = scan.nextLine();
            Automovel automovelAlterado = null;
            for(Automovel automovel : listaAutomoveis){
                if(automovel.getChassi().equals(chassiAutomovelAlterar)){
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
                if(escolhaAutomovelAlterado == 1){
                    System.out.println("valor atual: "+ automovelAlterado.getValor());
                    System.out.println("Digite o valor novo: ");
                    double valorNovo = scan.nextDouble();
                    automovelAlterado.setValor(valorNovo);
                }
                if(escolhaAutomovelAlterado == 2){
                    System.out.println("chassi atual: "+ automovelAlterado.getChassi());
                    System.out.println("Digite o chassi novo: ");
                    String chassiNovo = scan.nextLine();
                    automovelAlterado.setChassi(chassiNovo);
                }
                if(escolhaAutomovelAlterado == 3){
                    System.out.println("placa atual: "+ automovelAlterado.getPlaca());
                    System.out.println("Digite a placa nova: ");
                    String placaNova = scan.nextLine();
                    automovelAlterado.setPlaca(placaNova);
                }
                if(escolhaAutomovelAlterado == 4){
                    menuGerenteInicio();
                }
            }
        }
        if(escolhaMenuGerenteInicio == 5){
            System.out.println("Saindo do programa...");
            System.exit(0);
        }
    }
}
