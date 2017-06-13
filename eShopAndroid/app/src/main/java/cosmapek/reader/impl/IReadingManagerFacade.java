package cosmapek.reader.impl;

import cosmapek.reader.core.Reader;
import cosmapek.reader.core.ReaderFactory;
import cosmapek.reader.prov.IManager;
import cosmapek.reader.prov.IReadingManager;

/**
 * @author Junior Cupe Casquina
 */
class IReadingManagerFacade implements IReadingManager {
    private IManager manager;
    private Reader reader;

    IReadingManagerFacade(IManager manager) {
        this.manager = manager;
        this.reader = ReaderFactory.createInstance(this.manager);
    }

    @Override public synchronized void setConfigurationPath(String configurationPath) {
        reader.setConfigurationPath(configurationPath);
    }

    @Override public synchronized void setVariabilityPath(String variabilityPath) {
        reader.setVariabilityPath(variabilityPath);
    }

    @Override public synchronized void read() {
        reader.read();
    }
}
