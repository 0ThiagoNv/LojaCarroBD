package Entidades;

public class Automovel {
    private String nome;
    private Integer id;
    private static Integer contadorId = 1;
    private double valor;
    private String chassi;
    private String placa;
    private boolean novo;

<<<<<<< HEAD
    public static ArrayList<Automovel> listaAutomoveis = new ArrayList<>();

    public Automovel(String nome,String chassi, boolean novo, String placa, double valor) {
=======
    public Automovel(String nome, String chassi, String id, boolean novo, String placa, double valor) {
>>>>>>> ccf2626ae69e2ace3af7b80751fc5483795e2cb5
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

<<<<<<< HEAD
    public String toString(){
        return "-----------------"+
                "\n nome: "+ getNome() +
                "\n chassi: "+ getChassi() +
                "\n id: "+ getId() +
                "\n novo: "+ isNovo() +
                "\n placa: "+ getPlaca() +
                "\n valor: "+ getValor() +
                "\n-----------------";
=======
    public String toString() {
        return "Nome: " + nome + ", ID: " + id + ", Chassi: " + chassi +
                ", Placa: " + placa + ", Valor: " + valor +
                ", Novo: " + (novo ? "Sim" : "Não");
>>>>>>> ccf2626ae69e2ace3af7b80751fc5483795e2cb5
    }
}
