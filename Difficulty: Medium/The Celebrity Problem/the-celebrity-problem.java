class Solution {
    public int celebrity(int[][] mat) {
        int n = mat.length;
        int a = 0, b = n - 1;

        // Find candidate
        while (a < b) {
            if (mat[a][b] == 1) a++;   // a knows b -> a not celebrity
            else b--;                  // a doesn't know b -> b not celebrity
        }
        int cand = a;

        // Verify candidate
        for (int i = 0; i < n; i++) {
            if (i == cand) continue;
            if (mat[cand][i] == 1) return -1;  // celebrity knows no one
            if (mat[i][cand] == 0) return -1;  // everyone knows celebrity
        }
        return cand;
    }
}
