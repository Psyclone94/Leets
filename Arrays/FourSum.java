import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        int n = nums.length;

        // Step 2: Fix the first number
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 3: Fix the second number
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate values for j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                // Step 4: Two-pointer search
                while (left < right) {

                    long sum = (long) nums[i]
                            + nums[j]
                            + nums[left]
                            + nums[right];

                    if (sum == target) {

                        result.add(
                                Arrays.asList(
                                        nums[i],
                                        nums[j],
                                        nums[left],
                                        nums[right]
                                )
                        );

                        left++;
                        right--;

                        // Skip duplicate left values
                        while (left < right
                                && nums[left] == nums[left - 1]) {

                            left++;
                        }

                        // Skip duplicate right values
                        while (left < right
                                && nums[right] == nums[right + 1]) {

                            right--;
                        }

                    } else if (sum < target) {

                        // Need a larger sum
                        left++;

                    } else {

                        // Need a smaller sum
                        right--;
                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;

        List<List<Integer>> result1 =
                fourSum(nums1, target1);

        System.out.println("Example 1:");
        System.out.println(result1);


        System.out.println();


        // Example 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;

        List<List<Integer>> result2 =
                fourSum(nums2, target2);

        System.out.println("Example 2:");
        System.out.println(result2);
    }
}