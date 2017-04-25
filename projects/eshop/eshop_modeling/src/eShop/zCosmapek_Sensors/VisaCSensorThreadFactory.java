package eShop.zCosmapek_Sensors;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: VisaCSensor
 *
 * Manages the VisaCSensor threads
 */
public class VisaCSensorThreadFactory {
    private static boolean wasUsed=false;
    private static VisaCSensorThread visaCSensorThread = null;

    public static synchronized VisaCSensorThread createInstance() {
        if (visaCSensorThread == null)
            visaCSensorThread = new VisaCSensorThread();
        return visaCSensorThread;
    }
    public static synchronized boolean wasUsed() {
        return wasUsed;
    }
    public static synchronized void used() {
        wasUsed= true;
    }
}