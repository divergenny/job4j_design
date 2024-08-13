package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportAccounting implements Report {
    private final Store store;
    private final CurrencyConverter currencyConverter;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportAccounting(Store store, CurrencyConverter currencyConverter, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.currencyConverter = currencyConverter;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary; Salary in USD;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(employee.getSalary()).append(" ")
                    .append(currencyConverter.convert(Currency.RUB, employee.getSalary(), Currency.USD)).append(" ")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
