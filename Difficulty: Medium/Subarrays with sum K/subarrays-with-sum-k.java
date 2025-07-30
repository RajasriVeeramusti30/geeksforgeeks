import java.util.*;

class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // Map to store the prefix sum and their frequency
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;

        // Add base case: sum = 0 has frequency 1
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If (sum - k) is in the map, we found a subarray
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Update the map with current sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
