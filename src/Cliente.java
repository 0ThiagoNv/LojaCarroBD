import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario{
    Scanner scan = new Scanner(System.in);

    private String endereco;

    public Cliente(String email, String senha, String cpf, String id,
                   String nome, String telefone, String endereco, boolean adm) {

        super(email, senha, cpf, id, nome, telefone, adm);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void menuClienteInicio() {
        System.out.println("------------------");
        System.out.println("1- Exibir Automóveis");
        System.out.println("2- Comprar automóvel");
        System.out.println("3- Sair do programa");
        System.out.println("------------------");
    }
    public void menuClienteExibirAutomoveis(ArrayList<Automovel> listaAutomoveis){
        for(Automovel veiculo : listaAutomoveis){
            System.out.println(veiculo);
        }
        menuClienteInicio();
    }
    public void menuClienteComprarAutomovel(ArrayList<Automovel> listaAutomoveis){
        System.out.println("Digite o chassi do automovel que deseja comprar");
        String chassiVeiculoComprado = scan.nextLine();
        for(Automovel veiculoComprado : listaAutomoveis){
            if(veiculoComprado.getChassi().equals(chassiVeiculoComprado)){
                System.out.println("-----------------");
                System.out.println(veiculoComprado);
                System.out.println("1- confirmar compra");
                System.out.println("2- voltar");
                System.out.println("-----------------");
                int escolha = scan.nextInt();
                while(escolha > 2 && escolha < 1){
                    System.out.println("Digite novamente, apenas 1 ou 2");
                    escolha = scan.nextInt();
                }
                if(escolha == 1){
                    listaAutomoveis.remove(veiculoComprado);
                    System.out.println("Compra efetuada com sucesso");
                } else if (escolha == 2) {
                    menuClienteInicio();
                }
            }
        }
    }
}
