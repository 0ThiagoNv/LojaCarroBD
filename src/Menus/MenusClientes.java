package Menus;

import Entidades.Automovel;
import Entidades.Cliente;
import java.util.Scanner;

import static Entidades.Automovel.listaAutomoveis;
import static Entidades.Cliente.listaClientesCadastrados;
import static Menus.MenusConcessionaria.menuPrincipal;
import static Utilidades.Verificadores.*;

public class MenusClientes {
    static Scanner scan = new Scanner(System.in);

    public static void menuCadastroCliente(){
        System.out.println("Insira seu nome: ");
        String nome = scan.nextLine();

        System.out.println("Insira seu email: ");
        String email = scan.nextLine();
        email = verificacaoEmail(email);

        System.out.println("Insira sua senha: ");
        String senha = scan.nextLine();

        System.out.println("Insira seu CPF(xxxxxxxxxxx): ");
        String cpf = scan.nextLine();
        cpf = verificacaoCPF(cpf);

        System.out.println("Insira seu telefone(9xxxxxxxx): ");
        String telefone = scan.nextLine();
        telefone = verificacaoTelefone(telefone);

        System.out.println("Insira seu endereço: ");
        String endereco = scan.nextLine();

        listaClientesCadastrados.add(new Cliente(nome, email, senha,
                cpf, telefone, endereco));
    }

    public static void menuClienteInicio() {
        System.out.println("------------------");
        System.out.println("1- Exibir Automóveis");
        System.out.println("2- Comprar automóvel");
        System.out.println("3- Sair do programa");
        System.out.println("------------------");
        int escolha = scan.nextInt();
        while (escolha != 1 && escolha != 2 && escolha != 3) {
            System.out.println("Digite novamente, apenas 1, 2 ou 3");
            escolha = scan.nextInt();
        }
        switch (escolha) {
            case 1:
                menuClienteExibirAutomoveis();
                break;
            case 2:
                menuClienteComprarAutomovel();
                break;
            case 3:
                System.out.println("Saindo do programa...");
                menuPrincipal();
                break;
        }
    }
    public static void menuClienteExibirAutomoveis(){
        for(Automovel veiculo : listaAutomoveis){
            System.out.println(veiculo);
        }
        menuClienteInicio();
    }
    public static void menuClienteComprarAutomovel(){
        System.out.println("Digite o id do automovel que deseja comprar");
        Integer idVeiculoComprado = scan.nextInt();
        Automovel verificarChassi = null;
        for(Automovel veiculoComprado : listaAutomoveis ){
            if(veiculoComprado.getId().equals(idVeiculoComprado)){
                verificarChassi = veiculoComprado;
                break;
            }
        }
        if(verificarChassi != null){
            System.out.println("-----------------");
            System.out.println(verificarChassi);
            System.out.println("1- confirmar compra");
            System.out.println("2- voltar");
            System.out.println("-----------------");
            int escolha = scan.nextInt();
            while(escolha != 2 && escolha != 1){
                System.out.println("Digite novamente, apenas 1 ou 2");
                escolha = scan.nextInt();
            }
            switch (escolha){
                case 1:
                    listaAutomoveis.remove(verificarChassi);
                    System.out.println("Compra efetuada com sucesso");
                    break;
                case 2:
                    menuClienteInicio();
                    break;
            }
        } else{
            System.out.println("Chassi não encontrado");
        }
        menuClienteInicio();
    }
}
