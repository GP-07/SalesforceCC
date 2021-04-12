package com.salesforce.command;

import com.salesforce.exception.InvalidCommandException;

public interface ExecutableCommand {
    void isWellformed(String wholeCommand) throws InvalidCommandException;
}
