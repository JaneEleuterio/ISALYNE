package cosmapek.reader.core;

import cosmapek.reader.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class ReaderFactory {
    private static Reader sensorM = null;

    public static synchronized Reader createInstance(IManager manager) {
        if (sensorM == null)
            sensorM = new Reader(manager);
        return sensorM;
    }
}
