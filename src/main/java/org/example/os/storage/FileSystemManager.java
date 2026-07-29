package org.example.os.storage;

public class FileSystemManager {
    public static Directory initBaseDirectory(){
        Directory root = new Directory("/");
        Directory home = new Directory("home");
        Directory user = new Directory("user");

        home.addChild("user", user);
        root.addChild("home", home);

        return root;
    }
}
