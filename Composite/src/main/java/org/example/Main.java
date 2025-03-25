package org.example;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Trung",30000);
        Employee e2 = new Employee("Bob",20000);
        Employee e3 = new Employee("Mike",30000);
        Employee e4 = new Employee("Jack",20000);
        System.out.println(e1);
        System.out.println("e1 Total Salary: "+e1.totalSalary());

        Department d1 = new Department("Department 1");
        Department d2 = new Department("Department 2");

        Organization o1 = new Organization("Organization 1");

        d1.add(e1);
        d1.add(e2);

        d2.add(d1);
        d2.add(e3);

        o1.add(d2);
        o1.add(e4);

        System.out.println(d1);
        System.out.println("d1 Total Salary: "+d1.totalSalary());
        System.out.println();

        System.out.println(d2);
        System.out.println("d2 Total Salary: "+d2.totalSalary());
        System.out.println();

        System.out.println(o1);
        System.out.println("o1 Total Salary: "+o1.totalSalary());

    }
}