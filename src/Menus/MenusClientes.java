package Menus;

import Entidades.Automovel;
import Entidades.Cliente;
import Utilidades.UtilidadesAutomoveis;
import Utilidades.Verificadores;
import java.util.ArrayList;
import java.util.Scanner;

public class MenusClientes {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Cliente> listaClientesCadastrados = new ArrayList<>();

    public static void menuCadastroCliente(){
        System.out.println("Insira seu nome: ");
        String nome = scan.nextLine();
        System.out.println("Insira seu email: ");
        String email = scan.next();
        Verificadores.verificacaoEmail(email);
        System.out.println("Insira sua senha: ");
        scan.nextLine();
        String senha = scan.nextLine();
        System.out.println("Insira seu CPF: ");
        String cpf = scan.nextLine();
        Verificadores.verificacaoCPF(cpf);
        System.out.println("Insira seu telefone");
        String telefone = scan.nextLine();
        Verificadores.verificacaoTelefone(telefone);
        System.out.println("Insira seu endereço: ");
        String endereco = scan.nextLine();
        listaClientesCadastrados.add(new Cliente(nome, email, senha, cpf, telefone, endereco));

    }

    public static void menuClienteInicio() {
        System.out.println("------------------");
        System.out.println("1- Exibir Automóveis");
        System.out.println("2- Comprar automóvel");
        System.out.println("3- Sair do programa");
        System.out.println("------------------");
        int escolha = scan.nextInt();
        while(escolha != 1 && escolha != 2 && escolha != 3){
            System.out.println("Digite novamente, apenas 1, 2 ou 3");
            escolha = scan.nextInt();
        }
        if(escolha == 1){
            menuClienteExibirAutomoveis();
        } else if (escolha == 2) {
            menuClienteComprarAutomovel();
        }
        else if(escolha == 3) {
            return;
        }
    }
    public static void menuClienteExibirAutomoveis(){
        for(Automovel veiculo : UtilidadesAutomoveis.listaAutomoveis){
            System.out.println(veiculo);
        }
        menuClienteInicio();
    }
    public static void menuClienteComprarAutomovel(){
        Automovel a1 = new Automovel("1","1",true,"123456",200000);
        UtilidadesAutomoveis.listaAutomoveis.add(a1);

        System.out.println("Digite o chassi do automovel que deseja comprar");
        String chassiVeiculoComprado = scan.nextLine();
        for(Automovel veiculoComprado : UtilidadesAutomoveis.listaAutomoveis ){
            if(veiculoComprado.getChassi().equals(chassiVeiculoComprado)){
                System.out.println("-----------------");
                System.out.println(veiculoComprado);
                System.out.println("1- confirmar compra");
                System.out.println("2- voltar");
                System.out.println("-----------------");
                int escolha = scan.nextInt();
                while(escolha != 2 && escolha != 1){
                    System.out.println("Digite novamente, apenas 1 ou 2");
                    escolha = scan.nextInt();
                }
                if(escolha == 1){
                    UtilidadesAutomoveis.listaAutomoveis.remove(veiculoComprado);
                    System.out.println("Compra efetuada com sucesso");
                } else if (escolha == 2) {
                    menuClienteInicio();
                }
            }
        }
    }
}
