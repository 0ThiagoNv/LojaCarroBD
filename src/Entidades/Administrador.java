package Entidades;

import java.util.Scanner;

public class Administrador extends Usuario {
    Scanner scan = new Scanner(System.in);

    private double salario;
    private String cargo;

    public Administrador(String email, String senha) {
        super(email, senha);
    }
    public Administrador(String nome, String email, String senha, String cpf,
                         String telefone, String cargo, double salario) {
        super(email, senha, cpf, nome, telefone);
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

}
