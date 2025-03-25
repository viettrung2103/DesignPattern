package org.example;

import java.util.ArrayList;
import java.util.List;

public class Organization extends Component {
    private List<Component> oComponents;

    public Organization(String name){
        super(name);
        oComponents = new ArrayList<>();
    }

    @Override
    public int totalSalary() {
        int totalSalary = 0;
        for (Component employee: oComponents){
            totalSalary += employee.totalSalary();
        }
        return totalSalary;

    }

    @Override
    public void add(Component component) {
        if (!(component instanceof Organization)){

            this.oComponents.add(component);
        }
    }

    @Override
    public void remove(Component component) {
        if (!(component instanceof Organization)) {

            this.oComponents.remove(component);
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
