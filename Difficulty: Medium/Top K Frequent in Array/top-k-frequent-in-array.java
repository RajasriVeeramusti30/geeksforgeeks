import java.util.*;

class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequency
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Get all unique numbers
        ArrayList<Integer> nums = new ArrayList<>(freq.keySet());

        // Step 3: Sort them by frequency (desc), then number (desc)
        nums.sort((a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(b) - freq.get(a);  // higher freq first
            } else {
                return b - a;  // if freq same, larger number first
            }
        });

        // Step 4: Take first k numbers
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(nums.get(i));
        }

        return result;
    }
}
