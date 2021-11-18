package com.ikhokha.techcheck.builder;

import com.ikhokha.techcheck.builder.abstraction.MetricBuilder;

import java.util.Map;

public class ShortCommentMetricBuilder extends MetricBuilder {

    private static final int CHARACTER_THRESHOLD = 15;
    private static final String METRIC_KEY = "SHORTER_THAN_15";

    @Override
    public void build(String line, Map<String, Integer> resultsMap) {

        if (line.length() < CHARACTER_THRESHOLD) {
            incOccurrence(resultsMap);
        }
    }

    @Override
    protected String getMetricKey() {
        return METRIC_KEY;
    }
}
