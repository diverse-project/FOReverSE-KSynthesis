package foreverse.ksynthesis.metrics;

import fr.familiar.experimental.FGroup;
import gsd.graph.ImplicationGraph;

import java.util.Set;

import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;
import uk.ac.shef.wit.simmetrics.similaritymetrics.Levenshtein;
import uk.ac.shef.wit.simmetrics.similaritymetrics.SmithWaterman;

public class SimmetricsMetric implements FeatureSimilarityMetric {

	private AbstractStringMetric metric;


	public SimmetricsMetric(AbstractStringMetric metric) {
		this.metric = metric;
	}

	public SimmetricsMetric(MetricName metricName) {
		setMetric(metricName);
	}

	@Override
	public double similarity(ImplicationGraph<String> implicationGraph, Set<FGroup> xorGroups, Set<FGroup> orGroups, String featureName1, String featureName2) {
		return metric.getSimilarity(featureName1, featureName2);
	}


	public AbstractStringMetric getMetric() {
		return metric;
	}

	public void setMetric(AbstractStringMetric metric) {
		this.metric = metric;
	}

	public void setMetric(MetricName metricName) {
		switch (metricName) {
		case SIMMETRICS_SMITHWATERMAN:
			metric = new SmithWaterman();
			break;
		case SIMMETRICS_LEVENSHTEIN:
			metric = new Levenshtein();
			break;
		default:
			metric = new SmithWaterman();
			break;
		}
	}

	@Override
	public String toString() {
		return "Simmetrics metric (" + metric.getShortDescriptionString() + ")";
	}

	@Override
	public boolean isXorGroupRequired() {
		return false;
	}

	@Override
	public boolean isOrGroupRequired() {
		return false;
	}

}
