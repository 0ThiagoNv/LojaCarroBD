package Entidades;

import java.util.ArrayList;

public class Automovel {
    private String nome;
    private Integer id;
    private static Integer contadorId = 1;
    private double valor;
    private String chassi;
    private String placa;
    private boolean novo;

    public static ArrayList<Automovel> listaAutomoveis = new ArrayList<>();

    public Automovel(String nome,String chassi, boolean novo, String placa, double valor) {
        this.nome = nome;
        this.id = contadorId++;
        this.chassi = chassi;
        this.novo = novo;
        this.placa = placa;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNovo() {
        return novo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString(){
        return "-----------------"+
                "\n nome: "+ getNome() +
                "\n chassi: "+ getChassi() +
                "\n id: "+ getId() +
                "\n novo: "+ isNovo() +
                "\n placa: "+ getPlaca() +
                "\n valor: "+ getValor() +
                "\n-----------------";
    }
}
