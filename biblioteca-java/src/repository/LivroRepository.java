package repository;

import model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroRepository {

    private List<Livro> livros = new ArrayList<>();
    private int proximoId = 1;

    public Livro salvar(String titulo, String autor, String descricao){
        Livro livro = new Livro(proximoId, titulo, autor, false, descricao);
        livros.add(livro);
        return livro;
    }

    public List<Livro> mostrarLivros(){
        return livros;
    }

    public Livro buscarPorId(int id){
        return livros.stream().filter(l -> l.getId() == id).findFirst().orElse(null);
    }

    public boolean atualizarLivro(int id, String titulo, String autor, String descricao){
        Livro livro = buscarPorId(id);
        if (livro == null){
            return false;
        }
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setDescricao(descricao);
        return true;
    }

    public boolean deletarLivro(int id){
        Livro livro = buscarPorId(id);
        if (livro == null){
            return false;
        }
        livros.remove(livro);
        return true;
    }
}
