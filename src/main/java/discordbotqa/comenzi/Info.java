package discordbotqa.comenzi;

import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.exception.MissingPermissionsException;
import org.javacord.api.util.logging.ExceptionLogger;

public class Info implements CreatorComenzi {
    @Override
    public void execCmd(MessageCreateEvent mcv) {
        MessageAuthor autor = mcv.getMessage().getAuthor();
        EmbedBuilder mesaj = new EmbedBuilder().setTitle(autor.getDisplayName() + "' Informatii").addField("ID Discord", autor.getIdAsString(), true).addField("Nume discord", autor.getDiscriminatedName(), true).addField("Nume", autor.getDisplayName(), true).setAuthor(autor);
        mcv.getChannel().sendMessage(mesaj).exceptionally(ExceptionLogger.get(MissingPermissionsException.class));
    }
}
