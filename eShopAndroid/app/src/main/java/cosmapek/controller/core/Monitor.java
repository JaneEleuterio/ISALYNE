package cosmapek.controller.core;

import android.util.Log;

import cosmapek.controller.prov.IManager;
import cosmapek.controller.req.IAnalysisManager;
import cosmapek.controller.req.IExecutionManager;
import cosmapek.controller.req.IPlanningManager;

/**
 * @author Junior Cupe Casquina
 */
public class Monitor implements IInterfaceTags {
    private IManager manager;

    private long timeLapse;
    private String jarPath;

    private IAnalysisManager analyzer;
    private IExecutionManager executor;
    private IPlanningManager planner;

    public Monitor(IManager manager) {
        this.manager = manager;
        this.timeLapse = 5000;// 1 second(default)
        this.jarPath = "";
    }

    private void getManagers() {
        IManager mg = getManager();
        analyzer = (IAnalysisManager) mg.getRequiredInterface(IAnalysisManagerTag);
        executor = (IExecutionManager) mg.getRequiredInterface(IExecutionManagerTag);
        planner = (IPlanningManager) mg.getRequiredInterface(IPlanningManagerTag);
    }

    public synchronized void execute() {

        getManagers();
        long timeAnalyzerI= System.currentTimeMillis();
        Log.i("Eshop", "_Monitor_AnalyzerI: " + timeAnalyzerI+" ");
        analyzer.start();
        long timeAnalyzerF= System.currentTimeMillis();
        Log.i("Eshop", "_Monitor_AnalyzerF: "+timeAnalyzerF+" ");
        // logic of the framework
        //TODO: se tirar o if, forca a autoadaptacao sempre (com if: verifica se o sensor dectectou falha e entao adapta

        if(analyzer.hasActivatedRuntimeSensors()){
            long timePlanerIni= System.currentTimeMillis();
            Log.i("Eshop", "_Monitor_PlanerI: " + timePlanerIni+" ");
            planner.start();
            long timeExecutorIni= System.currentTimeMillis();
            Log.i("Eshop", "_Monitor_PlanerF: " + timeExecutorIni+" ");
            Log.i("Eshop", "_Monitor_ExecutorI: " + timeExecutorIni+" ");
            executor.setJarPath(getJarPath());
            executor.start();
            long timeExecutorFin= System.currentTimeMillis();
            Log.i("Eshop", "_Monitor_ExecutorF: " + timeExecutorFin+" ");
        }
    }

    public synchronized void setTimeLapse(long monitoringTimeLapse) {
        getManagers();
        this.timeLapse = monitoringTimeLapse;
    }

    public synchronized void monitor() {
        getManagers();
        //first revition
        analyzer.start();
        planner.start();
        executor.setJarPath(getJarPath());
        executor.start();
        while (true) {
            try {
                Thread.sleep(timeLapse);
                //this.wait(getTimeLapse());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.execute();
        }
    }

    public synchronized void setJarPath(String jarPath) {
        getManagers();
        this.jarPath = jarPath;
    }

    private  long getTimeLapse() {
        return timeLapse;
    }

    private IManager getManager() {
        return manager;
    }

    private String getJarPath() {
        return jarPath;
    }
}
