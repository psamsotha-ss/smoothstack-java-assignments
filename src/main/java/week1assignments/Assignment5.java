package week1assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import core.Argument;
import core.Assignment;
import core.Group;

/**
 * Given an array of ints, is it possible to choose a group of some of the ints,
 * such that the group sums to the given target, with this additional constraint:
 * if there are numbers in the array that are adjacent and the identical value,
 * they must either all be chosen, or none of them chosen.
 *
 * For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle
 * must be chosen or not, all as a group. (one loop can be used to find the extent of the identical values).
 *
 * groupSumClump(0, [2, 4, 8], 10) → true
 * groupSumClump(0, [1, 2, 4, 8, 1], 14) → true
 * groupSumClump(0, [2, 4, 4, 8], 14) → false
 */
public class Assignment5 implements Assignment {

    public static void main(String... args) {
        Assignment5 assignment = new Assignment5();

        runOperation(new int[] { 2, 4, 8}, 10, assignment);
        runOperation(new int[] { 1, 2, 4, 8, 1 }, 14, assignment);
        runOperation(new int[] { 2, 4, 4, 8 }, 14, assignment);
    }

    private static void runOperation(int[] arr, int targetSum, Assignment5 assignment) {
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("  target sum: " + targetSum + "; " + assignment.groupSumClump(0, arr, targetSum));
    }

    public boolean groupSumClump(int index, int[] arr, int targetSum) {
        int[] flattened = flattenArray(arr);
        return groupSum(index, flattened, targetSum);
    }

    private static boolean groupSum(int index, int[] arr, int targetSum) {
        if (index >= arr.length) return targetSum == 0;
        if (groupSum(index + 1, arr, targetSum - arr[index])) return true;
        if (groupSum(index + 1, arr, targetSum)) return true;

        return false;
    }

    private static int[] flattenArray(int[] arr) {
        List<Integer> flattened = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int curr = arr[i];
            while (i < arr.length && curr == arr[i]) {
                sum += arr[i];
                i++;
            }
            i--;
            flattened.add(sum);
        }
        return flattened.stream().mapToInt(Integer::intValue).toArray();
    }

//    // https://github.com/mirandaio/codingbat/blob/master/java/recursion-2/groupSumClump.java
//    public boolean groupSumClump(int start, int[] nums, int target) {
//        if(start >= nums.length)
//            return target == 0;
//
//        int i = start;
//        int sum = 0;
//
//        while(i < nums.length && nums[start] == nums[i]) {
//            sum += nums[i];
//            i++;
//        }
//
//        if(groupSumClump(i, nums, target - sum))
//            return true;
//
//        if(groupSumClump(i, nums, target))
//            return true;
//
//        return false;
//    }

    @Override
    public void run(String... args) {
        main(args);
    }

    @Override
    public Group getGroup() {
        return Group.WEEK_ONE;
    }

    @Override
    public String getName() {
        return "Assignment 5";
    }

    @Override
    public String getDetails() {
        return "Given an array of ints, is it possible to choose a group of some of the ints,\n" +
                "such that the group sums to the given target, with this additional constraint:\n" +
                "if there are numbers in the array that are adjacent and the identical value,\n" +
                "they must either all be chosen, or none of them chosen.";
    }

    @Override
    public String getUsage() {
        return "Usage: java -cp target/classes week1assignments.Assignment5";
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.emptyList();
    }
}
