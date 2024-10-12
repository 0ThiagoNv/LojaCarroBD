package Entidades;

import java.util.Scanner;

public class Cliente extends Usuario {
    Scanner scan = new Scanner(System.in);

    private String endereco;

    public Cliente(String email, String senha) {
        super(email, senha);
    }
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
