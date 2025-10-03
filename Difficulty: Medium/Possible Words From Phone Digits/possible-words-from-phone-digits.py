class Solution:
    def possibleWords(self, arr):
        # mapping digits to characters
        n2c = {
            2:'abc', 3:'def', 4:'ghi', 5:'jkl',
            6:'mno', 7:'pqrs', 8:'tuv', 9:'wxyz'
        }
        
        cur = []
        ret = []
        
        def dfs(ix=len(arr)-1):
            if ix < 0:
                ret.append("".join(cur[::-1]))
                return
            if arr[ix] in n2c:
                for c in n2c[arr[ix]]:
                    cur.append(c)
                    dfs(ix-1)
                    cur.pop()
            else:
                dfs(ix-1)
        
        # start recursion
        dfs()
        return ret
