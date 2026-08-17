package org.example.os.storage;

import java.util.Map;
import java.util.Optional;

public interface FileSystemNode {
    Optional<String> getName();
    Optional<FileSystemNode> getChild(String name);
    Map<String, FileSystemNode> getChildren();
}
