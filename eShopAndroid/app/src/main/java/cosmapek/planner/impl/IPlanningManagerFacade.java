package cosmapek.planner.impl;

import cosmapek.planner.core.Planner;
import cosmapek.planner.core.PlannerFactory;
import cosmapek.planner.prov.IPlanningManager;
import cosmapek.planner.prov.IManager;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
class IPlanningManagerFacade implements IPlanningManager {
    private IManager manager;
    private Planner planner;

    IPlanningManagerFacade(IManager manager) {
        this.manager = manager;
        this.planner = PlannerFactory.createInstance(this.manager);
    }

    @Override public synchronized void start() {
        planner.start();
    }

    @Override public synchronized LinkedList<String> getComponents() {
        return planner.getComponents();
    }
}
