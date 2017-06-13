package cosmapek.variability.impl;

import cosmapek.variability.core.Variability;
import cosmapek.variability.core.VariabilityFactory;
import cosmapek.variability.prov.IManager;
import cosmapek.variability.prov.IVariabilityManager;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
class IVariabilityManagerFacade implements IInterfaceTags, IVariabilityManager {
    private static IManager manager = null;
    private Variability variability = null;

    public IVariabilityManagerFacade(IManager manager) {
        this.manager = manager;
        this.variability = VariabilityFactory.createInstance(this.manager);
    }

    @Override public synchronized void setVariabilityPath(String variabilityPath) {
        variability.setVariabilityPath(variabilityPath);
    }

    @Override public synchronized void read() {
        variability.read();
    }

    @Override public synchronized LinkedList<String> getASolutionWithout(LinkedList<String> failedFeatures) {
        return variability.getASolutionWithout(failedFeatures);
    }
}
