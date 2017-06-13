package cosmapek.components.impl;

import cosmapek.components.core.ComponentM;
import cosmapek.components.core.ComponentMFactory;
import cosmapek.components.prov.IComponentManager;
import cosmapek.components.prov.IManager;
import cosmapek.interfaces.IComponent;
import cosmapek.interfaces.IComponents;

import java.util.LinkedList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class IComponentManagerFacade implements IInterfaceTags, IComponentManager {
    private IManager manager;
    private ComponentM comp;

    public IComponentManagerFacade(IManager manager) {
        this.manager = manager;
        this.comp = ComponentMFactory.createInstance(this.manager);
    }

    @Override
    public synchronized void createAComponent(String name, String feature, boolean isSensor, int orderT) {
        comp.createAComponent(name, feature, isSensor, orderT);
    }

    @Override public synchronized LinkedList<IComponent> getComponentsWith(String feature) {
        return comp.getComponentsWith(feature);
    }

    @Override public synchronized boolean hasComponentsWith(String feature) {
        return comp.hasComponentsWith(feature);
    }

    @Override public synchronized IComponents getComponentsInRuntime() {
        return comp.getComponentsInRuntime();
    }

    @Override public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        comp.updateRuntimeRegistry(sol);
    }

    @Override public synchronized void clearComponents() {
        comp.clearComponents();
    }
}
