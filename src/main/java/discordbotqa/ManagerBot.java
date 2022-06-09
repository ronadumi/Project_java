package discordbotqa;

import discordbotqa.comenzi.*;
import discordbotqa.mesaje.MesajeAscultatori;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;

public class ManagerBot {
    private DiscordApi api;
    public static ManagerBot instance;
    private static final Logger logger = LogManager.getLogger(ManagerBot.class);

    private ManagerBot() {
        String token = Utilitati.iaToken();
        if (token.isEmpty()) {
            System.out.println("Tokenul nu a fost setat!");
            System.exit(1);
        } else {
            api = new DiscordApiBuilder().setToken(token).login().join();
            api.addListener(new MesajeAscultatori());
            FallbackLoggerConfiguration.setDebug(true);
            FallbackLoggerConfiguration.setTrace(true);
            creazaComenzi();
            api.addServerJoinListener(event -> logger.info("S-a alaturat " + event.getServer().getName()));
            api.addServerLeaveListener(event -> logger.info("A iesit " + event.getServer().getName()));
        }
    }

    public static ManagerBot getInstance() {
        if (instance == null) {
            instance = new ManagerBot();
        }
        return instance;
    }

    public DiscordApi getApi() {
        return this.api;
    }

    public void creazaComenzi() {
        DiscordBotQaApplication.comenzi.put("!invitatie", new Invitatie());
        DiscordBotQaApplication.comenzi.put("!intrebare", new Intrebare());
        DiscordBotQaApplication.comenzi.put("!informatii", new Info());
    }
}