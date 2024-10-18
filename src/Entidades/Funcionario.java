package Entidades;

import java.util.ArrayList;

public class Funcionario extends Usuario {
    private String cargo;
    private double salario;

    public static ArrayList<Funcionario> listaFuncionariosCadastrados = new ArrayList<>();

    public Funcionario(String nome, String cpf, String telefone, String cargo, double salario) {
        super(nome, cpf, telefone);
        this.cargo = cargo;
        this.salario = salario;
    }

    public Funcionario(String email, String senha, String cpf, String nome, String telefone, String cargo, double salario) {
        super(email, senha, cpf, nome, telefone);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() { return cargo; }

    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalario() { return salario; }

    public void setSalario(double salario) { this.salario = salario; }

    public static ArrayList<Funcionario> getListaFuncionariosCadastrados() {
        return listaFuncionariosCadastrados;
    }

    public static void setListaFuncionariosCadastrados(ArrayList<Funcionario> listaFuncionariosCadastrados) {
        Funcionario.listaFuncionariosCadastrados = listaFuncionariosCadastrados;
    }
}
