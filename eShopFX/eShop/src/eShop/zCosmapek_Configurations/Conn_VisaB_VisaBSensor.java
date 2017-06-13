package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaB
 * Component: Conn_VisaB_VisaBSensor
 *
 * Manages the Conn_VisaB_VisaBSensor configuration.
 */
public class Conn_VisaB_VisaBSensor implements IExecution,IInterfaceTags {
    private visaB.prov.IManager i_visaB;
    private visaB.prov.IVisaManager i_IVisaManager;

    private conn_VisaB_VisaBSensor.prov.IManager i_conn_VisaB_VisaBSensor;
    private visaBSensor.prov.IManager i_visaBSensor;

    @Override
    public synchronized void execute() {
        i_visaB = visaB.impl.ComponentFactory.createInstance();
        i_IVisaManager =
                (visaB.prov.IVisaManager) i_visaB.getProvidedInterface(IVisaManagerTag);

        i_conn_VisaB_VisaBSensor= conn_VisaB_VisaBSensor.impl.ComponentFactory.createInstance();
        i_conn_VisaB_VisaBSensor.setRequiredInterface(IVisaManagerTag, i_IVisaManager);

        i_visaBSensor = visaBSensor.impl.ComponentFactory.createInstance();
        i_visaBSensor.setRequiredInterface(IVisaManagerTag,
                i_conn_VisaB_VisaBSensor.getProvidedInterface(IVisaManagerTag));
    }
}