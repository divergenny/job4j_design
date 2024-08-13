package ru.job4j.ood.srp.sort;

import ru.job4j.ood.srp.model.Employee;

import java.util.Comparator;

public class SortDescBySalary implements Comparator<Employee> {
    @Override
    public int compare(Employee left, Employee right) {
        return Double.compare(right.getSalary(), left.getSalary());
    }
}
