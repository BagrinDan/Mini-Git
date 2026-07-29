package org.example.commands;

import org.example.os.storage.FileSystemNode;

public interface GitCommand { // Records
    void execute(FileSystemNode node, String[] args);
}
