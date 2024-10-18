package Entidades;

import java.util.ArrayList;

public class Funcionario extends Usuario {
    private String cargo;
    private double salario;
    private Integer id;
    private static Integer contadorId = 1;

    public static ArrayList<Funcionario> listaFuncionariosCadastrados = new ArrayList<>();

    public Funcionario(String nome, String cpf, String telefone, String cargo, double salario) {
        super(nome, cpf, telefone);
        this.cargo = cargo;
        this.salario = salario;
        this.id = contadorId++;
    }

    public Funcionario(String email, String senha, String cpf, String nome, String telefone, String cargo, double salario) {
        super(email, senha, cpf, nome, telefone);
        this.cargo = cargo;
        this.salario = salario;
        this.id = contadorId++;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static ArrayList<Funcionario> getListaFuncionariosCadastrados() {
        return listaFuncionariosCadastrados;
    }

    public static void setListaFuncionariosCadastrados(ArrayList<Funcionario> listaFuncionariosCadastrados) {
        Funcionario.listaFuncionariosCadastrados = listaFuncionariosCadastrados;
    }

    public String toString() {
        return "-----------------" +
                "\n Nome: " + getNome() +
                "\n ID: "+ getId() +
                "\n CPF: " + getCpf() +
                "\n Telefone: " + getTelefone() +
                "\n Cargo: " + getCargo() +
                "\n Salario: " + getSalario() +
                "\n-----------------";
        }
    }
