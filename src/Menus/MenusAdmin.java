package Menus;

import Entidades.Administrador;

import java.util.ArrayList;
import java.util.Scanner;

import static Utilidades.Verificadores.*;

public class MenusAdmin {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Administrador> listaAdminsCadastrados = new ArrayList<>();

    public static void menuAdminCadastro(){
        System.out.println("Insira seu nome: ");
        String nome = scan.nextLine();

        System.out.println("Insira seu email: ");
        String email = scan.nextLine();
        verificacaoEmail(email);

        System.out.println("Insira sua senha: ");
        String senha = scan.nextLine();

        System.out.println("Insira seu CPF: ");
        String cpf = scan.nextLine();
        verificacaoCPF(cpf);

        System.out.println("Insira seu telefone");
        String telefone = scan.nextLine();
        verificacaoTelefone(telefone);

        System.out.println("Digite seu cargo: ");
        String cargo = scan.nextLine();

        System.out.println("Digite seu salario: ");
        double salario = scan.nextDouble();

        listaAdminsCadastrados.add(new Administrador(nome, email, senha, cpf, telefone, cargo, salario ));
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
