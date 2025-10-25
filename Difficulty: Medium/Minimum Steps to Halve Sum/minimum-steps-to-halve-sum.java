class Solution {
    public int minOperations(int[] arr) {
        // code here
        int n = arr.length;

        double total = 0.0;
        for (int num : arr) {
            total += num;
        }

        double target = total / 2.0;

        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            pq.add((double) num);
        }

        int count = 0;

        while (total > target) {
            double top = pq.poll();
            total -= top / 2.0;
            pq.add(top / 2.0);
            count++;
        }

        return count;
    }
}


