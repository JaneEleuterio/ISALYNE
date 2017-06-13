package cosmapek.conn_executer_controller.impl;

import cosmapek.conn_executer_controller.prov.IManager;

class Adapter
    implements cosmapek.controller.req.IExecutionManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void start() {
        cosmapek.executer.prov.IExecutionManager compExecuter =
            (cosmapek.executer.prov.IExecutionManager) this.manager
                .getRequiredInterface(IExecutionManagerTag);
        compExecuter.start();
    }

    @Override public synchronized void setJarPath(String jarPath) {
        cosmapek.executer.prov.IExecutionManager compExecuter =
            (cosmapek.executer.prov.IExecutionManager) this.manager
                .getRequiredInterface(IExecutionManagerTag);
        compExecuter.setJarPath(jarPath);
    }
}
