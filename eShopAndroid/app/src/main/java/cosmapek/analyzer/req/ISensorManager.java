package cosmapek.analyzer.req;

import cosmapek.interfaces.ISensors;

public interface ISensorManager {

    boolean hasSensorsInRuntime();

    ISensors getSensors();

    ISensors getSensorsInRuntime();
}
