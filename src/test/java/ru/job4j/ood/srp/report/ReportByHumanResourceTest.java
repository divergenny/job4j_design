package ru.job4j.ood.srp.report;

import org.junit.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportByHumanResourceTest {

    @Test
    public void generate() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Jamshid", now, now, 100);
        Employee worker2 = new Employee("Bakhrom", now, now, 190);
        Employee worker3 = new Employee("Ivan", now, now, 103);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportByHumanResource(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(worker2.getSalary())
                .append(System.lineSeparator())
                .append(worker3.getName()).append(" ")
                .append(worker3.getSalary())
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(worker1.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
}
