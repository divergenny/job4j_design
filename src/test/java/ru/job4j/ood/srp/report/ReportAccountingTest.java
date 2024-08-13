package ru.job4j.ood.srp.report;

import org.junit.Test;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportAccountingTest {

    @Test
    public void generate() {
        MemoryStore store = new MemoryStore();
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Jamshid", now, now, 100);
        DateTimeParser parser = new ReportDateTimeParser();
        store.add(worker);
        Report accounting = new ReportAccounting(store, converter, parser);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary; Salary in USD;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(worker.getSalary()).append(" ")
                .append(worker.getSalary() * 0.0162).append(" ")
                .append(System.lineSeparator());
        assertThat(accounting.generate(employee -> true)).isEqualTo(expected.toString());
    }
}
