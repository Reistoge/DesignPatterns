package BehavioralPatterns.Observer;

public interface IObserver {
    public void update(String message);
    public void triggerNotify(String message);

}
