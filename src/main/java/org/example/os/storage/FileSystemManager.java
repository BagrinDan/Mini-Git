package org.example.os.storage;


import java.util.Optional;

public class FileSystemManager {
    private Directory currDir;

    public FileSystemManager() {
        currDir = initDirectories();
    }

    public Directory initDirectories() {
        Directory root = new Directory("/");
        Directory home = new Directory("home/");
        Directory user = new Directory("user/");

        home.addChild("user/", user);
        root.addChild("home/", home);

        return user;
    }

    public Directory getCurrDir() {
        return currDir;
    }

    public boolean changeDirectory(String name) {
        Optional<FileSystemNode> target = currDir.getChild(name);

        if (target.isPresent() && target.get() instanceof Directory) {
            currDir = (Directory) target.get();
            return true;
        }
        return false;
    }

    public boolean changeDirectoryUp() {
        return false;
    }
}