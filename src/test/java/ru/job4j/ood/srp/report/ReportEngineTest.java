package ru.job4j.ood.srp.report;

import org.junit.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.io.CSVRW;
import ru.job4j.ood.srp.io.ReadWriteFile;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        ReadWriteFile csvFile = new CSVRW();
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ReportEngine(store, parser);
        engine.generate(employee -> true);
        List<List<String>> records = csvFile.read("data/2. Джуниор/2.5. Чистая архитектура/2.5.1. SRP/1. Отчеты/reportProgrammersDepartment.csv");
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < records.size(); row++) {
            for (int column = 0; column < records.get(row).size(); column++) {
                result.append(records.get(row).get(column));
            }
            if (row + 1 < records.size()) {
                result.append(System.lineSeparator());
            }
        }
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(worker.getSalary())
                .append(System.lineSeparator());
        assertThat(result.toString()).isEqualTo(expected.toString());
    }
}
