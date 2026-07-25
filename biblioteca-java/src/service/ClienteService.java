package service;

import model.Cliente;
import repository.ClienteRepository;

public class ClienteService {
    private ClienteRepository clienteRepository = new ClienteRepository();

    public Cliente cadastrarCliente(String nome, int idade){
        if (nome == null || nome.equals("")){
            throw new IllegalArgumentException("O nome não pode estar em branco");
        }
        if (idade < 16 || idade > 100){
            throw new IllegalArgumentException("O cliente deve ter 16 anos ou mais.");
        }
        return clienteRepository.cadastrarCliente(nome, idade);
    }

    public Cliente buscarCliente(int id){
        return clienteRepository.buscarCliente(id);
    }

    public boolean removerCliente(int id){
        return clienteRepository.removerCliente(id);
    }

    public boolean editarCliente(int idCliente, String nome){
        return clienteRepository.atualizarNomeCliente(idCliente, nome);
    }
}
