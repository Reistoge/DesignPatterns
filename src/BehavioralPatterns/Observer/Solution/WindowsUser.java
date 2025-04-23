package BehavioralPatterns.Observer.Solution;

public class WindowsUser implements IObserver {
    private String name;
    private String user_info;
    private String windowsVersion;

    public WindowsUser(String name,String user_info,String windowsVersion){
        this.name = name;
        this.user_info = user_info;
        this.windowsVersion = windowsVersion;
    }
    @Override
    public void update(String newVer) {
        newVer = newVer.toUpperCase();
        if(windowsVersion.equals(newVer)){
            return;
        }
        user_info = name.toUpperCase()+";user_info:"+user_info+";windowsVersion:"+windowsVersion+";APPVER:"+newVer;

    }
    @Override
    public void triggerNotify(String message) {
        System.out.println("Windows User " + name + " received message: " + message);

    }
}
