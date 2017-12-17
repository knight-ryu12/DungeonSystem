package faith.elguadia.ds.commandmeta.abs;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

import javax.annotation.Nonnull;

public class CommandContext {
    //@formatter:off
    @Nonnull public final Guild guild;
    @Nonnull public final TextChannel channel;
    @Nonnull public final Member invoker;
    @Nonnull public final Message msg;

    private CommandContext(@Nonnull Guild guild, @Nonnull TextChannel channel, @Nonnull Member invoker, @Nonnull Message message) {
        this.guild = guild;
        this.channel = channel;
        this.invoker = invoker;
        this.msg = message;
    }
}
