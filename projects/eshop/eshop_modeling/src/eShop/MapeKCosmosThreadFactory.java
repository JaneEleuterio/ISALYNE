package eShop;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 *
 * Instantiates the MapeKCosmosThread component.
 */
public class MapeKCosmosThreadFactory {
    private static boolean wasUsed=false;
    private static MapeKCosmosThread productSensorThread = null;

    public static synchronized MapeKCosmosThread createInstance(String variabilityPath, String configPath, String jarPath) {
        if (productSensorThread == null)
            productSensorThread = new MapeKCosmosThread(variabilityPath,configPath,jarPath);
        return productSensorThread;
    }

    public static synchronized boolean wasUsed() {
        return wasUsed;
    }
    public static synchronized void used() {
        wasUsed= true;
    }
}