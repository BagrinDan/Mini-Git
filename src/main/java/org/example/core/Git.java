package org.example.core;

import org.example.commands.GitCommand;
import org.example.core.storage.CommandsRepository;
import org.example.core.storage.CommandsRepositoryImpl;

import java.util.Scanner;




public class Git {
    private final Scanner sc;
    private final CommandsRepository repo;
    private final GitCommandValidator validator;

    public Git(){
        this.sc = new Scanner(System.in);
        this.repo = new CommandsRepositoryImpl();
        this.validator = new GitCommandValidatorImpl(repo);
    }

    public void exec(){
        System.out.println("mini-git: 0.1\n");
        while(true){
            System.out.print(">");
            String userInput = sc.nextLine();

            // Checking command
            ValidationResult result = this.validator.validateCommand(userInput);
            switch (result){
                case ValidationResult.Error e -> System.out.println(e.message());
                case ValidationResult.Success s -> {

                    String[] parts = userInput.trim().split("\\s+");
                    if (parts.length == 0) continue;

                    String commandName = parts[0];
                    String[] args = java.util.Arrays.copyOfRange(parts, 1, parts.length);

                    GitCommand command = repo.getCommands().get(commandName);
                    if (command != null) {
                        command.execute(args);
                    }
                }
            }
        }
    }
}
