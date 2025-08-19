class Solution:
    def farMin(self, arr):
        n = len(arr)

        # Step 1: Build suffix minima array
        suf = arr[:]   # suf[j] = min(arr[j..n-1])
        for j in range(n - 2, -1, -1):
            suf[j] = min(suf[j], suf[j + 1])

        # Step 2: Initialize answer array with -1
        ans = [-1] * n

        # Step 3: For each index i, binary search farthest j > i
        for i in range(n - 1):
            lo, hi, res = i + 1, n - 1, -1
            while lo <= hi:
                mid = (lo + hi) // 2
                if suf[mid] < arr[i]:
                    res = mid        # valid candidate
                    lo = mid + 1     # move right for farther j
                else:
                    hi = mid - 1
            ans[i] = res

        # Step 4: Last index always -1
        ans[-1] = -1
        return ans
