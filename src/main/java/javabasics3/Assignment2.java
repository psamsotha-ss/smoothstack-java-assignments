package javabasics3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import core.Argument;
import core.Assignment;
import core.Group;

/**
 * Write a Java program to append text to an existing file.
 */
public class Assignment2 implements Assignment {

    public static void main(String... args) {
        if (args.length != 2) {
            System.out.println(new Assignment2().getUsage());
            return;
        }
        String filePath = args[0];
        String appendStr = args[1];

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("'" + filePath + "' does not exist.");
            return;
        }
        if (file.isDirectory()) {
            System.out.println("'" + filePath + "' is a directory.");
            return;
        }

        try {
            appendToFile(file, appendStr);
        } catch (IOException ex) {
            System.err.println("Could not write to file.");
            System.err.println(ex.getMessage());
        }
    }

    private static void appendToFile(File file, String appendStr) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), StandardOpenOption.APPEND)) {
            writer.write(appendStr);
            writer.newLine();
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
        return "Assignment 2";
    }

    @Override
    public String getDetails() {
        return "Write a Java program to append text to an existing file.";
    }

    @Override
    public String getUsage() {
        return "Usage: java -cp target/classes javabasics3.Assignment2 <file> \"<string to append>\"";
    }

    @Override
    public List<Argument> getArguments() {
        return Arrays.asList(
                new Argument(1, "file", "(str) the file to append to"),
                new Argument(2, "string", "(str) the string to append to file"));
    }
}
