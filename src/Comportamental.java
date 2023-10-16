import java.util.ArrayList;
import java.util.List;

/**
 * Padrão Comportamental Observer
 * @author brehs
 * 
 */

interface Observador {
    void atualizar(String evento);
}

class EmissorEventos {
    private List<Observador> observadores = new ArrayList<>();

    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void notificar(String evento) {
        for (Observador observador : observadores) {
            observador.atualizar(evento);
        }
    }
}

class ObservadorConcreto implements Observador {
    private String nome;

    public ObservadorConcreto(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String evento) {
        System.out.println(nome + " recebeu uma notificação: " + evento);
    }
}

public class Comportamental {
    public static void main(String[] args) {
        EmissorEventos emissor = new EmissorEventos();

        Observador observador1 = new ObservadorConcreto("Observador 1");
        Observador observador2 = new ObservadorConcreto("Observador 2");

        emissor.adicionarObservador(observador1);
        emissor.adicionarObservador(observador2);

        emissor.notificar("Evento 1");
        emissor.notificar("Evento 2");

        emissor.removerObservador(observador1);

        emissor.notificar("Evento 3");
    }
}
