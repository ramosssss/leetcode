package org.example.thinkinjava.chapter21;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: leetcode
 * @description:
 * @author: Yuyang
 * @create: 2020-07-23 13:27
 */
public class Demo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

    }

}

class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        return "result of TaskWithResult " + id;
    }
}