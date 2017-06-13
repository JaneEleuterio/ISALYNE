package cosmapek.conn_variability_reader.impl;

import cosmapek.conn_variability_reader.prov.IManager;

class Adapter
    implements cosmapek.reader.req.IVariabilityManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void setVariabilityPath(String variabilityPath) {
        cosmapek.variability.prov.IVariabilityManager compVariability =
            (cosmapek.variability.prov.IVariabilityManager) this.manager
                .getRequiredInterface(IVariabilityManagerTag);
        compVariability.setVariabilityPath(variabilityPath);
    }

    @Override public synchronized void read() {
        cosmapek.variability.prov.IVariabilityManager compVariability =
            (cosmapek.variability.prov.IVariabilityManager) this.manager
                .getRequiredInterface(IVariabilityManagerTag);
        compVariability.read();
    }
}
