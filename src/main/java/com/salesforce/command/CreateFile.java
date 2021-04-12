package com.salesforce.command;

import com.salesforce.exception.InvalidCommandException;

public class CreateFile implements ExecutableCommand {
    @Override
    public void isWellformed(String wholeCommand) throws InvalidCommandException {
        String[] tokens = wholeCommand.split(" ");
        if (tokens.length != 3) {
            throw new InvalidCommandException("Invalid Command");
        }
        if (!tokens[1].equalsIgnoreCase(">") || tokens[2].length() > 100) {
            throw new InvalidCommandException("Invalid Command");
        }
    }
}
