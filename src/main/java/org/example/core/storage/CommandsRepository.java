package org.example.core.storage;

import org.example.commands.GitCommand;

import java.util.Map;

public interface CommandsRepository {
    Map<String, GitCommand> getCommands();
    GitCommand findCommand(String userPrompt);
    GitCommand getCommand(String command);
}
