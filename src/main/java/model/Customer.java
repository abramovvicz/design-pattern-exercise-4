package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Customer implements IObserver {
    protected List<String> notifications;
    private String fullName;

    public Customer(String fullName) {
        this.fullName = fullName;
        this.notifications = new ArrayList<>();
    }

    public void printNotifications() {
        System.out.println(notifications);
    }

    public List<String> getNotifications() {
        return notifications;
    }

    @Override
    public void update() {
        notifications.add(LocalDateTime.now() + " " + "Została złożona oferta dla przedmiotu");
    }
}
