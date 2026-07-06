public class TwoSum{

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> m = new HashMap<>();

        for(int i=0;i< nums.length;i++){
            int complement = target - nums[i];
            if(m.containsKey(complement)){
                return new int[] {m.get(complement),i};
            }

            m.put(i,nums[i]);
        }

    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }

}