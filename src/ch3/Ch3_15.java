package ch3;

import java.util.Arrays;
import java.util.Comparator;

public class Ch3_15 {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("a", 2),
            new Employee("b", 2),
            new Employee("c", 1)
        };

        sort(employees);
        System.out.println(Arrays.toString(employees));

        sortReversed(employees);
        System.out.println(Arrays.toString(employees));
    }

    static void sort(Employee[] employees) {
        Comparator<Employee> comp = Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName);
        Arrays.sort(employees, comp);
    }

    static void sortReversed(Employee[] employees) {
        Comparator<Employee> comp = Comparator.comparing(Employee::getSalary, Comparator.reverseOrder())
                .thenComparing(Employee::getName, Comparator.reverseOrder());
        Arrays.sort(employees, comp);
    }

    private static class Employee {
        private int salary;
        private String name;

        Employee(String name, int salary) {
            this.salary = salary;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
