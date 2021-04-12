package com.salesforce.command;

import com.salesforce.exception.InvalidCommandException;

public class PresentWorkingDirectory implements ExecutableCommand{
    @Override
    public void isWellformed(String wholeCommand) throws InvalidCommandException {
        if (wholeCommand.split(" ").length > 1) {
            throw new InvalidCommandException("Invalid Command");
        }
    }
}
