package org.example.commands;

import org.example.os.storage.Directory;
import org.example.os.storage.FileSystemNode;

public class Init implements GitCommand{
    @Override
    public void execute(FileSystemNode node, String[] args) {
        System.out.println("[*] Initializing empty Git repository...");

        if (node instanceof Directory currentDir) {

            if (currentDir.getChild(".git").isPresent()) {
                System.out.println("Reinitialized existing Git repository.");
                return;
            }

            Directory gitDir = new Directory(".git");
            currentDir.addChild(".git", gitDir);

            System.out.println("Initialized empty Git repository in .git/");
        } else {
            System.out.println("Error: Current node is not a directory.");
        }
    }
}
