package com.ikhokha.techcheck.thread;

import com.ikhokha.techcheck.CommentAnalyzer;

import java.io.File;
import java.util.Map;

public class WorkerThread implements Runnable {

    private final File file;
    private Map<String, Integer> totalResults;

    public WorkerThread(File file, Map<String, Integer> totalResults) {
        this.file = file;
        this.totalResults = totalResults;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.");
        doWork();
        System.out.println(Thread.currentThread().getName() + "End.");
    }

    private void doWork(){
        CommentAnalyzer commentAnalyzer = new CommentAnalyzer(file);
        Map<String, Integer> fileResults = commentAnalyzer.analyze();
        addReportResults(fileResults, totalResults);
    }
    /**
     * This method adds the result counts from a source map to the target map
     * @param source the source map
     * @param target the target map
     */
    private static void addReportResults(Map<String, Integer> source, Map<String, Integer> target) {

        for (Map.Entry<String, Integer> entry : source.entrySet()) {
            target.putIfAbsent(entry.getKey(), 0);

            Integer totalCount = target.get(entry.getKey()) + entry.getValue();
            target.put(entry.getKey(), totalCount);
        }

    }

}
