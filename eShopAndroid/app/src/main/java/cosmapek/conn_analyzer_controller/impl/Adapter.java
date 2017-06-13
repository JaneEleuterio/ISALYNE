package cosmapek.conn_analyzer_controller.impl;

import cosmapek.conn_analyzer_controller.prov.IManager;

class Adapter
    implements cosmapek.controller.req.IAnalysisManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void start() {
        cosmapek.analyzer.prov.IAnalysisManager compAnalyzer =
            (cosmapek.analyzer.prov.IAnalysisManager) this.manager.getRequiredInterface(IAnalysisManagerTag);
        compAnalyzer.start();
    }

    @Override
    public boolean hasActivatedRuntimeSensors() {
        cosmapek.analyzer.prov.IAnalysisManager compAnalyzer =
                (cosmapek.analyzer.prov.IAnalysisManager) this.manager.getRequiredInterface(IAnalysisManagerTag);
        return compAnalyzer.hasActivatedRuntimeSensors();
    }
/*
    @Override
    public boolean hasActivatedSensors() {
        cosmapek.analyzer.prov.IAnalysisManager compAnalyzer =
                (cosmapek.analyzer.prov.IAnalysisManager) this.manager.getRequiredInterface(IAnalysisManagerTag);
        return compAnalyzer.hasActivatedSensors();
    }*/
}
