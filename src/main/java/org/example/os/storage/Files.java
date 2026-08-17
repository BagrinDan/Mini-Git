package org.example.os.storage;



import java.util.Map;
import java.util.Optional;

public class Files implements FileSystemNode{
    private String name;
    private String context;

    public Files() { }

    @Override
    public Optional<String> getName() {
        return Optional.ofNullable(this.name);
    }

    @Override
    public Optional<FileSystemNode> getChild(String name) { return Optional.empty(); }

    @Override
    public Map<String, FileSystemNode> getChildren() { return Map.of(); }

    public void setName(String name){
        this.name = name;
    }

    public void setContext(String context){
        this.context = context;
    }

    // Context can be null, so to make sure that NPE is not breathing on our neck
    // we return context in Optional
    public Optional<String> getContext(){
        return Optional.ofNullable(this.context);
    }
}
