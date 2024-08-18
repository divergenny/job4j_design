package ru.job4j.ood.srp.model;

import ru.job4j.ood.srp.adapter.XmlCalendarAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    @XmlElement
    private String name;
    @XmlElement(name = "hired")
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(XmlCalendarAdapter.class)
    private Calendar hired;
    @XmlElement(name = "fired")
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(XmlCalendarAdapter.class)
    private Calendar fired;
    @XmlElement
    private double salary;

    public Employee() {
    }

    public Employee(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getHired() {
        return hired;
    }

    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    public Calendar getFired() {
        return fired;
    }

    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Employee{"
                + "name='" + name + '\''
                + ", hired=" + hired
                + ", fired=" + fired
                + ", salary=" + salary
                + '}';
    }
}
