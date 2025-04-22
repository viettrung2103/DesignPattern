package org.example;

public class Component {

    private String name;

    public Component(String name ){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
