package org.example;

public class File implements FileSystemElement {
    private String filename;
    private int size;

    public File(String filename, int size) {
        this.filename = filename;
        this.size = size;
    }

    public String getName(){
        return this.filename;
    };
    public int size(){
        return this.size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "File: "+this.filename;
    }
}
