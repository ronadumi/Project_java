package discordbotqa.intrebari;

import discordbotqa.mesaje.Mesaje;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ManagerIntrebari {
    private final ControlerIntrebari controlerIntrebari;
    static public List<EntitateIntrebari> intrebari;
    static public Map<Long, EntitateIntrebari> utilizatori = new HashMap<>();

    public ManagerIntrebari(ControlerIntrebari qc) {
        this.controlerIntrebari = qc;
    }

    @PostConstruct
    public void iaIntrebare() {
        intrebari = controlerIntrebari.listaIntrebari();
    }

    public static EntitateIntrebari intrebareLaIntamplare() {
        return intrebari.get(ThreadLocalRandom.current().nextInt(0, intrebari.size()));
    }

    public static void verificaRaspuns(MessageCreateEvent event, Boolean response) {
        long id = event.getMessageAuthor().getId();
        if (utilizatori.get(id).iaRaspuns().equals(response)) {
            Mesaje.raspunsCorect(event);
        } else {
            Mesaje.raspunsGresit(event);
        }
        ManagerIntrebari.utilizatori.remove(id);
    }
}
