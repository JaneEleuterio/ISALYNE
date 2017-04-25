package eShop.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: Conn_sensors_VisaASensor
 *
 * Manages the Conn_sensors_VisaASensor configuration.
 */
public class Conn_sensors_VisaASensor implements IExecution,IInterfaceTags {
    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorUpdater sensISens;

    private conn_sensors_VisaASensor.prov.IManager i_conn_sensors_VisaASensor;
    private visaASensor.prov.IManager i_visaASensor;
    @Override
    public synchronized void execute() {
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorUpdater) sens.getProvidedInterface(ISensorUpdaterTag);

        i_conn_sensors_VisaASensor=conn_sensors_VisaASensor.impl.ComponentFactory.createInstance();
        i_conn_sensors_VisaASensor.setRequiredInterface(ISensorUpdaterTag, sensISens);

        i_visaASensor = visaASensor.impl.ComponentFactory.createInstance();
        i_visaASensor.setRequiredInterface(ISensorUpdaterTag,
                i_conn_sensors_VisaASensor.getProvidedInterface(ISensorUpdaterTag));
    }
}