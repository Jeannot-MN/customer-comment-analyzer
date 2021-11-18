package com.ikhokha.techcheck.builder;

import com.ikhokha.techcheck.builder.abstraction.KeyWordMetricBuilder;

public class MoverCommentMetricBuilder extends KeyWordMetricBuilder {

    private static final String MOVER_KEYWORD = "mover";
    private static final String METRIC_KEY = "MOVER_MENTIONS";

    @Override
    protected String getMetricKey() {
        return METRIC_KEY;
    }

    @Override
    protected String getKeyWord() {
        return MOVER_KEYWORD;
    }
}
