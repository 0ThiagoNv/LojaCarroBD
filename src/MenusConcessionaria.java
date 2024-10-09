import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenusConcessionaria {
    static Scanner scan = new Scanner(System.in);

    static ArrayList<Usuario> listaUsuariosCadastrados = new ArrayList<>();

    public static void verificacaoEmail(String email){
        Pattern procurarDigitos = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher validarTexto = procurarDigitos.matcher(email);
        boolean validacaoEmail = validarTexto.matches();
        while(!validacaoEmail){
            System.out.println("Digite novamente, o email não está no formato correto");
            email = scan.nextLine();
        }
        if(validacaoEmail){

        }
    }

    static Menus menusConcessionaria = new Menus() {
        public void menuPrincipal() {
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
            } else if (escolhaPrincipal == 2) {
                menuCadastro();
            } else if (escolhaPrincipal == 3) {
                Usuario usuarioCadastrado = null;
                System.out.println("Digite o email da sua conta");
                scan.nextLine();
                String emailEsqueceuSenha = scan.nextLine();
                verificacaoEmail(emailEsqueceuSenha);

                for (Usuario usuarioEsqueceuSenha : listaUsuariosCadastrados) {
                    if (usuarioEsqueceuSenha.getEmail().equals(emailEsqueceuSenha)) {
                        usuarioCadastrado = usuarioEsqueceuSenha;
                        break;
                    }
                }
                if (usuarioCadastrado != null) {
                    System.out.println("Digite sua nova senha: ");
                    String senhaNova = scan.nextLine();
                    usuarioCadastrado.alterarSenha(senhaNova);
                    System.out.println("Senha alterada com sucesso");
                } else {
                    System.out.println("Este email não está cadastrado");
                }
            }
        }

        public void menuEntrar() {
            System.out.println("Insira seu email: ");
            String email = scan.nextLine();
            verificacaoEmail(email);
            System.out.println("Insira sua senha: ");
            String senha = scan.nextLine();
            for (Usuario usuarioCadastrado : listaUsuariosCadastrados){
                if(usuarioCadastrado.getEmail().equals(email) &&
                        usuarioCadastrado.getSenha().equals(senha)){
                        if (usuarioCadastrado.isAdm() == true){

                        } else if (usuarioCadastrado.isAdm() == false) {

                        }
                }
            }
        }

        public void menuCadastro() {
            System.out.println("Insira seu nome: ");
            try {
                scan.nextLine();
                String nome = scan.nextLine();
            } catch (InputMismatchException apenasString){
                System.out.println("Digite apenas letras");
            }
            System.out.println("Insira seu email: ");
            String email = scan.nextLine();
            verificacaoEmail(email);

            System.out.println("Insira sua senha: ");
            String senha = scan.nextLine();

            System.out.println("Você é admin?");
            System.out.println("Digite true, se for");
            System.out.println("Digite false, se não for");
            try {
                boolean admin = scan.nextBoolean();
            }catch (InputMismatchException apenasBool){
                System.out.println("Digite novamente, apenas true ou false");
            }
        }
    };
}
