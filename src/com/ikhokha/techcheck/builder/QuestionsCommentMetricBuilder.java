package com.ikhokha.techcheck.builder;

import com.ikhokha.techcheck.builder.abstraction.KeyWordMetricBuilder;

public class QuestionsCommentMetricBuilder extends KeyWordMetricBuilder {

    private static final String SHAKER_KEYWORD = "?";
    private static final String METRIC_KEY = "QUESTIONS";

    @Override
    protected String getMetricKey() {
        return METRIC_KEY;
    }

    @Override
    protected String getKeyWord() {
        return SHAKER_KEYWORD;
    }
}
