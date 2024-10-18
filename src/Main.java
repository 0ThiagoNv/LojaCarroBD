import Entidades.Automovel;
import Entidades.Cliente;
import Entidades.Funcionario;

import static Entidades.Automovel.listaAutomoveis;
import static Entidades.Cliente.listaClientesCadastrados;
import static Entidades.Funcionario.listaFuncionariosCadastrados;
import static Menus.MenusConcessionaria.menuPrincipal;

public class Main {
    public static void main(String[] args) {
        listaAutomoveis.add(new Automovel("bmw", "123", true,
                "ABC1X34",100000));

        listaClientesCadastrados.add(new Cliente("will",
                "w@gmail.com", "123", "12345678990",
                "996972106", "aaaaaaaaaaaa"));

        listaFuncionariosCadastrados.add(new Funcionario("william@gmail.com", "12345",
                "12345678980", "William", "997968090",
                "GERENTE", 10000));
        while (true){
            menuPrincipal();
        }
    }
}