class Solution:
    def kClosest(self, points, k):
        # code here
        points.sort(key=lambda x:(x[0]**2+x[1]**2)**0.5)
        return points[:k]