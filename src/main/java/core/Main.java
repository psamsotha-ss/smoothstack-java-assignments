package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Main {

    public static void main(String... args) throws IOException, InterruptedException {
        System.out.println();
        System.out.println(colorize("Smoothstack Core Java Assignments", Attribute.BRIGHT_GREEN_TEXT(), Attribute.BOLD()));
        System.out.println(colorize("---------------------------------", Attribute.BRIGHT_GREEN_TEXT(), Attribute.BOLD()));
        List<Assignment> assignmentsList = getAssignmentsList();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println();
            System.out.println(colorize("Assignments:", Attribute.BRIGHT_YELLOW_TEXT(), Attribute.BOLD()));
            printAssignments(assignmentsList);
            System.out.println();

            System.out.print(colorize("Make a selection (or 'q' to quit): ", Attribute.YELLOW_TEXT(), Attribute.BOLD()));
            String input = in.readLine();
            if ("q".equals(input)) {
                System.exit(0);
            }

            try {
                int option = Integer.parseInt(input);
                if (option > (assignmentsList.size() - 1) || option < 0) {
                    System.out.println(input + " is not a valid option.");
                    continue;
                }
                Assignment assignment = assignmentsList.get(option);
                runAssignment(assignment, in);
            } catch (NumberFormatException ex) {
                System.out.println(input + " is not a valid option.");
            }
        }
    }

    private static void runAssignment(Assignment assignment, BufferedReader in) throws IOException {
        System.out.println();
        System.out.println(colorize("Details:", Attribute.BRIGHT_MAGENTA_TEXT(), Attribute.BOLD()));
        System.out.println(colorize(assignment.getDetails(), Attribute.MAGENTA_TEXT()));
        System.out.println();
        System.out.print(colorize("Would you like to run [Y/n]? ", Attribute.YELLOW_TEXT(), Attribute.BOLD()));
        String input = in.readLine().trim();
        if ("n".equalsIgnoreCase(input)) {
            return;
        }
        System.out.println();

        List<Argument> arguments = assignment.getArguments();
        String[] args = new String[arguments.size()];
        if (!arguments.isEmpty()) {
            System.out.println(colorize("Program arguments:", Attribute.YELLOW_TEXT()));
            for (Argument arg: arguments) {
                System.out.print(colorize("  " + arg.getName(), Attribute.RED_TEXT()));
                System.out.print(" - " + arg.getDescription() + ": ");
                String argInput = in.readLine().trim();
                if (arg.isList()) {
                    args = argInput.split("\\s+");
                    break;
                }
                args[arg.getPosition() - 1] = argInput;
            }
        }
        System.out.println();
        assignment.run(args);
    }

    private static void printAssignments(List<Assignment> assignments) {
        int index = 0;
        for (Group group: Group.values()) {
            List<Assignment> groupAssignments = assignments.stream()
                    .filter(a -> a.getGroup().equals(group))
                    .collect(Collectors.toList());
            if (!groupAssignments.isEmpty()) {
                System.out.println(group.getName());
                for (Assignment assignment: groupAssignments) {
                    System.out.println("  " + index + ") " + assignment.getName());
                    index++;
                }
            }
        }
    }

    private static List<Assignment> getAssignmentsList() {
        return Arrays.asList(
                new javabasics1.Assignment1_01(),
                new javabasics1.Assignment1_02(),
                new javabasics1.Assignment1_03(),
                new javabasics1.Assignment1_04(),
                new javabasics1.Assignment2(),

                new javabasics2.Assignment1(),
                new javabasics2.Assignment2(),
                new javabasics2.Assignment3(),

                new javabasics3.Assignment1()
        );
    }
}
