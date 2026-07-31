import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {
    private int id;
    private String nome;
    private LocalDateTime data;
    private String descricao;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Evento(int id, String nome, LocalDateTime data, String descricao) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "ID Evento: " + id
                + "\nNome do evento: " + nome
                + "\nData e hora do evento: " + data.format(formatter)
                + "\nDescricao do evento: " + descricao
                + "\n";
    }
}
