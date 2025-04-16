package BehavioralPatterns.Observer;

public interface ISubject {
    public void addObserver(IObserver observer);
    public void removeObserver(IObserver observer);
    public void notifyObservers(String message);
    public void updateObservers(String message);
}
