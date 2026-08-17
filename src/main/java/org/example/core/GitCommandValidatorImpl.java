package org.example.core;

import org.example.commands.GitCommand;
import org.example.core.storage.CommandsRepository;
import org.example.os.storage.Directory;
import org.example.os.storage.FileSystemNode;
import java.util.Arrays;
import java.util.Optional;



public class GitCommandValidatorImpl implements GitCommandValidator{
    private final CommandsRepository repo;
    private final FileSystemNode node;

    public GitCommandValidatorImpl(CommandsRepository repo,
                                   FileSystemNode node){
        this.repo = repo;
        this.node = node;
    }

    public ValidationResult validateCommand(String userInput){
        String[] parts = userInput.split("\\s+");

        String gitCheck = parts[0];
        if(!gitCheck.equals("git") && this.isGitInit()){
            return new ValidationResult.Error("bash: command git not found");
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

    private boolean isGitInit() {
        Optional<FileSystemNode> gitNode = this.node.getChild(".git");
        return gitNode.isPresent() && gitNode.get() instanceof Directory;
    }
}
