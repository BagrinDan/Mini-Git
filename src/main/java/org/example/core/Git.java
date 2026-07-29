package org.example.core;

import org.example.commands.GitCommand;
import org.example.core.storage.CommandsRepository;
import org.example.core.storage.CommandsRepositoryImpl;
import org.example.os.storage.FileSystemNode;

import java.util.Scanner;



public class Git {
    private final Scanner sc;
    private final CommandsRepository repo;
    private final GitCommandValidator validator;
    private final FileSystemNode node;

    public Git(FileSystemNode node){
        this.sc = new Scanner(System.in);
        this.repo = new CommandsRepositoryImpl();
        this.validator = new GitCommandValidatorImpl(repo);
        this.node = node;
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
                    s.commandName().execute(node, s.args());
                }
            }
        }
    }
}
