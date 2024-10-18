package Entidades;

import java.util.ArrayList;

public class Funcionario extends Usuario {
    private String cargo;
    private double salario;
<<<<<<< HEAD
    private Integer id;
    private static Integer contadorId = 1;
=======
    private static int contadorId = 1;
    private int id;
>>>>>>> ccf2626ae69e2ace3af7b80751fc5483795e2cb5

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

<<<<<<< HEAD
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
=======
    public int getId() {
        return id;
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
>>>>>>> ccf2626ae69e2ace3af7b80751fc5483795e2cb5

    public static ArrayList<Funcionario> getListaFuncionariosCadastrados() {
        return listaFuncionariosCadastrados;
    }

    public static void setListaFuncionariosCadastrados(ArrayList<Funcionario> listaFuncionariosCadastrados) {
        Funcionario.listaFuncionariosCadastrados = listaFuncionariosCadastrados;
    }

    public String toString() {
<<<<<<< HEAD
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
=======
        return "ID: " + id + ", Nome: " + getNome() + ", CPF: " + getCpf() + ", Telefone: " + getTelefone() +
                ", Cargo: " + cargo + ", Salário: " + salario;
    }
}
>>>>>>> ccf2626ae69e2ace3af7b80751fc5483795e2cb5
