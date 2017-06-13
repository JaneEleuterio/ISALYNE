package cosmapek.main.impl;

import cosmapek.main.core.Boot;
import cosmapek.main.core.BootFactory;
import cosmapek.main.prov.ILauncher;
import cosmapek.main.prov.IManager;

/**
 * @author Junior Cupe Casquina
 */
class ILauncherFacade implements ILauncher {
    private IManager manager;
    private Boot launcher;

    ILauncherFacade(IManager manager) {
        this.manager = manager;
        this.launcher = BootFactory.createInstance(this.manager);
    }

    @Override public synchronized boolean start() {

        return launcher.start();
    }
}
