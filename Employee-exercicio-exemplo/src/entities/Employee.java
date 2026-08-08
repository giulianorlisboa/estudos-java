package entities;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    protected String name;
    protected Integer hours;
    protected Double valuePerHour;
    protected static final List<Employee> employees = new ArrayList<>();

    public Employee() {
    }

    public Employee(String name, Integer hours, Double valuePerHour) {
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
        employees.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Double payment() {
        return valuePerHour * hours;
    }

    public static List<Employee> getEmployees() {
        return employees;
    }


    @Override
    public  final String toString() {
        return name + " - $ " + String.format("%.2f", payment());
    }
}

