package Menus;

import Entidades.Cliente;
import Entidades.Usuario;
import Utilidades.Verificadores;

import java.util.ArrayList;
import java.util.Scanner;

public class MenusConcessionaria {
    static Scanner scan = new Scanner(System.in);

    public static void menuPrincipal() {
        System.out.println("------------------");
        System.out.println("1- Entrar");
        System.out.println("2- Cadastrar");
        System.out.println("3- Esqueceu sua senha");
        System.out.println("------------------");
        int escolhaPrincipal = scan.nextInt();

        while (escolhaPrincipal != 1 && escolhaPrincipal !=2 && escolhaPrincipal != 3) {
            System.out.println("Digite novamente, apenas 1,2 ou 3");
            escolhaPrincipal = scan.nextInt();
        }
        if (escolhaPrincipal == 1) {
            menuEntrar();
        } else if (escolhaPrincipal == 2) {
            menuCadastro();
        } else if (escolhaPrincipal == 3) {
            Usuario usuarioCadastrado = null;
            System.out.println("Digite o email da sua conta");
            scan.nextLine();
            String emailEsqueceuSenha = scan.nextLine();
            Verificadores.verificacaoEmail(emailEsqueceuSenha);

            for (Usuario usuarioEsqueceuSenha : MenusClientes.listaClientesCadastrados) {
                if (usuarioEsqueceuSenha.getEmail().equals(emailEsqueceuSenha)) {
                    usuarioCadastrado = usuarioEsqueceuSenha;
                    break;
                }
            }
            if (usuarioCadastrado != null) {
                System.out.println("Digite sua nova senha: ");
                String senhaNova = scan.nextLine();
                usuarioCadastrado.alterarSenha(senhaNova);
                System.out.println("Senha alterada com sucesso");
            } else {
                System.out.println("Este email não está cadastrado");
            }
        }
    }
    public static void menuCadastro() {
        System.out.println("Você é admin ou cliente?");
        System.out.println("Digite 'c' se for cliente e digite 'a' se for admin");
        scan.nextLine();
        String adminOuCliente = scan.nextLine();
        char verificacaoAdminOuCliente = adminOuCliente.charAt(0);

        do {
            if (verificacaoAdminOuCliente != 'c' && verificacaoAdminOuCliente != 'a') {
                System.out.println("Entrada inválida! Digite novamente, apenas 'c' ou 'a'.");
                adminOuCliente = scan.nextLine();
            }
        }while (verificacaoAdminOuCliente != 'c' && verificacaoAdminOuCliente != 'a');

        if(verificacaoAdminOuCliente == 'c'){
            MenusClientes.menuCadastroCliente();
        } else if (verificacaoAdminOuCliente == 'a') {
            MenusAdmin.menuAdminCadastro();
        }
    }
    public static void menuEntrar() {
        System.out.println("Você é admin ou cliente?");
        System.out.println("Digite 'c' se for cliente e digite 'a' se for admin");
        scan.nextLine();
        String adminOuCliente = scan.nextLine();
        char verificacaoAdminOuCliente = adminOuCliente.charAt(0);

        do {
            if (verificacaoAdminOuCliente != 'c' && verificacaoAdminOuCliente != 'a') {
                System.out.println("Entrada inválida! Digite novamente, apenas 'c' ou 'a'.");
                adminOuCliente = scan.nextLine();
            }
        }while (verificacaoAdminOuCliente != 'c' && verificacaoAdminOuCliente != 'a');

        if(verificacaoAdminOuCliente == 'c'){
            System.out.println("Insira seu email: ");
            String email = scan.next();
            Verificadores.verificacaoEmail(email);
            System.out.println("Insira sua senha: ");
            scan.nextLine();
            String senha = scan.nextLine();
            Cliente verificadorClienteCadastrado = null;
            for (Cliente clienteCadastrado : MenusClientes.listaClientesCadastrados){
                if(clienteCadastrado.getEmail().equals(email) &&
                        clienteCadastrado.getSenha().equals(senha)){
                    verificadorClienteCadastrado = clienteCadastrado;
                    break;
                }
            }
            if(verificadorClienteCadastrado != null){
                System.out.println("Login efetuado com sucesso");
                MenusClientes.menuClienteInicio();
            } else {
                System.out.println("Usuario não encontrado, email ou senha incorreta");
            }
        }

    }
}
