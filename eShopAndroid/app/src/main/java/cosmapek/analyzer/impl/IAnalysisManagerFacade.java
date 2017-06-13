package cosmapek.analyzer.impl;

import cosmapek.analyzer.core.Analyzer;
import cosmapek.analyzer.core.AnalyzerFactory;
import cosmapek.analyzer.prov.IAnalysisManager;
import cosmapek.analyzer.prov.IManager;

import java.util.LinkedList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class IAnalysisManagerFacade implements IAnalysisManager {
    private IManager manager;
    private Analyzer analyzer;

    IAnalysisManagerFacade(IManager manager) {
        this.manager = manager;
        this.analyzer = AnalyzerFactory.createInstance(this.manager);
    }

    @Override public synchronized void start() {
        analyzer.start();
    }

    @Override
    public boolean hasActivatedSensors() {
        return analyzer.hasActivatedSensors();
    }

    @Override
    public boolean hasActivatedRuntimeSensors() {
        return analyzer.hasActivatedRuntimeSensors();
    }

    @Override public synchronized LinkedList<String> getFailedFeatures() {
        return analyzer.getFailedFeatures();
    }

}
