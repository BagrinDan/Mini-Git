package org.example.core.storage;

import org.example.commands.Commit;
import org.example.commands.GitCommand;
import org.example.commands.Init;

import java.util.Map;

public class CommandsRepositoryImpl implements CommandsRepository {

    private final Map<String, GitCommand> commands = Map.of(
            "commit", new Commit(),
            "init", new Init()
    );

    public Map<String, GitCommand> getCommands(){
        return (commands);
    }

    public GitCommand getCommand(String command){
        return commands.get(command);
    }

    public GitCommand findCommand(String userPrompt){
        return commands.get(userPrompt);
    }
}
