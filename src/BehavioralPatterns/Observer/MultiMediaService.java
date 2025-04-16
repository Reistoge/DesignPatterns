package BehavioralPatterns.Observer;

import java.util.ArrayList;

public class MultiMediaService implements ISubject {
    ArrayList<IObserver> observers = new ArrayList<IObserver>();
    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for(IObserver o : observers){
            o.triggerNotify(message);
        }
    }
    @Override
    public void updateObservers(String version) {
        for(IObserver o : observers){
            o.update(version);
        }
    }
}
