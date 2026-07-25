package repository;

import model.Cliente;

import java.util.ArrayList;

public class ClienteRepository {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    public Cliente cadastrarCliente(String nome, int idade){
        Cliente cliente = new Cliente(nome, proximoId++, idade);
        clientes.add(cliente);
        return cliente;
    }



    public Cliente buscarCliente(int id){
        return clientes.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean removerCliente(int id){
        return clientes.remove(buscarCliente(id));
    }

    public boolean atualizarNomeCliente(int id, String nome){
        Cliente cliente = buscarCliente(id);
        if (cliente == null){
            return false;
        }
        cliente.setNome(nome);
        return true;
    }
}
