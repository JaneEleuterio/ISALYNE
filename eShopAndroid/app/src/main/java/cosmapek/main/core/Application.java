package cosmapek.main.core;

import cosmapek.main.prov.IManager;

/**
 * This class has the cosmapek.main method.
 *
 * @author Junior Cupe Casquina
 */
public class Application implements IInterfaceTags {
    public static void main(String[] args) {
        //need load each component
        //  boolean tru = true;


        IManager manager = cosmapek.main.impl.ComponentFactory.createInstance();
        cosmapek.main.prov.ILauncher launcher =
            (cosmapek.main.prov.ILauncher) manager.getProvidedInterface(ILauncherProv);
        launcher.start();
    }
}
