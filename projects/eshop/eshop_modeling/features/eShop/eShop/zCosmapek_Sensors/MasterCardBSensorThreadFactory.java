package eShop.zCosmapek_Sensors;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: MasterCardBSensor
 *
 * Manages the MasterCardBSensor threads
 */
public class MasterCardBSensorThreadFactory {
    private static boolean wasUsed=false;
    private static MasterCardBSensorThread masterCardBSensorThread = null;

    public static synchronized MasterCardBSensorThread createInstance() {
        if (masterCardBSensorThread == null)
            masterCardBSensorThread = new MasterCardBSensorThread();
        return masterCardBSensorThread;
    }
    public static synchronized boolean wasUsed() {
        return wasUsed;
    }
    public static synchronized void used() {
        wasUsed= true;
    }
}