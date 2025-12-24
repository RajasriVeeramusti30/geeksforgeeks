class Solution {
    public int countLessEqual(int[] arr, int x) {
        // code here
        int count=0;
        int n =arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]<=x) count++;;
        }
        return count;
    }
}
