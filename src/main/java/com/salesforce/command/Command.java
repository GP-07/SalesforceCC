package com.salesforce.command;

import com.salesforce.exception.UnrecognizedCommand;

public enum Command {
    QUIT_COMMAND("quit"),
    PWD_COMMAND("cd"),
    LS_COMMAND("dir"),
    MKDIR_COMMAND("mkdir"),
    CD_COMMAND("chdir"),
    TOUCH_COMMAND("echo");

    private String name;

    Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Command findByName(String name) throws UnrecognizedCommand {
        for(Command c : values()) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        throw new UnrecognizedCommand("Unrecognized command");
    }
}
