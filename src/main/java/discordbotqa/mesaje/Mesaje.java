package discordbotqa.mesaje;

import discordbotqa.intrebari.ManagerIntrebari;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.exception.MissingPermissionsException;
import org.javacord.api.util.logging.ExceptionLogger;

import java.awt.*;

public class Mesaje {
    public static void intrebareNegasita(MessageCreateEvent event) {
        EmbedBuilder mesaj = new EmbedBuilder()
                .addField("Eroare!", "Nu ai cerut o intrebare!!", false);
        event.getChannel().sendMessage(mesaj)
                .exceptionally(ExceptionLogger.get(MissingPermissionsException.class));
    }

    public static void intrebareGasita(MessageCreateEvent event) {
        EmbedBuilder message = new EmbedBuilder()
                .addField("Ai deja o intrebare!", "Te rog completeaza intrebarea pe care o ai!", false)
                .addField("Intrebarea: ", ManagerIntrebari.utilizatori.get(event.getMessageAuthor().getId()).getIntrebare(), true)
                .addField("Raspunde cu: ", "Adevarat sau Fals", true);
        ;
        event.getChannel().sendMessage(message)
                .exceptionally(ExceptionLogger.get(MissingPermissionsException.class));
    }

    public static void raspunsCorect(MessageCreateEvent event) {
        EmbedBuilder message = new EmbedBuilder()
                .addField("Felicitari!", "Raspunsul tau a fost corect!", false)
                .setColor(Color.green);
        event.getChannel().sendMessage(message)
                .exceptionally(ExceptionLogger.get(MissingPermissionsException.class));
    }

    public static void raspunsGresit(MessageCreateEvent event) {
        EmbedBuilder message = new EmbedBuilder()
                .addField("Din pacate..", "Raspunsul tau a fost gresit!", false)
                .setColor(Color.red);
        event.getChannel().sendMessage(message)
                .exceptionally(ExceptionLogger.get(MissingPermissionsException.class));
    }

}
