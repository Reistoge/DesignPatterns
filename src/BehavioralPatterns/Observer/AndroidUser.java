package BehavioralPatterns.Observer;

public class AndroidUser implements IObserver {
    private String name;
    private String user_Version;
    private String IMEI;
    private String androidVersion;
    private String company;
    public AndroidUser(String name, String user_Version, String IMEI, String AndroidVersion, String company) {
        this.name = name;
        this.user_Version = user_Version;
        this.IMEI = IMEI;
        this.androidVersion = AndroidVersion;
        this.company = company;
    }

    @Override
    public void update(String newVer) {
        newVer = newVer.toLowerCase();
        if(androidVersion.equals("Android 4.4") ) {
            System.out.println("AndroidModel: " + company + " is not supported anymore");
            user_Version = "NOT SUPPORTED";
            return;
        }
        if(!company.equals("Huawei") && !company.equals("Microsoft")) {
            user_Version = name.toUpperCase() + ";IMEI:" + IMEI + ";AndroidVersion:" + androidVersion + ";company:" + company + ";APPVER:" + newVer;
        }
    }

    public String getName() {
        return name;
    }
    @Override
    public void triggerNotify(String message) {
        System.out.println("Android User " + name + " received message: " + message);
    }
}
