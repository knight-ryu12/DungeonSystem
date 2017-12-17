package faith.elguadia.ds;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class start {
    static JDA jda;

    public static void main(String[] args) throws LoginException, RateLimitedException {
        Runtime.getRuntime().addShutdownHook(new Thread(ON_SHUTDOWN,"shutdownHook"));
        bootJDA();
    }

    private static void bootJDA() throws LoginException, RateLimitedException {
        JDABuilder jb = new JDABuilder(AccountType.BOT);
        jb.setToken(config.CONFIG.getBotToken());
        jb.setAudioEnabled(false);
        jb.setAutoReconnect(true);
        jb.setGame(Game.of(Game.GameType.DEFAULT,"Generating Dungeon"));
        jda = jb.buildAsync();
    }

    private static final Runnable ON_SHUTDOWN = () -> {
      jda.shutdownNow();
    };
}
