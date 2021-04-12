package com.salesforce.command;

import com.salesforce.exception.InvalidCommandException;

public class ChangeDirectory implements ExecutableCommand {
    @Override
    public void isWellformed(String wholeCommand) throws InvalidCommandException {
        if (wholeCommand.split(" ").length > 2) {
            throw new InvalidCommandException("Invalid Command");
        }
    }
}
