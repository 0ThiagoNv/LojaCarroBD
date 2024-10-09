import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Usuario> listaUsuariosCadastrados = new ArrayList<>();
    static MenusConcessionaria menus = new MenusConcessionaria();
    public static void main(String[] args) {
             MenusConcessionaria.menusConcessionaria.menuPrincipal();
    }
}