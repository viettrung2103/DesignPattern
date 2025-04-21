package org.example;
import java.util.*;

public class Directory implements FileSystemElement {
    private String name;
//    private int size;
    private List<FileSystemElement> elements;

    public Directory(String name){
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void addElement(FileSystemElement element){
        this.elements.add(element);
    }

    public List<FileSystemElement> getElements() {
        return elements;
    }

    public void removeElement(FileSystemElement element){
        if (this.elements.contains(element)){
            this.elements.remove(element);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int size() {
        int size = 0;
        for (FileSystemElement element : this.elements){
            size += element.size();
        }
        return size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Directory: "+this.name;
    }
}
