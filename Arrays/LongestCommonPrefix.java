public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        // Assume the first string is the common prefix
        String prefix = strs[0];

        // Compare the prefix with every other string
        for (int i = 1; i < strs.length; i++) {

            // Keep reducing the prefix until the current string
            // starts with it
            while (!strs[i].startsWith(prefix)) {

                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }


    public static void main(String[] args) {

        // Example 1
        String[] strs1 = {
                "flower",
                "flow",
                "flight"
        };

        String result1 = longestCommonPrefix(strs1);

        System.out.println("Example 1:");
        System.out.println("Longest Common Prefix: \"" + result1 + "\"");


        System.out.println();


        // Example 2
        String[] strs2 = {
                "dog",
                "racecar",
                "car"
        };

        String result2 = longestCommonPrefix(strs2);

        System.out.println("Example 2:");
        System.out.println("Longest Common Prefix: \"" + result2 + "\"");
    }
}