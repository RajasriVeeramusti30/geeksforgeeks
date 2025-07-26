class Solution:
    def findMajority(self, arr):
        s = {}
        n = len(arr)
        size = n/3
        res = []
        for num in arr:
            if num not in s:
                s[num] = 1
            else:
                s[num] += 1
            if s[num] > size:
                res.append(num)
        res = list(set(res))
        res.sort()
        return res