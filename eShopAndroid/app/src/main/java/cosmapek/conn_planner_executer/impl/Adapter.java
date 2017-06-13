package cosmapek.conn_planner_executer.impl;

import cosmapek.conn_planner_executer.prov.IManager;

import java.util.LinkedList;

class Adapter implements cosmapek.executer.req.IPlanningManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }
/*
    @Override public void start() {
        cosmapek.components.prov.IComponentManager compComponents = (cosmapek.components.prov.IComponentManager) this.manager.getRequiredInterface(IComponentManagerTag);
       // compComponents.start();
    }
*/

    @Override public synchronized void start() {
        cosmapek.planner.prov.IPlanningManager compPlanner =
            (cosmapek.planner.prov.IPlanningManager) this.manager.getRequiredInterface(IPlanningManagerTag);
        compPlanner.start();
    }

    @Override public synchronized LinkedList<String> getComponents() {
        cosmapek.planner.prov.IPlanningManager compPlanner =
            (cosmapek.planner.prov.IPlanningManager) this.manager.getRequiredInterface(IPlanningManagerTag);
        return compPlanner.getComponents();
    }
}
