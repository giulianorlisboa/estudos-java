import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GerenciadorDeEventos {
    private List<Evento> eventos = new ArrayList<>();
    private int proximoId = 1;

    public void adicionarEvento(String nome, LocalDateTime data, String descricaoEvento) {
        Evento e = new Evento(proximoId, nome, data, descricaoEvento);
        eventos.add(e);
        proximoId++;
    }

    public void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento encontrado!\n");
        }
        for (Evento e : eventos) {
            System.out.println(e);
        }
    }

    public void removerEvento(int id) {
        eventos.removeIf(e -> e.getId() == id);
    }

    public void exibirEventosFuturos() {
        List<Evento> eventosOrdenados = eventos.stream()
                .filter(e -> e.getData().isAfter(LocalDateTime.now()))
                .sorted(Comparator.comparing(Evento::getData))
                .toList();

        if (eventosOrdenados.isEmpty()) {
            System.out.println("Nenhum evento futuro encontrado!\n");
            return;
        }
        System.out.println("Eventos futuros encontrados:");
        for (Evento e : eventosOrdenados) {
            System.out.println(e);
        }
    }
}
