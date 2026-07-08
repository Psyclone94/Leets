import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        // First element is always unique
        int k = 1;

        // Read pointer scans the array
        for (int i = 1; i < nums.length; i++) {

            // New unique element found
            if (nums[i] != nums[k - 1]) {

                nums[k] = nums[i];

                k++;
            }
        }

        return k;
    }


    public static void main(String[] args) {

        // Example 1
        int[] nums1 = {1, 1, 2};

        int k1 = removeDuplicates(nums1);

        System.out.println("Example 1:");
        System.out.println("k = " + k1);

        System.out.print("Unique elements: ");

        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");
        }


        System.out.println("\n");


        // Example 2
        int[] nums2 = {
                0, 0, 1, 1, 1,
                2, 2, 3, 3, 4
        };

        int k2 = removeDuplicates(nums2);

        System.out.println("Example 2:");
        System.out.println("k = " + k2);

        System.out.print("Unique elements: ");

        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");
        }
    }
}