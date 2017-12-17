package faith.elguadia.ds.command;

import faith.elguadia.ds.commandmeta.abs.Command;
import faith.elguadia.ds.commandmeta.abs.CommandContext;

import javax.annotation.Nonnull;

public class testCommand extends Command {
    protected testCommand(@Nonnull String name, String... aliases) {
        super(name, aliases);
    }

    @Override
    public void onInvoke(@Nonnull CommandContext context) {

    }
}
