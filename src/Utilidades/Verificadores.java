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
        scan.close();
    }
    public static void verificacaoTelefone(String telefone){
        String telefoneRegex = "9\\d{4}\\d{4}";

        while(!telefone.matches(telefoneRegex)) {
            System.out.println("Telefone no formato incorreto, digite novamente: ");
            telefone = scan.nextLine();
        }
        scan.close();
    }

    public static void verificacaoEmail(String email){
        String emailRegex = "^[\\w-.]+@[\\w-.]+\\.[a-zA-Z]{2,}$";

        while(!email.matches(emailRegex)){
            System.out.println("Digite novamente, o email não está no formato correto");
            email = scan.nextLine();
        }
        scan.close();
    }
    public static char verificacaoAdminOuCliente(){

        System.out.println("Você é admin ou cliente?");
        System.out.println("Digite 'c' se for cliente e digite 'a' se for admin");
        String adminOuCliente = scan.nextLine();
        char verificacaoAdminOuCliente = adminOuCliente.charAt(0);

        while (verificacaoAdminOuCliente != 'c' && verificacaoAdminOuCliente != 'a'){
            System.out.println("Entrada inválida! Digite novamente, apenas 'c' ou 'a'.");
            adminOuCliente = scan.nextLine();
            verificacaoAdminOuCliente = adminOuCliente.charAt(0);
        }

        return verificacaoAdminOuCliente;
    }
}
