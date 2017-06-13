package cosmapek.conn_reader_main.impl;

import cosmapek.conn_reader_main.prov.IManager;

class Adapter implements cosmapek.main.req.IReadingManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void setConfigurationPath(String configurationPath) {
        cosmapek.reader.prov.IReadingManager compReader =
            (cosmapek.reader.prov.IReadingManager) this.manager.getRequiredInterface(IReadingManagerTag);
        compReader.setConfigurationPath(configurationPath);
    }

    @Override public synchronized void setVariabilityPath(String variabilityPath) {
        cosmapek.reader.prov.IReadingManager compReader =
            (cosmapek.reader.prov.IReadingManager) this.manager.getRequiredInterface(IReadingManagerTag);
        compReader.setVariabilityPath(variabilityPath);
    }

    @Override public synchronized void read() {
        cosmapek.reader.prov.IReadingManager compReader =
            (cosmapek.reader.prov.IReadingManager) this.manager.getRequiredInterface(IReadingManagerTag);
        compReader.read();
    }

}
