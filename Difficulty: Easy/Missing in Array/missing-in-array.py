#User function Template for python
class Solution:
    def missingNumber(self, arr):
        n = len(arr) + 1 
        xor1 = 0
        xor2 = 0
        for i in range(1, n + 1):
            xor1 ^= i
        for num in arr:
            xor2 ^= num

        return xor1 ^ xor2 


#{ 
 # Driver Code Starts
#Initial Template for Python 3

t = int(input())
for _ in range(0, t):
    arr = list(map(int, input().split()))
    s = Solution().missingNumber(arr)
    print(s)

    print("~")
# } Driver Code Ends