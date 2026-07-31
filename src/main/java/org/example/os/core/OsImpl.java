package org.example.os.core;

import org.example.os.storage.Directory;
import org.example.os.storage.FileSystemManager;


public class OsImpl implements OS{
    private final FileSystemManager manager;

    public OsImpl() {
        manager = new FileSystemManager();
    }

    public void osBoot(){
        System.out.println("Booting mini os :)");
        Directory currDir = manager.initDirectories();
    }
}
