import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;
        int prefixSum = 0;

        HashMap<Integer, Integer> firstOccurrence = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // Convert to +1 / -1
            if (arr[i] > k) {
                prefixSum += 1;
            } else {
                prefixSum -= 1;
            }

            // If prefix sum > 0, subarray [0..i] is valid
            if (prefixSum > 0) {
                maxLen = i + 1;
            } else {
                // Check if (prefixSum - 1) occurred before
                if (firstOccurrence.containsKey(prefixSum - 1)) {
                    int len = i - firstOccurrence.get(prefixSum - 1);
                    maxLen = Math.max(maxLen, len);
                }
            }

            // Store first occurrence of this prefix sum
            if (!firstOccurrence.containsKey(prefixSum)) {
                firstOccurrence.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
