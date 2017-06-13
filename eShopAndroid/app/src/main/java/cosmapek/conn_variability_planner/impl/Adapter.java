package cosmapek.conn_variability_planner.impl;

import cosmapek.conn_variability_planner.prov.IManager;

import java.util.LinkedList;

class Adapter
    implements cosmapek.planner.req.IVariabilityManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized LinkedList<String> getASolutionWithout(LinkedList<String> failedFeatures) {
        cosmapek.variability.prov.IVariabilityManager compVariability =
            (cosmapek.variability.prov.IVariabilityManager) this.manager
                .getRequiredInterface(IVariabilityManagerTag);
        return compVariability.getASolutionWithout(failedFeatures);
    }
}
