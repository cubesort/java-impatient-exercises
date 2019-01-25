public class Ch3_1 {
    public static void main(String[] args) {
        Measurable[] measurables = {
                new Employee(1),
                new Employee(2),
                new Employee(3),
        };

        System.out.println(average(measurables));
    }

    static double average (Measurable[] measurables) {
        double sum = 0;
        for (Measurable measurable : measurables) {
            sum += measurable.getMeasure();
        }
        return sum / measurables.length;
    }
}

interface Measurable {
    double getMeasure();
}

class Employee implements Measurable {
    private double salary;

    public Employee(double salary) {
        this.salary = salary;
    }

    @Override
    public double getMeasure () {
        return this.salary;
    }
}
