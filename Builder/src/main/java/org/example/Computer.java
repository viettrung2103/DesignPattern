package org.example;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Component> components;

    public Computer(){
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component){
        this.components.add(component);
    }

    public List<Component> getComponents() {
        return components;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Component component: this.components){
            sb.append(component.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
