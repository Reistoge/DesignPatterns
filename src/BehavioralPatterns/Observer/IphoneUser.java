package BehavioralPatterns.Observer;

public class IphoneUser implements IObserver {
    private String name;
    private String user_Version;
    private String IMEI;
    private String IOSVersion;
    private boolean hasFaceID;
    private String iphoneModel;

    public IphoneUser(String name,String iphoneModel, String IMEI, String IOSVersion, boolean hasFaceID) {
        this.name = name;
        this.iphoneModel = iphoneModel;
        this.IMEI = IMEI;
        this.IOSVersion = IOSVersion;
        this.hasFaceID = hasFaceID;


    }

    @Override
    public void update(String newVer) {
        newVer = newVer.toUpperCase();

        if(iphoneModel.equals("5s") || iphoneModel.equals("4s") || iphoneModel.equals("6")) {
            System.out.println("IphoneModel: " + iphoneModel+" is not supported anymore");
            user_Version = "NOT SUPPORTED";
            return;
        }
        user_Version = "NAME:"+name.toUpperCase()+";IPHONEMODEL:"+iphoneModel+";IMEI:"+IMEI+";IOSVersion:"+IOSVersion+";hasFaceID:"+hasFaceID+";APPVER:"+newVer;
    }

    @Override
    public void triggerNotify(String message) {
        System.out.println("Iphone User " + name + " received message: " + message);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
