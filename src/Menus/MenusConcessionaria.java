package Menus;

import Entidades.Cliente;
import Entidades.Funcionario;

import java.util.Scanner;

import static Entidades.Cliente.listaClientesCadastrados;
import static Entidades.Funcionario.listaFuncionariosCadastrados;
import static Menus.MenusGerente.*;
import static Menus.MenusClientes.*;
import static Utilidades.Verificadores.verificacaoAdminOuCliente;
import static Utilidades.Verificadores.verificacaoEmail;

public class MenusConcessionaria {
    static Scanner scan = new Scanner(System.in);

    public static void menuPrincipal() {

        System.out.println("------------------");
        System.out.println("1- Entrar");
        System.out.println("2- Cadastrar");
        System.out.println("3- Esqueceu sua senha");
        System.out.println("4- Sair");
        System.out.println("------------------");

        int escolhaPrincipal = scan.nextInt();
        while (escolhaPrincipal != 1 && escolhaPrincipal !=2 &&
                escolhaPrincipal != 3 && escolhaPrincipal !=  4) {
            System.out.println("Digite novamente, apenas 1,2,3 ou 4");
            escolhaPrincipal = scan.nextInt();
        }
        switch (escolhaPrincipal) {
            case 1:
                menuEntrar();
                break;
            case 2:
                menuCadastro();
                break;
            case 3:
                usuarioEsqueceuSenha();
                break;
            case 4:
                System.out.println("Saindo...");
                System.exit(0);
        }
    }
    public static void menuCadastro() {
        char opcaoClienteOuAdmin = verificacaoAdminOuCliente();
        if(opcaoClienteOuAdmin == 'c'){
            menuCadastroCliente();
        } else if (opcaoClienteOuAdmin == 'a') {
            menuGerenteCadastro();
        }
    }
    public static void menuEntrar() {

        System.out.println("Insira seu email: ");
        String email = scan.next();
        verificacaoEmail(email);
        System.out.println("Insira sua senha: ");
        scan.nextLine();
        String senha = scan.nextLine();
        Cliente verificadorClienteCadastrado = null;
        Funcionario verificadorFuncionarioCadastrado = null;
        for (Cliente clienteCadastrado : listaClientesCadastrados){
            if(clienteCadastrado.getEmail().equals(email) &&
                    clienteCadastrado.getSenha().equals(senha)){
                verificadorClienteCadastrado = clienteCadastrado;
                break;
            }
        }
        for(Funcionario funcionarioCadastrado : listaFuncionariosCadastrados){
            if(funcionarioCadastrado.getEmail().equals(email) &&
                    funcionarioCadastrado.getSenha().equals(senha)){
                verificadorFuncionarioCadastrado = funcionarioCadastrado;
                break;
            }
        }

        if(verificadorClienteCadastrado != null){
            System.out.println("Login efetuado com sucesso");
            menuClienteInicio();
        }
        if(verificadorFuncionarioCadastrado != null){
            System.out.println("Login efetuado com sucesso");
            menuGerenteInicio();
        }
        if(verificadorClienteCadastrado == null && verificadorFuncionarioCadastrado == null){
            System.out.println("Usuario não encontrado, senha ou email incorreto");
        }
    }
    public static void usuarioEsqueceuSenha(){
        Cliente clienteCadastrado = null;
        Funcionario funcionarioCadastrado = null;
        System.out.println("Digite o email da sua conta");
        scan.nextLine();
        String emailEsqueceuSenha = scan.nextLine();
        verificacaoEmail(emailEsqueceuSenha);

        for (Cliente clienteEsqueceuSenha : listaClientesCadastrados){
            if(clienteEsqueceuSenha.getEmail().equals(emailEsqueceuSenha)){
                clienteCadastrado = clienteEsqueceuSenha;
                break;
            }
        }
        for(Funcionario funcionarioEsqueceuSenha : listaFuncionariosCadastrados){
            if(funcionarioEsqueceuSenha.getEmail().equals(emailEsqueceuSenha)){
                funcionarioCadastrado = funcionarioEsqueceuSenha;
                break;
            }
        }
        if (clienteCadastrado != null) {
            System.out.println("Digite sua nova senha: ");
            String senhaNova = scan.nextLine();
            clienteCadastrado.alterarSenha(senhaNova);
            System.out.println("Senha alterada com sucesso");
        }
        if(funcionarioCadastrado != null){
            System.out.println("Digite sua nova senha: ");
            String senhaNova = scan.nextLine();
            funcionarioCadastrado.alterarSenha(senhaNova);
            System.out.println("Senha alterada com sucesso");
        }
        if(funcionarioCadastrado == null && clienteCadastrado == null){
            System.out.println("Este email não está cadastrado");
        }
    }
}
