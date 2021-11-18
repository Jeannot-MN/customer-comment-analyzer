package com.ikhokha.techcheck.builder.abstraction;

import java.util.Map;

public abstract class MetricBuilder {

    public abstract void build(String line, Map<String, Integer> resultsMap);

    /**
     * This method increments a counter by 1 for a match type on the countMap. Uninitialized keys will be set to 1
     * @param countMap the map that keeps track of counts
     */
    protected void incOccurrence(Map<String, Integer> countMap) {
        String key = getMetricKey();
        countMap.putIfAbsent(key, 0);
        countMap.put(key, countMap.get(key) + 1);
    }

    protected abstract String getMetricKey();
}
