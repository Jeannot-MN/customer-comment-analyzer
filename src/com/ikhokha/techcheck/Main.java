package com.ikhokha.techcheck;

import com.ikhokha.techcheck.thread.WorkerThread;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int MAX_NUMBER_OF_THREADS = 5;

    public static void main(String[] args) {

        Map<String, Integer> totalResults = new HashMap<>();

        File docPath = new File("docs");
        File[] commentFiles = docPath.listFiles((d, n) -> n.endsWith(".txt"));

        ExecutorService executor = Executors.newFixedThreadPool(MAX_NUMBER_OF_THREADS);
        for (File commentFile : commentFiles) {

            Runnable worker = new WorkerThread(commentFile, totalResults);
            executor.execute(worker);

        }
        executor.shutdown();
        while (!executor.isTerminated()) {

        }

        System.out.println("RESULTS\n=======");
        totalResults.forEach((k, v) -> System.out.println(k + " : " + v));
    }

}
