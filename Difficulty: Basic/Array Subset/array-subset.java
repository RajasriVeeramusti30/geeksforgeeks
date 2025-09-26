class Solution {
    public boolean isSubset(int a[], int b[]) {
        // Step 1: Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;

        // Step 2: Traverse both arrays
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                // Found a match, move both
                i++;
                j++;
            } else if (a[i] < b[j]) {
                // Move in 'a' until we find b[j]
                i++;
            } else {
                // a[i] > b[j], means b[j] not in a[]
                return false;
            }
        }

        // If all elements of b[] were found
        return j == b.length;
    }
}

