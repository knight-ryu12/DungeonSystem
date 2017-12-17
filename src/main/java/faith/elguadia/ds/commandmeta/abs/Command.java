package faith.elguadia.ds.commandmeta.abs;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

public class Command implements ICommand {

    public final String name;
    public final List<String> aliases;

    protected Command(@Nonnull String name, String... aliases) {
        this.name = name;
        this.aliases = Arrays.asList(aliases);
    }

}
