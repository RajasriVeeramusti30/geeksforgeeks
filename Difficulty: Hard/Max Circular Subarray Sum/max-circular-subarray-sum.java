class Solution {
    public int maxCircularSum(int[] arr) {
        int totalSum = 0;
        int maxSum = arr[0], currMax = arr[0];
        int minSum = arr[0], currMin = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSum = Math.max(maxSum, currMax);
            
            currMin = Math.min(arr[i], currMin + arr[i]);
            minSum = Math.min(minSum, currMin);
            
            totalSum += arr[i];
        }
        totalSum += arr[0];
        
        if (totalSum == minSum) return maxSum;
        return Math.max(maxSum, totalSum - minSum);
    }
}
