package faith.elguadia.ds.commandmeta;

import faith.elguadia.ds.commandmeta.abs.Command;

import java.util.HashMap;

public class CommandRegistry {
    private static HashMap<String,CommandEntry> registry = new HashMap<>();



    public static class CommandEntry {

        public Command command;
        public String name;

        CommandEntry(Command command, String name) {
            this.command = command;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setCommand(Command command) {
            this.command = command;
        }
    }
}

