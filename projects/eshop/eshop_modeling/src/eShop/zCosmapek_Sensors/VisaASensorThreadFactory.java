package eShop.zCosmapek_Sensors;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: VisaASensor
 *
 * Manages the VisaASensor threads
 */
public class VisaASensorThreadFactory {
    private static boolean wasUsed=false;
    private static VisaASensorThread visaASensorThread = null;

    public static synchronized VisaASensorThread createInstance() {
        if (visaASensorThread == null)
            visaASensorThread = new VisaASensorThread();
        return visaASensorThread;
    }
    public static synchronized boolean wasUsed() {
        return wasUsed;
    }
    public static synchronized void used() {
        wasUsed= true;
    }
}