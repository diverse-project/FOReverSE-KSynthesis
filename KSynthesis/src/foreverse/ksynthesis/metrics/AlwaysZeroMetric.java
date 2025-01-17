package foreverse.ksynthesis.metrics;

import foreverse.ksynthesis.KSynthesisPlugin;
import foreverse.ksynthesis.SimpleHeuristic;

public class AlwaysZeroMetric extends SimpleHeuristic implements KSynthesisPlugin {

	@Override
	public String getName() {
		return "Always Zero";
	}
	
	@Override
	public double similarity(String child, String parent) {
		return 0;
	}
	
	@Override
	public String toString() {
		return getName();
	}

}
