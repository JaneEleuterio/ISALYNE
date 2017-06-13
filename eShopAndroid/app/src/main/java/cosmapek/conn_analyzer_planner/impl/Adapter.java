package cosmapek.conn_analyzer_planner.impl;

import cosmapek.conn_analyzer_planner.prov.IManager;

import java.util.LinkedList;

class Adapter implements cosmapek.planner.req.IAnalysisManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized LinkedList<String> getFailedFeatures() {
        cosmapek.analyzer.prov.IAnalysisManager compAnalyzer =
            (cosmapek.analyzer.prov.IAnalysisManager) this.manager.getRequiredInterface(IAnalysisManagerTag);

        return compAnalyzer.getFailedFeatures();
    }
}
