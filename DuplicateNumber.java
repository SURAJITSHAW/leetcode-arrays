import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    287. Find the Duplicate Number

    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

    There is only one repeated number in nums, return this repeated number.

    You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class DuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2, 5};
        int result = findDuplicate(nums);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }

    

    // Approach 1 : Sorting
    // public static int findDuplicate(int[] nums) {
    //     Arrays.sort(nums);
    //     for (int i = 1; i < nums.length; i++) {
    //         if (nums[i] == nums[i - 1]) {
    //             return nums[i];
    //         }
    //     }
    //     return -1;
    // }

    // Approach 2 : Set
    // private static int findDuplicate(int[] nums) {
    //     Set<Integer> seen = new HashSet<Integer>();

    //     for (int i : nums) {
    //         if (seen.contains(i)) {
    //             return i;
    //         }
    //         seen.add(i);
    //     }

    //     return -1;
    // }

    // Approach 3 : Set
    private static int findDuplicate(int[] nums) {
        int duplicateNum = -1;

        for (int i = 0; i < nums.length; i++) {
            int curr = Math.abs(nums[i]); // Current element
            if (nums[curr] < 0) {
                duplicateNum = curr;
                break;
            }
            nums[curr] *= -1;
        }

        // Restore the Array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return duplicateNum;
    }
}