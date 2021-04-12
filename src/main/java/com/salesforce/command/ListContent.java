package com.salesforce.command;

import com.salesforce.exception.InvalidCommandException;

public class ListContent implements ExecutableCommand {
    @Override
    public void isWellformed(String wholeCommand) throws InvalidCommandException {
        String[] tokens = wholeCommand.split(" ");
        if ((tokens.length == 2 && !validSecondParam(tokens[1])) || tokens.length > 2) {
            throw new InvalidCommandException("Invalid Command");
        }
    }

    private boolean validSecondParam(String secondParam) {
        return !secondParam.startsWith("/") || (secondParam.startsWith("/") && secondParam.equalsIgnoreCase("/s"));
    }
}
