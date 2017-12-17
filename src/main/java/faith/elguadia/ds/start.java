package faith.elguadia.ds;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class start {
    private static final Logger log = LoggerFactory.getLogger(start.class);
    static JDA jda;

    public static void main(String[] args) throws LoginException, RateLimitedException {
        Runtime.getRuntime().addShutdownHook(new Thread(ON_SHUTDOWN,"shutdownHook"));
        log.info(getInfo());
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

    private static String getInfo() {
        return "\n\n" +
                "/$$$$$$$                                                             \n" +
                "| $$__  $$                                                            \n" +
                "| $$  \\ $$ /$$   /$$ /$$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$$ \n" +
                "| $$  | $$| $$  | $$| $$__  $$ /$$__  $$ /$$__  $$ /$$__  $$| $$__  $$\n" +
                "| $$  | $$| $$  | $$| $$  \\ $$| $$  \\ $$| $$$$$$$$| $$  \\ $$| $$  \\ $$\n" +
                "| $$  | $$| $$  | $$| $$  | $$| $$  | $$| $$_____/| $$  | $$| $$  | $$\n" +
                "| $$$$$$$/|  $$$$$$/| $$  | $$|  $$$$$$$|  $$$$$$$|  $$$$$$/| $$  | $$\n" +
                "|_______/  \\______/ |__/  |__/ \\____  $$ \\_______/ \\______/ |__/  |__/\n" +
                "                               /$$  \\ $$                              \n" +
                "                              |  $$$$$$/                              \n" +
                "                               \\______/                               " +
                "\n";
    }
}
