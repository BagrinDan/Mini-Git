package org.example;


import org.example.core.Git;
import org.example.os.core.OS;
import org.example.os.core.OsImpl;
import org.example.os.storage.Directory;
import org.example.os.storage.FileSystemNode;

public class Main{
    public static void main(String[] args) {
        OS operationalSystem = new OsImpl();
        FileSystemNode node = new Directory();
        operationalSystem.osBoot();

        Git git = new Git(node);
        git.exec();
    }
}