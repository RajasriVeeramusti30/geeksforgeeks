class Solution {
    public int minDifference(String[] arr) {
        int n = arr.length;
        int[] seconds = new int[n];

        // Convert time strings to total seconds
        for (int i = 0; i < n; i++) {
            String[] parts = arr[i].split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            int s = Integer.parseInt(parts[2]);
            seconds[i] = h * 3600 + m * 60 + s;
        }

        Arrays.sort(seconds);

        int minDiff = Integer.MAX_VALUE;

        // Compare adjacent times
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, seconds[i] - seconds[i - 1]);
        }

        // Wrap-around case: difference between last and first
        int wrapDiff = 86400 - seconds[n - 1] + seconds[0]; // 86400 = seconds in a day
        minDiff = Math.min(minDiff, wrapDiff);

        return minDiff;
    }
}