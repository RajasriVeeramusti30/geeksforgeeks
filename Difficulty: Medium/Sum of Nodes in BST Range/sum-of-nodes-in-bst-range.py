"""
class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None
"""

class Solution:
    def nodeSum(self, root, l, r):
        # code here
        self.sum = 0
        if not root:
            return 0
        if l <= root.data <= r:
            self.sum += root.data
        return self.sum + self.nodeSum(root.left,l,r) + self.nodeSum(root.right,l,r)
        
        
        
