package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: Conn_VisaC_VisaCSensor
 *
 * Manages the Conn_VisaC_VisaCSensor configuration.
 */
public class Conn_VisaC_VisaCSensor implements IExecution,IInterfaceTags {
    private visaC.prov.IManager i_visaC;
    private visaC.prov.IVisaManager i_IVisaManager;

    private conn_VisaC_VisaCSensor.prov.IManager i_conn_VisaC_VisaCSensor;
    private visaCSensor.prov.IManager i_visaCSensor;

    @Override
    public synchronized void execute() {
        i_visaC = visaC.impl.ComponentFactory.createInstance();
        i_IVisaManager =
                (visaC.prov.IVisaManager) i_visaC.getProvidedInterface(IVisaManagerTag);

        i_conn_VisaC_VisaCSensor= conn_VisaC_VisaCSensor.impl.ComponentFactory.createInstance();
        i_conn_VisaC_VisaCSensor.setRequiredInterface(IVisaManagerTag, i_IVisaManager);

        i_visaCSensor = visaCSensor.impl.ComponentFactory.createInstance();
        i_visaCSensor.setRequiredInterface(IVisaManagerTag,
                i_conn_VisaC_VisaCSensor.getProvidedInterface(IVisaManagerTag));
    }
}