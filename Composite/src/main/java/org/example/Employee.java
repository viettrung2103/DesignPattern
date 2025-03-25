package org.example;

public class Employee extends Component {
    private int salary;
    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;

    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }



    @Override
    public int totalSalary() {
        int totalSalary = getSalary();

        return totalSalary;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Not support for leaf, employee");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Not support for leaf, employee");
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("Not support for leaf, employee");
    }

}
