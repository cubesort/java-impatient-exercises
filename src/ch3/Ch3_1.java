public class Ch3_1 {
    public static void main(String[] args) {
        Measurable[] measurables = {
                new Employee(1),
                new Employee(2),
                new Employee(3),
        };

        System.out.println(Measurable.average(measurables));

        Employee[] employees = {
                new Employee(1, "John"),
                new Employee(2, "Burr"),
                new Employee(3, "Alex"),
        };

        System.out.println(Employee.getLargest(employees));
    }
}

interface Measurable {
    double getMeasure();

    static double average(Measurable[] measurables) {
        double sum = 0;
        for (Measurable measurable : measurables) {
            sum += measurable.getMeasure();
        }
        return sum / measurables.length;
    }

    static Measurable largest(Measurable[] measurables) {
        Measurable largest = measurables[0];

        for (Measurable measurable : measurables) {
            if (measurable.getMeasure() > largest.getMeasure()) {
                largest = measurable;
            }
        }

        return largest;
    }
}

class Employee implements Measurable {
    private double salary;
    private String name = "no name";

    public Employee(double salary) {
        this.salary = salary;
    }

    public Employee(double salary, String name) {
        this(salary);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getMeasure() {
        return this.salary;
    }

    public static String getLargest(Employee[] employees) {
        Measurable largest = Measurable.largest(employees);
        Employee largestEmployee = (Employee) largest;

        return largestEmployee.getName();
    }
}
