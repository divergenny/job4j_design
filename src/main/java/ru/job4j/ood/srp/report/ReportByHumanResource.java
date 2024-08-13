package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.sort.SortDescBySalary;
import ru.job4j.ood.srp.store.Store;

import java.util.List;
import java.util.function.Predicate;

public class ReportByHumanResource implements Report {
    private final Store store;

    public ReportByHumanResource(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> foundEmployees = store.findBy(filter);
        foundEmployees.sort(new SortDescBySalary());
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : foundEmployees) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
