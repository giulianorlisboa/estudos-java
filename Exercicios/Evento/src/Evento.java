import java.time.LocalDateTime;

public class Evento {
    private String nome;
    private LocalDateTime data;
    private String descricao;

    public Evento(String nome, LocalDateTime data, String descricao) {
        this.nome = nome;
        this.data = data;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Nome do evento: " + nome
                + "\nData do evento: " + data
                + "\nDescricao do evento: " + descricao;
    }
}
