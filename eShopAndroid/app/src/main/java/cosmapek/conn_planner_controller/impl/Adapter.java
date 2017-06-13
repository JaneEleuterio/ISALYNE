package cosmapek.conn_planner_controller.impl;

import cosmapek.conn_planner_controller.prov.IManager;

class Adapter
    implements cosmapek.controller.req.IPlanningManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void start() {
        cosmapek.planner.prov.IPlanningManager compPlanner =
            (cosmapek.planner.prov.IPlanningManager) this.manager.getRequiredInterface(IPlanningManagerTag);
        compPlanner.start();
    }
}
