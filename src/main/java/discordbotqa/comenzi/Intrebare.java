package discordbotqa.comenzi;


import discordbotqa.intrebari.EntitateIntrebari;
import discordbotqa.intrebari.ManagerIntrebari;
import discordbotqa.mesaje.Mesaje;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.exception.MissingPermissionsException;
import org.javacord.api.util.logging.ExceptionLogger;

public class Intrebare implements CreatorComenzi {

    @Override
    public void execCmd(MessageCreateEvent mcv) {
        if (ManagerIntrebari.utilizatori.containsKey(mcv.getMessageAuthor().getId())) {
            Mesaje.intrebareGasita(mcv);
        } else {
            EntitateIntrebari intrebare = ManagerIntrebari.intrebareLaIntamplare();
            EmbedBuilder mesaj = new EmbedBuilder()
                    .addField("Intrebare", intrebare.getIntrebare(), true)
                    .addField("Raspunde cu: ", "Adevarat sau Fals", true);
            mcv.getChannel().sendMessage(mesaj)
                    .exceptionally(ExceptionLogger.get(MissingPermissionsException.class));

            ManagerIntrebari.utilizatori.put(mcv.getMessageAuthor().getId(), intrebare);
        }
    }
}
