import java.util.*;

class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        Arrays.sort(prices);
        int n = prices.length;

        // Minimum cost: buy the cheapest; for each buy, you can skip k most expensive
        int start = 0, end = n - 1;
        int minCost = 0;
        while (start <= end) {
            minCost += prices[start++]; // buy cheapest available
            end -= k;                   // get k costliest free (remove from consideration)
        }

        // Maximum cost: buy the costliest; for each buy, you can skip k cheapest
        start = 0; 
        end = n - 1;
        int maxCost = 0;
        while (start <= end) {
            maxCost += prices[end--];   // buy costliest available
            start += k;                 // get k cheapest free (remove from consideration)
        }

        return new ArrayList<>(Arrays.asList(minCost, maxCost));
    }
}
