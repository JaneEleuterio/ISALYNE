package cosmapek.sensors.prov;

import cosmapek.interfaces.ISensor;
import cosmapek.interfaces.ISensors;

import java.util.LinkedList;

public interface ISensorManager {

    void createASensor(String name, String feature, boolean isSensor, int orderT);

    LinkedList<ISensor> getSensorsWith(String feature);

    boolean hasSensorsWith(String feature);

    boolean hasSensorsInRuntime();

    boolean hasSensors();

    ISensors getSensorsInRuntime();

    ISensors getSensors();

    void updateRuntimeRegistry(LinkedList<String> sol);

    void clearSensors();
}
