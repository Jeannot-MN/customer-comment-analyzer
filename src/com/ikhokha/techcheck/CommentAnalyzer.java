package com.ikhokha.techcheck;

import com.ikhokha.techcheck.builder.MoverCommentMetricBuilder;
import com.ikhokha.techcheck.builder.QuestionsCommentMetricBuilder;
import com.ikhokha.techcheck.builder.ShakerCommentMetricBuilder;
import com.ikhokha.techcheck.builder.ShortCommentMetricBuilder;
import com.ikhokha.techcheck.builder.SpamCommentMetricBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommentAnalyzer {

    private File file;

    private final ShortCommentMetricBuilder shortCommentMetricBuilder;
    private final ShakerCommentMetricBuilder shakerCommentMetricBuilder;
    private final MoverCommentMetricBuilder moverCommentMetricBuilder;
    private final QuestionsCommentMetricBuilder questionsCommentMetricBuilder;
    private final SpamCommentMetricBuilder spamCommentMetricBuilder;

    public CommentAnalyzer(File file) {
        this.file = file;
        moverCommentMetricBuilder = new MoverCommentMetricBuilder();
        shakerCommentMetricBuilder = new ShakerCommentMetricBuilder();
        shortCommentMetricBuilder = new ShortCommentMetricBuilder();
        questionsCommentMetricBuilder = new QuestionsCommentMetricBuilder();
        spamCommentMetricBuilder = new SpamCommentMetricBuilder();
    }

    public Map<String, Integer> analyze() {

        Map<String, Integer> resultsMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line = null;
            while ((line = reader.readLine()) != null) {
                shortCommentMetricBuilder.build(line, resultsMap);
                shakerCommentMetricBuilder.build(line, resultsMap);
                moverCommentMetricBuilder.build(line, resultsMap);
                spamCommentMetricBuilder.build(line, resultsMap);
                questionsCommentMetricBuilder.build(line, resultsMap);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Error processing file: " + file.getAbsolutePath());
            e.printStackTrace();
        }

        return resultsMap;
    }
}
