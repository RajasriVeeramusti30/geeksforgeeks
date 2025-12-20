class Solution {
    public int searchInsertK(int arr[], int k) {
        // code here
        int n=arr.length;
        for(int i=0;i<n;i++){
            if (arr[i]>=k){
                return i;
            }
        }
        return n;
    }
}