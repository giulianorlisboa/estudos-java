import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeEventos {
    private List<Evento> eventos = new ArrayList<>();

    public void adicionarEvento(Evento e) {
        eventos.add(e);
    }
}
