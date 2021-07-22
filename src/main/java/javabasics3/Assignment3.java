package javabasics3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import core.Argument;
import core.Assignment;
import core.Group;

/**
 * Write a Java program that counts the number of times a particular character, such as 'e',
 * appears in a file. The character can be specified at the command line.
 */
public class Assignment3 implements Assignment  {

    public static void main(String... args) {
        if (args.length != 2) {
            System.out.println(new Assignment3().getUsage());
            return;
        }
        String fileArg = args[0];
        String charArg = args[1];
        if (charArg.length() != 1) {
            System.out.println("Second argument must be a single character, e.g. e");
            return;
        }
        char ch = charArg.charAt(0);
        File file = new File(fileArg);
        if (!file.exists() || file.isDirectory()) {
            System.out.println(fileArg + " is not a file.");
            return;
        }

        try {
            int occurrences = getOccurrences(file, ch);
            System.out.println("'" + ch + "' occurs " + occurrences + " time"
                    + (occurrences > 1 || occurrences == 0 ? "s" : "") + " in " + fileArg);
        } catch (IOException e) {
            System.out.println("There was a problem reading the file.");
        }
    }

    private static int getOccurrences(File file, char ch) throws IOException {
        int occurrences = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                char[] chars = line.toCharArray();
                for (char c: chars) {
                    if (c == ch) {
                        occurrences++;
                    }
                }
            }
        }
        return occurrences;
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
        return "Assignment 3";
    }

    @Override
    public String getDetails() {
        return "Write a Java program that counts the number of times a particular character, such as 'e',\n" +
                "appears in a file. The character can be specified at the command line.";
    }

    @Override
    public String getUsage() {
        return "Usage: java -cp target/classes javabasics3.Assignment3 <file> <char>";
    }

    @Override
    public List<Argument> getArguments() {
        return Arrays.asList(
                new Argument(1, "file", "(str) the file to search"),
                new Argument(2, "character", "(str) the character to search for"));
    }
}
