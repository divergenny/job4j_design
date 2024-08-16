package ru.job4j.ood.ocp.example.third;

/**
 * Если нужно добавить новый тип уведомления,
 * например, PushNotification, потребуется изменить метод sendNotification в классе NotificationService,
 * добавив новую ветку для обработки push-уведомлений.
 * Это требует изменения существующего кода, что нарушает Open Closed Principle.
 */
public class EmailNotification {
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSNotification {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class NotificationService {
    public void sendNotification(String message, String type) {
        if (type.equals("email")) {
            new EmailNotification().send(message);
        } else if (type.equals("sms")) {
            new SMSNotification().send(message);
        }
    }
}
