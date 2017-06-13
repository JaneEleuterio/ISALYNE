package eShop.zCosmapek_Sensors;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaB
 * Component: VisaBSensor
 *
 * Manages the VisaBSensor threads
 */
public class VisaBSensorThreadFactory {
    private static boolean wasUsed=false;
    private static VisaBSensorThread visaBSensorThread = null;

    public static synchronized VisaBSensorThread createInstance() {
        if (visaBSensorThread == null)
            visaBSensorThread = new VisaBSensorThread();
        return visaBSensorThread;
    }
    public static synchronized boolean wasUsed() {
        return wasUsed;
    }
    public static synchronized void used() {
        wasUsed= true;
    }
}