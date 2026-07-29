package org.example.os.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;



public class Directory implements FileSystemNode{
    private String name;
    private final Map<String, FileSystemNode> children = new HashMap<>();

    public Directory(String name) {
        this.name = name;
    }

    public Directory() { }

    // Setters & getters
    public void setName(String name) { this.name = name; }

    @Override
    public Optional<String> getName() { return Optional.ofNullable(this.name); }

    // Composite methods
    public void addChild(String name, FileSystemNode fileSystemNode){
        this.children.put(name, fileSystemNode);
    }

    public Optional<FileSystemNode> getChild(String name){
        return Optional.ofNullable(children.get(name));
    }

    public Map<String, FileSystemNode> getChildren(){ return children; }
}
