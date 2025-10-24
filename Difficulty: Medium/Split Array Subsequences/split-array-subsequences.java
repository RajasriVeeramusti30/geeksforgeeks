import java.util.*;

class Solution {
    public boolean isPossible(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return false;
        if (k <= 0) return false;
        // Note: don't require n % k == 0 here because subsequences can have length >= k
        Arrays.sort(arr);

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : arr) count.put(num, count.getOrDefault(num, 0) + 1);

        Map<Integer, Integer> need = new HashMap<>(); // need[x] = how many subsequences expect x next

        for (int num : arr) {
            if (count.getOrDefault(num, 0) == 0) continue;

            // if some subsequence expects `num`, extend it
            if (need.getOrDefault(num, 0) > 0) {
                need.put(num, need.get(num) - 1);
                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);
                count.put(num, count.get(num) - 1);
            } else {
                // try to start a new subsequence of length k: num, num+1, ..., num+k-1
                boolean canStart = true;
                for (int i = 0; i < k; i++) {
                    int nxt = num + i;
                    if (count.getOrDefault(nxt, 0) <= 0) {
                        canStart = false;
                        break;
                    }
                }
                if (!canStart) return false;
                // consume these k numbers
                for (int i = 0; i < k; i++) {
                    int nxt = num + i;
                    count.put(nxt, count.get(nxt) - 1);
                }
                // the newly created subsequence will next expect num+k (so it can be extended later)
                need.put(num + k, need.getOrDefault(num + k, 0) + 1);
            }
        }
        return true;
    }
}
