package org.example.core;


import org.example.commands.GitCommand;
import org.example.core.storage.CommandsRepository;

import java.util.Arrays;

public class GitCommandValidatorImpl implements GitCommandValidator{
    private final CommandsRepository repo;

    public GitCommandValidatorImpl(CommandsRepository repo){
        this.repo = repo;
    }

    public ValidationResult validateCommand(String userInput){
        String[] parts = userInput.split("\\s+");

        String gitCheck = parts[0];
        if(!gitCheck.equals("git")){
            return new ValidationResult.Error("error: not a git command");
        }

        String commandName = parts[1];

        GitCommand command = repo.findCommand(commandName);
        if(command == null){
            return new ValidationResult.Error("unknown command " + commandName);
        }

        String[] args = Arrays.copyOfRange(parts, 2, parts.length);
        Arrays.stream(args).forEach(System.out::println);

        return new ValidationResult.Success(command, args);
    }
}
