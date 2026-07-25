package service;

import model.Livro;
import repository.LivroRepository;

import java.util.List;

public class LivroService {
    private LivroRepository livroRepository = new LivroRepository();

    public Livro cadastrarLivro(String titulo, String autor, String descricao){
        if (titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }
        if (autor == null || autor.isBlank()){
            throw new IllegalArgumentException("O autor não pode ser vazio.");
        }
        return livroRepository.salvar(titulo, autor, descricao);
    }

    public List<Livro> listarLivros(){
        return livroRepository.mostrarLivros();
    }

    public boolean editarLivro(int idLivro, String titulo, String autor, String descricao){
        return livroRepository.atualizarLivro(idLivro, titulo, autor, descricao);
    }

    public boolean removerLivro(int idLivro){
        return livroRepository.deletarLivro(idLivro);
    }
}
