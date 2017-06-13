package cosmapek.planner.req;

import cosmapek.interfaces.ISensor;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
public interface ISensorManager {

    LinkedList<ISensor> getSensorsWith(String feature);

    boolean hasSensorsWith(String feature);

}
