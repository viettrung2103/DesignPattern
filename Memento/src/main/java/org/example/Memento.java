package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private String name; // use this to display in list
    private String creationTime;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.creationTime = getDate(System.currentTimeMillis());
        this.name = "options: "+options[0] + " "+ options[1] + " "+ options[2]  + " - " + isSelected +" - "+creationTime;

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

    private String getDate(long dateFromLongNum){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date dateD=new Date();
        dateD.setTime(dateFromLongNum);
        return dateFormat.format(dateD);
//        return date
    }

    public String getCreationTime() {
        return creationTime;
    }

    public boolean isSameMemento(IMemento memento) {
        if (memento==null){
            return false;
        }
        if (((Memento)memento).getCreationTime().equals(this.creationTime)){
            return true;
        }
        return false;
    }
}
