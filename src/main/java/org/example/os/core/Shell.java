package org.example.os.core;

import org.example.os.storage.Directory;
import org.example.os.storage.FileSystemManager;
import org.example.os.storage.FileSystemNode;

import java.util.Map;


public class Shell {
    private final FileSystemNode node;
    private final FileSystemManager manager;

    public Shell(){
        node = new Directory();
        manager = new FileSystemManager();
    }

    public Map<String, FileSystemNode> ls(){
        return node.getChildren();
    }

    public void cd(String dir) {
        boolean success = manager.changeDirectory(dir);
        if (!success) {
            System.out.println("cd: no such file or directory: " + dir);
        }
    }

    public void cdDDot() {
        boolean success = manager.changeDirectoryUp();
        if (!success) {
            System.out.println("cd: already at root or parent not found");
        }
    }
}
