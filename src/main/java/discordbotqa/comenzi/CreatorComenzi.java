package discordbotqa.comenzi;

import org.javacord.api.event.message.MessageCreateEvent;

@FunctionalInterface
public interface CreatorComenzi {
    void execCmd(MessageCreateEvent mcv);
}
