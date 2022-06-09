package discordbotqa.mesaje;


import discordbotqa.DiscordBotQaApplication;
import discordbotqa.intrebari.ManagerIntrebari;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class MesajeAscultatori implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!adevarat") || event.getMessageContent().equalsIgnoreCase("!fals")) {
            if (ManagerIntrebari.utilizatori.containsKey(event.getMessageAuthor().getId())) {
                if (event.getMessageContent().equalsIgnoreCase("!adevarat")) {
                    ManagerIntrebari.verificaRaspuns(event, true);
                } else {
                    ManagerIntrebari.verificaRaspuns(event, false);
                }
            } else {
                Mesaje.intrebareNegasita(event);
            }
        } else {
            if (DiscordBotQaApplication.comenzi.containsKey(event.getMessageContent().split(" ")[0])) {
                DiscordBotQaApplication.comenzi.get(event.getMessageContent().split(" ")[0]).execCmd(event);
            }
        }
    }
}
