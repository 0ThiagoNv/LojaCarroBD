public class Administrador extends Usuario{
    private double salario;
    private String cargo;

    public Administrador(String email, String senha) {
        super(email, senha);
    }
    public Administrador(String email, String senha, String cpf, String id, String nome,
                         String telefone, String cargo, double salario, boolean adm) {
        super(email, senha, cpf, id, nome, telefone, adm);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    private void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    private void setSalario(double salario) {
        this.salario = salario;
    }

    public void menuAdmin(){

    }
}
