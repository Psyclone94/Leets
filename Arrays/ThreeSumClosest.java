import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Initialize closestSum using the first three elements
        int closestSum = nums[0] + nums[1] + nums[2];

        // Step 2: Fix one element
        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            // Step 3: Two-pointer search
            while (left < right) {

                int currentSum =
                        nums[i] + nums[left] + nums[right];

                // Check whether currentSum is closer to target
                if (Math.abs(currentSum - target)
                        < Math.abs(closestSum - target)) {

                    closestSum = currentSum;
                }

                // Exact target found
                if (currentSum == target) {

                    return currentSum;

                } else if (currentSum < target) {

                    // Need a larger sum
                    left++;

                } else {

                    // Need a smaller sum
                    right--;
                }
            }
        }

        return closestSum;
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;

        int result1 = threeSumClosest(nums1, target1);

        System.out.println("Example 1:");
        System.out.println("Closest Suum = " + result1);


        System.out.println();


        // Example 2
        int[] nums2 = {0, 0, 0};
        int target2 = 1;

        int result2 = threeSumClosest(nums2, target2);

        System.out.println("Example 2:");
        System.out.println("Closest Sum = " + result2);
    }
}
