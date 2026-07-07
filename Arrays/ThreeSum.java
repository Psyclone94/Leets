import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Fix one element
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Since array is sorted, no future triplet can sum to 0
            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;

            // Step 3: Two-pointer search
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(
                            Arrays.asList(
                                    nums[i],
                                    nums[left],
                                    nums[right]
                            )
                    );

                    left++;
                    right--;

                    // Skip duplicate values from the left
                    while (left < right &&
                            nums[left] == nums[left - 1]) {

                        left++;
                    }

                    // Skip duplicate values from the right
                    while (left < right &&
                            nums[right] == nums[right + 1]) {

                        right--;
                    }

                } else if (sum < 0) {

                    // Need a larger sum
                    left++;

                } else {

                    // Need a smaller sum
                    right--;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result1 = threeSum(nums1);

        System.out.println("Example 1:");
        System.out.println(result1);


        // Example 2
        int[] nums2 = {0, 1, 1};

        List<List<Integer>> result2 = threeSum(nums2);

        System.out.println("\nExample 2:");
        System.out.println(result2);


        // Example 3
        int[] nums3 = {0, 0, 0};

        List<List<Integer>> result3 = threeSum(nums3);

        System.out.println("\nExample 3:");
        System.out.println(result3);
    }
}