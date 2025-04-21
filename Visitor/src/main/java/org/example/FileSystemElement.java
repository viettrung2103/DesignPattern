package org.example;

public interface FileSystemElement {
    String getName();
    int size();
    void accept(FileSystemVisitor visitor);

}
