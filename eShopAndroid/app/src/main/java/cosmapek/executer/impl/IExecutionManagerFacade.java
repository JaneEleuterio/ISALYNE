package cosmapek.executer.impl;

import cosmapek.executer.core.Executer;
import cosmapek.executer.core.ExecuterFactory;
import cosmapek.executer.prov.IExecutionManager;
import cosmapek.executer.prov.IManager;

/**
 * @author Junior Cupe Casquina
 */
class IExecutionManagerFacade implements IInterfaceTags, IExecutionManager {
    private IManager manager;
    private Executer executer;

    IExecutionManagerFacade(IManager manager) {
        this.manager = manager;
        this.executer = ExecuterFactory.createInstance(this.manager);
    }

    @Override public synchronized void start() {
        executer.start();
    }

    @Override public synchronized void setJarPath(String jarPath) {
        executer.setJarPath(jarPath);
    }
}
