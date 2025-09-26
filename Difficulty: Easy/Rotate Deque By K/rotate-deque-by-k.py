class Solution:    
    def rotateDeque(self, dq, type, k):
        k=len(dq) - k if type == 1 else k
        for i in range(k):
            dq.append(dq.popleft())
        return dq
        
