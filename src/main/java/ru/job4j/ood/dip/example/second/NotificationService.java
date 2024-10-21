package ru.job4j.ood.dip.example.second;

/**
 * NotificationService зависит от конкретной реализации EmailNotification.
 * Если позже понадобится отправлять уведомления через SMS или другие каналы,
 * придётся переписывать класс, что нарушает принцип инверсии зависимости (Dependency Inversion Principle).
 */
public class NotificationService {
    private EmailNotification emailNotification;

    public NotificationService() {
        this.emailNotification = new EmailNotification();
    }

    public void notifyUser(String message) {
        emailNotification.sendEmail(message);
    }
}
