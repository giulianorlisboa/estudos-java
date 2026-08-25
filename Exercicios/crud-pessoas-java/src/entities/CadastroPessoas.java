package entities;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas extends Pessoa {
    List<Pessoa> pessoas = new ArrayList<>();

    public void cadastrar(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void exibirPessoas() {
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
            System.out.println("____________________________________");
        }
    }

    public void remover(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }

}
