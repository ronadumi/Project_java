package discordbotqa.comenzi;

import discordbotqa.ManagerBot;
import org.javacord.api.event.message.MessageCreateEvent;

public class Invitatie implements CreatorComenzi {

    @Override
    public void execCmd(MessageCreateEvent ev) {
        ev.getChannel().sendMessage(ManagerBot.getInstance().getApi().createBotInvite());
    }
}
