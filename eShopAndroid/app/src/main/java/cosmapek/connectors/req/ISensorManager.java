package cosmapek.connectors.req;

import cosmapek.interfaces.ISensor;

import java.util.LinkedList;

/**
 * Created by ArchyWin on 6/5/2015.
 */
public interface ISensorManager {
    LinkedList<ISensor> getSensorsWith(String feature);

    boolean hasSensorsWith(String feature);
}
