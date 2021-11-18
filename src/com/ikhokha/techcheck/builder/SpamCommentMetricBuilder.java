package com.ikhokha.techcheck.builder;

import com.ikhokha.techcheck.builder.abstraction.PatternMatcherMetricBuilder;

import java.util.regex.Pattern;

public class SpamCommentMetricBuilder extends PatternMatcherMetricBuilder {

    private static final String URL_REGEX = "((http:\\/\\/|https:\\/\\/)?(www.)?(([a-zA-Z0-9-]){2,}\\.){1,4}([a-zA-Z]){2,6}(\\/([a-zA-Z-_\\/\\.0-9#:?=&;,]*)?)?)";
    private static final String METRIC_KEY = "SPAM";

    @Override
    protected String getMetricKey() {
        return METRIC_KEY;
    }

    @Override
    protected Pattern getPattern() {
        return Pattern.compile(URL_REGEX);
    }
}
