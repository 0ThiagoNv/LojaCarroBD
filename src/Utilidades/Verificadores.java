package Utilidades;

import java.util.Scanner;

public class Verificadores {
    static Scanner scan = new Scanner(System.in);

    public static void verificacaoCPF(String cpf){
        String cpfRegex = "\\d{3}\\d{3}\\d{3}\\d{2}";

        while(!cpf.matches(cpfRegex)) {
            System.out.println("CPF no formato incorreto, digite novamente: ");
            cpf = scan.nextLine();
        }
    }
    public static void verificacaoTelefone(String telefone){
        String telefoneRegex = "9\\d{4}\\d{4}";

        while(!telefone.matches(telefoneRegex)) {
            System.out.println("Telefone no formato incorreto, digite novamente: ");
            telefone = scan.nextLine();
        }
    }

    public static void verificacaoEmail(String email){
        String emailRegex = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,}$";

        while(!email.matches(emailRegex)){
            System.out.println("Digite novamente, o email não está no formato correto");
            email = scan.nextLine();
        }
    }
    public static void verificacaoAdminOuCliente(){

    }
}