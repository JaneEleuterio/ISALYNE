package visaBSensor.core;

import visaBSensor.prov.IManager;
import visaBSensor.req.IVisaManager;
import visaBSensor.req.ISensorUpdater;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaB
 * Component: VisaBSensor
 *
 * This class is a part of the VisaBSensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'VisaBSensor'. 
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
        this.nome = "VisaBSensor";
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
                	//TODO: log("VisaB", "Error = VisaB Sensor " + e.toString());
					System.out.println("VisaB"+"Error = VisaB Sensor " + e.toString());
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
			//this.i_IVisaManager.pagarVisa(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao, parcelas);
            boolean resu = this.i_IVisaManager.getDisponibilidade();
            
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            if(totalTime < 500 && resu == true){
                long timeSensorI= System.currentTimeMillis();
                //TODO: log("VisaB", "VisaB Sensor(Deactivated)I: " + timeSensorI + " ");
                System.out.println("VisaB"+ "VisaB Sensor(Deactivated)I: " + timeSensorI + " ");
                sensorUpdater.deactivateSensor(nome);

                long timeSensorF= System.currentTimeMillis();
                //TODO: log("VisaB", "VisaB Sensor(Deactivated)F: " + timeSensorF + " ");
                System.out.println("VisaB" + "VisaB Sensor(Deactivated)F: " + timeSensorF + " ");
            }else if(totalTime>500 && resu == true){
                long timeSensorI= System.currentTimeMillis();
                
				//TODO: log("VisaB", "VisaB Sensor(Activated)I: "+timeSensorI+" " + nome + " Time: " + totalTime + " ");
                System.out.println("VisaB"+"VisaB Sensor(Activated)I: "+timeSensorI+" " + nome + " Time: " + totalTime + " ");
                sensorUpdater.activateSensor(nome);
                //System.out.println("*****************");
                //System.out.println("LENTO VISA B");
                //System.out.println("*****************");

                long timeSensorF= System.currentTimeMillis();
                //TODO: log("VisaB", "VisaB Sensor(Activated)F: "+timeSensorF +" "+ nome + " Time: " + totalTime + " ");
                System.out.println("VisaB" +"VisaB Sensor(Activated)F: "+timeSensorF +" "+ nome + " Time: " + totalTime + " ");
            }else if(resu == false){
            	long timeSensorI= System.currentTimeMillis();
                
				//TODO: log("VisaB", "VisaB Sensor(Activated)I: "+timeSensorI+" " + nome + " Time: " + totalTime + " ");
                System.out.println("VisaB"+"VisaB Sensor(Activated)I: "+timeSensorI+" " + nome + " Time: " + totalTime + " ");
                sensorUpdater.activateSensor(nome);
                //System.out.println("*****************");
                //System.out.println("SEM RESPOSTA VISA B");
                //System.out.println("*****************");

                long timeSensorF= System.currentTimeMillis();
                //TODO: log("VisaB", "VisaB Sensor(Activated)F: "+timeSensorF +" "+ nome + " Time: " + totalTime + " ");
                System.out.println("VisaB" +"VisaB Sensor(Activated)F: "+timeSensorF +" "+ nome + " Time: " + totalTime + " ");
            }
        }catch (Exception e){
			// the component has a error
			e.printStackTrace();
            //TODO: log("VisaB", "VisaB Sensor Catch -> " + e.toString());
            System.out.println("VisaB"+"VisaB Sensor Catch -> " + e.toString());
			long timeSensorI= System.currentTimeMillis();
            //TODO: log("VisaB", "VisaB Sensor(Activated)I: " + timeSensorI + " ");
            System.out.println("VisaB"+"VisaB Sensor(Activated)I: " + timeSensorI + " ");
			sensorUpdater.activateSensor(nome);

            long timeSensorF= System.currentTimeMillis();
            //TODO: log("VisaB", "VisaB Sensor(Activated)F: " + timeSensorF + " ");
            System.out.println("VisaB"+"VisaB Sensor(Activated)F: " + timeSensorF + " ");
        }
    }

    public synchronized boolean deactivateSensor() {
        getManagers();
        this.turnOn = false;
        return true;
    }
}