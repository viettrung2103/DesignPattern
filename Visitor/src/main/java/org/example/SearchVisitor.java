package org.example;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private List<FileSystemElement> foundElements;
    private String keyword;

    public SearchVisitor(String keyword) {
        this.keyword = keyword;
        foundElements = new ArrayList<>();
    }

    public String getKeyword() {
        return keyword;
    }


    public List<FileSystemElement> getFoundElements() {
        return foundElements;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(keyword)) {
            foundElements.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        if(directory.getName().contains(keyword)) {
            foundElements.add(directory);
        }
        for (FileSystemElement element: directory.getElements()){
            element.accept(this);
        }
    }

}
