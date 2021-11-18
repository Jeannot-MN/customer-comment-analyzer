package com.ikhokha.techcheck.builder.abstraction;

import java.util.Map;
import java.util.regex.Pattern;

public abstract class PatternMatcherMetricBuilder extends MetricBuilder {

    @Override
    public void build(String line, Map<String, Integer> resultsMap) {

        if (getPattern().matcher(line).find()) {
            incOccurrence(resultsMap);
        }

    }

    protected abstract Pattern getPattern();
}
