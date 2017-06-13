package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: Conn_VisaA_VisaASensor
 *
 * Manages the Conn_VisaA_VisaASensor configuration.
 */
public class Conn_VisaA_VisaASensor implements IExecution,IInterfaceTags {
    private visaA.prov.IManager i_visaA;
    private visaA.prov.IVisaManager i_IVisaManager;

    private conn_VisaA_VisaASensor.prov.IManager i_conn_VisaA_VisaASensor;
    private visaASensor.prov.IManager i_visaASensor;

    @Override
    public synchronized void execute() {
        i_visaA = visaA.impl.ComponentFactory.createInstance();
        i_IVisaManager =
                (visaA.prov.IVisaManager) i_visaA.getProvidedInterface(IVisaManagerTag);

        i_conn_VisaA_VisaASensor= conn_VisaA_VisaASensor.impl.ComponentFactory.createInstance();
        i_conn_VisaA_VisaASensor.setRequiredInterface(IVisaManagerTag, i_IVisaManager);

        i_visaASensor = visaASensor.impl.ComponentFactory.createInstance();
        i_visaASensor.setRequiredInterface(IVisaManagerTag,
                i_conn_VisaA_VisaASensor.getProvidedInterface(IVisaManagerTag));
    }
}