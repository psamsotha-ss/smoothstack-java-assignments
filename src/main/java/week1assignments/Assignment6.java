package week1assignments;

import java.util.Collections;
import java.util.List;

import core.Argument;
import core.Assignment;
import core.Group;

public class Assignment6 implements Assignment {

    public static class SampleSingleton {

        private static SampleSingleton instance;

        private SampleSingleton() {}

        public static SampleSingleton getInstance() {
            if (instance == null) {
                synchronized (SampleSingleton.class) {
                    if (instance == null) {
                        instance = new SampleSingleton();
                    }
                }
            }
            return instance;
        }
    }

    @Override
    public void run(String... args) {
        System.out.println("-- SEE SOURCE CODE --");
    }

    @Override
    public Group getGroup() {
        return Group.WEEK_ONE;
    }

    @Override
    public String getName() {
        return "Assignment 6";
    }

    @Override
    public String getDetails() {
        return "Fix the Singleton:";
    }

    @Override
    public String getUsage() {
        return "Not runnable";
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.emptyList();
    }
}
