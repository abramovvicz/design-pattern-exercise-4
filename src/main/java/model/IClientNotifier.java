package model;

public interface IClientNotifier {

    void registerObserver(IObserver observer);

    void unRegisterObserver(IObserver observer);

    void notifiedObservers();

}
