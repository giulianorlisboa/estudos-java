package entities;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas extends Pessoa {
    List<Pessoa> pessoas = new ArrayList<>();

    public void cadastrar(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void exibirPessoas() {
        if (pessoas.isEmpty()) {
            IO.println("Nenhum cadastro foi encontrado!");
            IO.println();
        }else {
            for (Pessoa pessoa : pessoas) {
                System.out.println(pessoa);
                System.out.println("____________________________________");
            }
        }
    }

    public boolean verificarCpf(String documento) {
        int soma = 0;
//        verificação primeiro digito
        for (int i = 0; i <= 8; i++) {
            int numInt = Integer.parseInt(documento.substring(i, i + 1));
            soma += numInt * (10 - i);
        }
        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : 11 - resto;
//        verificação segundo digito
        soma = 0;
        for (int i = 0; i <= 9; i++) {
            int numInt = Integer.parseInt(documento.substring(i, i + 1));
            soma += numInt * (11 - i);
        }
        resto = soma % 11;
        int digito2 =  (resto < 2) ? 0 : 11 - resto;

        int digitoInformado1 = Integer.parseInt(documento.substring(9, 10));
        int digitoInformado2 = Integer.parseInt(documento.substring(10, 11));

        return digito1 == digitoInformado1 && digito2 == digitoInformado2;
    }

    public boolean verificarCnpj(String documento) {
        int[] pesos1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int soma = 0;
        for (int i = 0; i < 12; i++) {
            int numInt = Integer.parseInt(documento.substring(i, i + 1));
            soma += numInt * (pesos1[i]);
        }
        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : 11 - resto;

        soma = 0;
        for (int i = 0; i < 13; i++) {
            int numInt = Integer.parseInt(documento.substring(i, i + 1));
            soma+= numInt * (pesos2[i]);
        }
        resto = soma % 11;
        int digito2 =  (resto < 2) ? 0 : 11 - resto;

        int digitoInformado1 = Integer.parseInt(documento.substring(12, 13));
        int digitoInformado2 = Integer.parseInt(documento.substring(13, 14));

        return digito1 == digitoInformado1 && digito2 == digitoInformado2;
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
                System.out.println("Cadastro alterado com sucesso!");
                System.out.println(pf);
                pf.setEndereco(endereco);
                return;
            } else if (pessoa instanceof Juridica pj && pj.getCnpj().equals(documento)) {
                System.out.println("Cadastro alterado com sucesso!");
                System.out.println(pj);
                pj.setEndereco(endereco);
                return;
            }
            System.out.println("Nenhum cadastro foi encontrado com o número de CPF ou CNPJ." + documento);
        }
    }

    public void alterarTelefone(String documento, long telefone) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Fisica pf && pf.getCpf().equals(documento)) {
                System.out.println("Cadastro alterado com sucesso!");
                System.out.println(pf);
                pf.setTelefone(telefone);
                return;
            } else if (pessoa instanceof Juridica pj && pj.getCnpj().equals(documento)) {
                System.out.println("Cadastro alterado com sucesso!");
                System.out.println(pj);
                pj.setTelefone(telefone);
                return;
            }
            System.out.println("Nenhum cadastro foi encontrado com o número de CPF ou CNPJ." + documento);
        }
    }

    public void alterarEmail(String documento, String email) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Fisica pf && pf.getCpf().equals(documento)) {
                System.out.println("Cadastro alterado com sucesso!");
                System.out.println(pf);
                pf.setEmail(email);
                return;
            } else if (pessoa instanceof Fisica pj && pj.getCpf().equals(documento)) {
                System.out.println("Cadastro alterado com sucesso!");
                System.out.println(pj);
                pj.setEmail(email);
                return;
            }
        }
    }

    public void remover(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Fisica pf && pf.getNome().equalsIgnoreCase(nome)) {
                System.out.println(pf);
                pessoas.remove(pessoa);
                System.out.println("Removido com sucesso!");
                IO.println();
                return;
            }
        }
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Juridica pj && pj.getNome().equalsIgnoreCase(nome)) {
                System.out.println(pj);
                pessoas.remove(pessoa);
                System.out.println("Removido com sucesso!");
                IO.println();
                return;
            }
        }
        throw new RuntimeException("");
    }

}
