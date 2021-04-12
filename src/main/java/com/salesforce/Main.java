package com.salesforce;

import com.salesforce.command.*;
import com.salesforce.exception.InvalidCommandException;
import com.salesforce.exception.UnrecognizedCommand;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static BufferedWriter p_stdin;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String nextCommand;
        List<String> allCommands = new ArrayList<>();

        while (!(nextCommand = scanner.nextLine()).equalsIgnoreCase(Command.QUIT_COMMAND.getName())) {
            allCommands.add(nextCommand);
        }

        scanner.close();
        selectCommand(allCommands);
    }


    private static void selectCommand(List<String> allCommands) {
        System.out.println(allCommands);
        // init shell
        ProcessBuilder builder = new ProcessBuilder("cmd.exe");
        Process cmd = null;
        try {
            cmd = builder.inheritIO().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //get stdin of shell
        p_stdin = new BufferedWriter(new OutputStreamWriter(cmd.getOutputStream()));

        // execute commands
        for (String command : allCommands) {
            try {
                validateCommand(command);
                executeCommand(command);
            } catch (InvalidCommandException | UnrecognizedCommand e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void executeCommand(String command) {
        try {
            // single execution
            p_stdin.write(command);
            p_stdin.newLine();
            p_stdin.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void validateCommand(String command) throws InvalidCommandException, UnrecognizedCommand {
        Command commandName = Command.findByName(command.split(" ")[0]);
        switch (commandName) {
            case PWD_COMMAND:
                PresentWorkingDirectory pwd = new PresentWorkingDirectory();
                pwd.isWellformed(command);
                break;
            case LS_COMMAND:
                ListContent ls = new ListContent();
                ls.isWellformed(command);
                break;
            case MKDIR_COMMAND:
                MakeDirectory mkdir = new MakeDirectory();
                mkdir.isWellformed(command);
                break;
            case CD_COMMAND:
                ChangeDirectory cd = new ChangeDirectory();
                cd.isWellformed(command);
                break;
            case TOUCH_COMMAND:
                CreateFile touch = new CreateFile();
                touch.isWellformed(command);
                break;
            default:
                throw new UnrecognizedCommand("Unrecognized command");
        }
    }
}
