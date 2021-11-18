package com.ikhokha.techcheck.builder;

import com.ikhokha.techcheck.builder.abstraction.KeyWordMetricBuilder;

public class ShakerCommentMetricBuilder extends KeyWordMetricBuilder {

    private static final String SHAKER_KEYWORD = "shaker";
    private static final String METRIC_KEY = "SHAKER_MENTIONS";

    @Override
    protected String getMetricKey() {
        return METRIC_KEY;
    }

    @Override
    protected String getKeyWord() {
        return SHAKER_KEYWORD;
    }
}
