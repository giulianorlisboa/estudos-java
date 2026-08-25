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

    public void alterarNome(String documento, String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Fisica pf && pf.getCpf().equals(documento)) {
                pf.setNome(nome);
                System.out.println("Cadastro alterado com sucesso!");
                System.out.println(pf);
                return;
            } else if (pessoa instanceof Juridica pj && pj.getCnpj().equals(documento)) {
                pj.setNome(nome);
                System.out.println("Cadastro alterado com sucesso!");
                System.out.println(pj);
                return;
            }
            System.out.println("Nenhum cadastro foi encontrado com o número de CPF ou CNPJ. " + documento);
        }
    }

    public void alterarEndereco(String documento, String endereco) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Fisica pf && pf.getCpf().equals(documento)) {
                System.out.println("Insira o novo endereço: ");
                pf.setEndereco(endereco);
            }
        }
    }

    public void remover(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }

}
