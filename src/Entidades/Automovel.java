package Entidades;

public class Automovel {
    private String nome;
    private String id;
    private double valor;
    private String chassi;
    private String placa;
    private boolean novo;

    public Automovel(String nome, String chassi, String id, boolean novo, String placa, double valor) {
        this.nome = nome;
        this.chassi = chassi;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String toString() {
        return "Nome: " + nome + ", ID: " + id + ", Chassi: " + chassi +
                ", Placa: " + placa + ", Valor: " + valor +
                ", Novo: " + (novo ? "Sim" : "Não");
    }
}
