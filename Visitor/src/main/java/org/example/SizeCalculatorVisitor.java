package org.example;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSize = 0;

    public int getTotalSize() {
        return totalSize;
    }

    @Override
    public void visit(File file) {
        totalSize += file.size();
        System.out.println("Total size: " + totalSize);
    }

    @Override
    public void visit(Directory directory) {
        totalSize += directory.size();
        System.out.println("Total size: " + totalSize);
    }
}
