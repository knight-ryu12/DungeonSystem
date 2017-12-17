package faith.elguadia.ds.commandmeta.abs;

import javax.annotation.Nonnull;

public interface ICommand {
    void onInvoke(@Nonnull CommandContext context);

}
