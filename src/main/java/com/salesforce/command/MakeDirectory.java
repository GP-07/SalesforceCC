package com.salesforce.command;

import com.salesforce.exception.InvalidCommandException;

public class MakeDirectory implements ExecutableCommand{
    @Override
    public void isWellformed(String wholeCommand) throws InvalidCommandException {
        String[] tokens = wholeCommand.split(" ");
        if (tokens.length == 2 && tokens[1].length() > 100) {
            throw new InvalidCommandException("Invalid Command");
        }
    }
}
