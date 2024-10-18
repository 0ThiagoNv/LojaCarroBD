package Entidades;

import java.util.ArrayList;

public class Cliente extends Usuario {

    private String endereco;

    public static ArrayList<Cliente> listaClientesCadastrados = new ArrayList<>();

    public Cliente(String nome, String email, String senha,
                   String cpf, String telefone, String endereco) {

        super(email, senha, cpf, nome, telefone);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
