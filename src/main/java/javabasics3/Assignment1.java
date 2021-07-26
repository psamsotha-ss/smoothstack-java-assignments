package javabasics3;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import core.Argument;
import core.Assignment;
import core.Group;

/**
 * Write a Java program to get a list of all file/directory names
 * (including in subdirectories) under a given directory.
 */
public class Assignment1 implements Assignment {

    private static final String DEFAULT_DIR = ".";

    public static void main(String... args) {
        String dir = args.length > 0
                ? "".equals(args[0].trim()) ? DEFAULT_DIR : args[0].trim()
                : DEFAULT_DIR;
        Path path = Paths.get(dir);
        File file = path.toFile();

        if (!file.exists() || !file.isDirectory()) {
            System.out.println("'" + dir + "' does not exist or is not a directory");
            return;
        }

        getFilePaths(file).stream()
                .sorted().forEach(System.out::println);
    }

    private static List<String> getFilePaths(File dir) {
        List<String> paths = new ArrayList<>();
        collectFilePaths(dir, dir.toPath(), paths);
        return paths;
    }

    private static void collectFilePaths(File file, Path rootDir, List<String> paths) {
        paths.add(rootDir.relativize(file.toPath())
                + (file.isDirectory() ? File.separator : ""));
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f: files) {
                    collectFilePaths(f, rootDir, paths);
                }
            }
        }
    }

    @Override
    public void run(String... args) {
        main(args);
    }

    @Override
    public Group getGroup() {
        return Group.THREE;
    }

    @Override
    public String getName() {
        return "Assignment 1";
    }

    @Override
    public String getDetails() {
        return "Write a Java program to get a list of all file/directory names" + System.lineSeparator() +
                "(including in subdirectories) under a given directory.";
    }

    @Override
    public String getUsage() {
        return "Usage: java -cp target/classes javabasics3.Assignment1 <dir>";
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.singletonList(new Argument(1, "directory", "(str) the root directory"));
    }
}
