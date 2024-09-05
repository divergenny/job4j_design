package ru.job4j.ood.lsp.example.second;

/**
 * if (salary > 50000) {  - является усилением предусловия
 * throw new IllegalArgumentException("Salary too low for a manager"); - является нарушением LSP
 */
public class Manager extends Employee {
    @Override
    public void setSalary(double salary) {
        if (salary > 50000) {
            super.setSalary(salary);
        } else {
            throw new IllegalArgumentException("Salary too low for a manager");
        }
    }
}
