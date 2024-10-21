package ru.job4j.ood.dip.example.third;

/**
 * ReportService зависит от конкретного класса PDFReportGenerator.
 * Если нужно будет изменить формат отчёта (HTML или Excel),
 * придётся изменять код класса ReportService,
 * что нарушает принцип инверсии зависимости (Dependency Inversion Principle).
 */
public class ReportService {
    private PDFReportGenerator reportGenerator;

    public ReportService() {
        this.reportGenerator = new PDFReportGenerator();
    }

    public void createReport() {
        reportGenerator.generateReport();
    }
}
