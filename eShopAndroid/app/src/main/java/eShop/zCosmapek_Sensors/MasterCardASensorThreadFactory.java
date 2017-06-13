package eShop.zCosmapek_Sensors;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: MasterCardASensor
 *
 * Manages the MasterCardASensor threads
 */
public class MasterCardASensorThreadFactory {
    private static boolean wasUsed=false;
    private static MasterCardASensorThread masterCardASensorThread = null;

    public static synchronized MasterCardASensorThread createInstance() {
        if (masterCardASensorThread == null)
            masterCardASensorThread = new MasterCardASensorThread();
        return masterCardASensorThread;
    }
    public static synchronized boolean wasUsed() {
        return wasUsed;
    }
    public static synchronized void used() {
        wasUsed= true;
    }
}