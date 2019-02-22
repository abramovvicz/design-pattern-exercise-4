package model;

import java.util.ArrayList;
import java.util.List;

public class ClientNotifierImp implements IClientNotifier {

    List<IObserver> observers;


    public ClientNotifierImp() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unRegisterObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifiedObservers() {
        observers.forEach(observer -> observer.update());
    }
}
