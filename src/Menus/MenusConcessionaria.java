package Menus;

import Entidades.Administrador;
import Entidades.Cliente;

import java.util.Scanner;

import static Menus.MenusAdmin.*;
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
        System.out.println("------------------");
        int escolhaPrincipal = scan.nextInt();

        while (escolhaPrincipal != 1 && escolhaPrincipal !=2 && escolhaPrincipal != 3) {
            System.out.println("Digite novamente, apenas 1,2 ou 3");
            escolhaPrincipal = scan.nextInt();
        }
        if (escolhaPrincipal == 1) {
            menuEntrar();
        }
        if (escolhaPrincipal == 2) {
            menuCadastro();
        }
        if (escolhaPrincipal == 3) {
            Cliente clienteCadastrado = null;
            Administrador adminCadastrado = null;
            System.out.println("Digite o email da sua conta");
            scan.nextLine();
            String emailEsqueceuSenha = scan.nextLine();
            verificacaoEmail(emailEsqueceuSenha);

            for (Cliente clienteEsqueceuSenha : listaClientesCadastrados) {
                for(Administrador adminEsqueceuSenha : MenusAdmin.listaAdminsCadastrados){
                    if (clienteEsqueceuSenha.getEmail().equals(emailEsqueceuSenha)) {
                        clienteCadastrado = clienteEsqueceuSenha;
                        break;
                    }
                    if(adminEsqueceuSenha.getEmail().equals(emailEsqueceuSenha)){
                        adminCadastrado = adminEsqueceuSenha;
                        break;
                    }
                }
            }
            if (clienteCadastrado != null) {
                System.out.println("Digite sua nova senha: ");
                String senhaNova = scan.nextLine();
                clienteCadastrado.alterarSenha(senhaNova);
                System.out.println("Senha alterada com sucesso");
            }
            if(adminCadastrado != null){
                System.out.println("Digite sua nova senha: ");
                String senhaNova = scan.nextLine();
                adminCadastrado.alterarSenha(senhaNova);
                System.out.println("Senha alterada com sucesso");
            }
            if(adminCadastrado == null && clienteCadastrado == null){
                System.out.println("Este email não está cadastrado");
            }
        }
    }
    public static void menuCadastro() {
        verificacaoAdminOuCliente();
        if(verificacaoAdminOuCliente() == 'c'){
            menuCadastroCliente();
        } else if (verificacaoAdminOuCliente() == 'a') {
            menuAdminCadastro();
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
        Administrador verificadorAdminCadastrado = null;
        for (Cliente clienteCadastrado : listaClientesCadastrados){
            for(Administrador adminCadastrado : listaAdminsCadastrados){
                if(clienteCadastrado.getEmail().equals(email) &&
                        clienteCadastrado.getSenha().equals(senha)){
                    verificadorClienteCadastrado = clienteCadastrado;
                    break;
                }
                if(adminCadastrado.getEmail().equals(email) &&
                        adminCadastrado.getSenha().equals(senha)){
                    verificadorAdminCadastrado = adminCadastrado;
                    break;
                }
            }
        }
        if(verificadorClienteCadastrado != null){
            System.out.println("Login efetuado com sucesso");
            menuClienteInicio();
        }
        if(verificadorAdminCadastrado != null){
            System.out.println("Login efetuado com sucesso");
            menuAdminInicio();
        }
        if(verificadorClienteCadastrado == null && verificadorAdminCadastrado == null){
            System.out.println("Usuario não encontrado, senha ou email incorreto");
        }
    }
}
