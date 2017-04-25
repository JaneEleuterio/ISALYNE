package visaASensor.core;

import visaASensor.prov.IManager;
import visaASensor.req.IVisaManager;
import visaASensor.req.ISensorUpdater;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: VisaASensor
 *
 * This class is a part of the VisaASensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'VisaASensor'. 
 *
 * IMPORTANT! All 'TODO'annotations need to be fixed to print the log to the Monitor component.
 */
public class SensorUpdaterM {
    private IManager manager;
    private long timeLapse;
    private String nome;
    private IVisaManager i_IVisaManager;
    private ISensorUpdater sensorUpdater;
    private boolean turnOn;


    public SensorUpdaterM(IManager manager) {
        this.manager = manager;
        this.timeLapse = 10000;
        this.turnOn = false;
        this.nome = "VisaASensor";
    }

    private void getManagers() {
        this.i_IVisaManager =
                (IVisaManager) manager.getRequiredInterface("IVisaManager");
        this.sensorUpdater =
                (ISensorUpdater) manager.getRequiredInterface("ISensorUpdater");
    }

    public synchronized boolean runSensor() {
        this.turnOn = true;
            while (this.turnOn) {
                try {
                    Thread.sleep(timeLapse);
                    this.executeSensor();
                }catch (Exception e){
					e.printStackTrace();
                	//TODO: log("VisaA", "Error = VisaA Sensor " + e.toString());
                }
            }

        return true;
    }

    private void executeSensor() {
        getManagers();
        try{
            long startTime = System.currentTimeMillis();
			
			//TODO: needs to call a method from monitored interface
            //i_IVisaManager.businessMethod(param);
			
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            if(totalTime>100000){
                long timeSensorI= System.currentTimeMillis();
                
				//TODO: log("VisaA", "VisaA Sensor(Activated)I: "+timeSensorI+" " + nome + " Time: " + totalTime + " ");

                sensorUpdater.activateSensor(nome);

                long timeSensorF= System.currentTimeMillis();
                //TODO: log("VisaA", "VisaA Sensor(Activated)F: "+timeSensorF +" "+ nome + " Time: " + totalTime + " ");
            }else{
                long timeSensorI= System.currentTimeMillis();
                //TODO: log("VisaA", "VisaA Sensor(Deactivated)I: " + timeSensorI + " ");

                sensorUpdater.deactivateSensor(nome);

                long timeSensorF= System.currentTimeMillis();
                //TODO: log("VisaA", "VisaA Sensor(Deactivated)F: " + timeSensorF + " ");
            }
        }catch (Exception e){
			// the component has a error
			e.printStackTrace();
            //TODO: log("VisaA", "VisaA Sensor Catch -> " + e.toString());
            
			long timeSensorI= System.currentTimeMillis();
            //TODO: log("VisaA", "VisaA Sensor(Activated)I: " + timeSensorI + " ");
            
			sensorUpdater.activateSensor(nome);

            long timeSensorF= System.currentTimeMillis();
            //TODO: log("VisaA", "VisaA Sensor(Activated)F: " + timeSensorF + " ");
        }
    }

    public synchronized boolean deactivateSensor() {
        getManagers();
        this.turnOn = false;
        return true;
    }
}