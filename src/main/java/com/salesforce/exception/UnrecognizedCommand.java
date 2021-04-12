package com.salesforce.exception;

public class UnrecognizedCommand extends Exception {
    public UnrecognizedCommand(String message) {
        super(message);
    }
}
