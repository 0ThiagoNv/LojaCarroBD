package Menus;

import Utilidades.Verificadores;
import java.util.Scanner;

public class MenusAdmin {
    static Scanner scan = new Scanner(System.in);
    public static void menuAdminCadastro(){
        System.out.println("Insira seu nome: ");
        scan.nextLine();
        String nome = scan.nextLine();
        System.out.println("Insira seu email: ");
        String email = scan.nextLine();
        Verificadores.verificacaoEmail(email);
        System.out.println("Insira sua senha: ");
        String senha = scan.nextLine();
        System.out.println("Insira seu CPF: ");
        String cpf = scan.nextLine();
        Verificadores.verificacaoCPF(cpf);
        System.out.println("Insira seu telefone");
        String telefone = scan.nextLine();
        Verificadores.verificacaoTelefone(telefone);
        System.out.println("Digite seu cargo: ");
        String cargo = scan.nextLine();
        System.out.println("Digite seu salario: ");
        double salario = scan.nextDouble();
    }
    public static void menuAdminInicio(){
        System.out.println("------------------");
        System.out.println("1- Add funcionario");
        System.out.println("2- Editar funcionario");
        System.out.println("3- Exibir Automóveis");
        System.out.println("4- Editar Automóveis");
        System.out.println("5- Sair do programa");
        System.out.println("------------------");
    }
}
