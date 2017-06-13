package masterCardASensor.core;

import masterCardASensor.prov.IManager;
import masterCardASensor.req.IMasterCardManager;
import masterCardASensor.req.ISensorUpdater;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: MasterCardASensor
 *
 * This class is a part of the MasterCardASensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'MasterCardASensor'. 
 *
 * IMPORTANT! All 'TODO'annotations need to be fixed to print the log to the Monitor component.
 */
public class SensorUpdaterM {
    private IManager manager;
    private long timeLapse;
    private String nome;
    private IMasterCardManager i_IMasterCardManager;
    private ISensorUpdater sensorUpdater;
    private boolean turnOn;


    public SensorUpdaterM(IManager manager) {
        this.manager = manager;
        this.timeLapse = 10000;
        this.turnOn = false;
        this.nome = "MasterCardASensor";
    }

    private void getManagers() {
        this.i_IMasterCardManager =
                (IMasterCardManager) manager.getRequiredInterface("IMasterCardManager");
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
                	//TODO: log("MasterCardA", "Error = MasterCardA Sensor " + e.toString());
					System.out.println("MasterCardA"+ "Error = MasterCardA Sensor " + e.toString());
                }
            }

        return true;
    }

    private void executeSensor() {
        getManagers();
        try{
            long startTime = System.currentTimeMillis();
			
			//TODO: needs to call a method from monitored interface
            //i_IMasterCardManager.businessMethod(param);
           // this.i_IMasterCardManager.pagarMaster(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao, parcelas);
			boolean resu = this.i_IMasterCardManager.getDisponibilidade();
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            if((totalTime>100 && resu == false) || (resu == false)){
                long timeSensorI= System.currentTimeMillis();
                
				//TODO: log("MasterCardA", "MasterCardA Sensor(Activated)I: "+timeSensorI+" " + nome + " Time: " + totalTime + " ");
                System.out.println("MasterCardA"+ "MasterCardA Sensor(Activated)I: "+timeSensorI+" " + nome + " Time: " + totalTime + " ");
                sensorUpdater.activateSensor(nome);

                long timeSensorF= System.currentTimeMillis();
                //TODO: log("MasterCardA", "MasterCardA Sensor(Activated)F: "+timeSensorF +" "+ nome + " Time: " + totalTime + " ");
                System.out.println("MasterCardA"+ "MasterCardA Sensor(Activated)F: "+timeSensorF +" "+ nome + " Time: " + totalTime + " ");
            }if(totalTime < 100 && resu == true){
                long timeSensorI= System.currentTimeMillis();
                //TODO: log("MasterCardA", "MasterCardA Sensor(Deactivated)I: " + timeSensorI + " ");
                System.out.println("MasterCardA"+"MasterCardA Sensor(Deactivated)I: " + timeSensorI + " ");
                sensorUpdater.deactivateSensor(nome);

                long timeSensorF= System.currentTimeMillis();
                //TODO: log("MasterCardA", "MasterCardA Sensor(Deactivated)F: " + timeSensorF + " ");
                System.out.println("MasterCardA"+ "MasterCardA Sensor(Deactivated)F: " + timeSensorF + " ");
            }
        }catch (Exception e){
			// the component has a error
			e.printStackTrace();
            //TODO: log("MasterCardA", "MasterCardA Sensor Catch -> " + e.toString());
			System.out.println("MasterCardA"+ "MasterCardA Sensor Catch -> " + e.toString());
            
			long timeSensorI= System.currentTimeMillis();
            //TODO: log("MasterCardA", "MasterCardA Sensor(Activated)I: " + timeSensorI + " ");
			System.out.println("MasterCardA"+ "MasterCardA Sensor(Activated)I: " + timeSensorI + " ");
            
			sensorUpdater.activateSensor(nome);

            long timeSensorF= System.currentTimeMillis();
            //TODO: log("MasterCardA", "MasterCardA Sensor(Activated)F: " + timeSensorF + " ");
            System.out.println("MasterCardA"+"MasterCardA Sensor(Activated)F: " + timeSensorF + " ");
        }
    }

    public synchronized boolean deactivateSensor() {
        getManagers();
        this.turnOn = false;
        return true;
    }
}