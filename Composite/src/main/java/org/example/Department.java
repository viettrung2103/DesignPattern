package org.example;

import java.util.ArrayList;
import java.util.List;

public class Department extends Component {
    private List<Component> dComponents;

    public Department(String name){
        super(name);
        dComponents = new ArrayList<>();
    }

    @Override
    public int totalSalary() {
        int totalSalary = 0;
        for (Component employee: dComponents){
            totalSalary += employee.totalSalary();
        }
        return totalSalary;

    }

    @Override
    public void add(Component component) {
        if (!(component instanceof Organization)){

        this.dComponents.add(component);
        }
    }

    @Override
    public void remove(Component component) {
        if (!(component instanceof Organization)) {

            this.dComponents.remove(component);
        }
    }

    @Override
    public Component getChild(int index) {
        return null;
    }

    @Override
    public String toString(){
        String originalString = super.toString();
        originalString = originalString.replace("[", "\n");
        originalString = originalString.replace(",","");
        originalString = originalString.replace("]", "");
        return originalString;
    }

}
