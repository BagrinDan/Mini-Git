package org.example.os.core;

import org.example.os.storage.FileSystemManager;


public class OsImpl implements OS{

    public OsImpl() { }

    public void osBoot(){
        System.out.println("Booting mini os :)");
        FileSystemManager.initBaseDirectory();
    }
}
