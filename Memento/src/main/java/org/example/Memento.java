package org.example;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private String name; // use this to display in list

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.name = "options: "+options[0] + " "+ options[1] + " "+ options[2]  + " - " + isSelected;
//        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public String getName() {
        return this.name;
    }

    public String setName(String name) {
        return this.name = name;
    }
}
