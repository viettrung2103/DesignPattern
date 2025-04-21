package org.example;

public class Main {
    public static void main (String[] args){
        // Create files
        File file1 = new File("file1.txt", 10);
        File file2 = new File("file2.doc", 20);
        File file3 = new File("file3.txt", 30);

        // Create directories
        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");

        // Add files to directories
        dir1.addElement(file1);
        dir1.addElement(file2);

        dir2.addElement(file3);
        dir2.addElement(dir1);

        // Apply SizeCalculatorVisitor
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        dir2.accept(sizeVisitor);
        System.out.println("Total size of dir2: " + sizeVisitor.getTotalSize() + " kb");

        // Apply SearchVisitor
        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        dir2.accept(searchVisitor);
        System.out.println("Files matching '.txt':");
        for (FileSystemElement element : searchVisitor.getFoundElements()) {
            System.out.println(element);
        }
    }
}
