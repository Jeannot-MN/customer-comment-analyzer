package com.ikhokha.techcheck.builder.abstraction;

import java.util.Map;

public abstract class KeyWordMetricBuilder extends MetricBuilder {

    @Override
    public void build(String line, Map<String, Integer> resultsMap) {

        if (line.toLowerCase().contains(getKeyWord().toLowerCase())) {
            incOccurrence(resultsMap);
        }

    }

    protected abstract String getKeyWord();
}
