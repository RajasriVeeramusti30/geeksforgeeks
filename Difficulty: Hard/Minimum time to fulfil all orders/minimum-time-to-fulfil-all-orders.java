class Solution {
    public boolean isPossible(int[] ranks,int mid,int n){
        int ans=0;
        for(int i:ranks){
            int mul=i;
            int start=1;
            int end=n;
            int temp=0;
            while(start<=end){
                int midd=start+(end-start)/2;
                if((midd*(midd+1)/2)*mul<=mid){
                    temp=midd;
                    start=midd+1;
                }
                else end=midd-1;
            }
            ans+=temp;
            if(ans>=n)
            return true;
            
        }
        return false;
    }
    public int minTime(int[] ranks, int n) {
        // code here
        Arrays.sort(ranks);
        int len=ranks.length;
        int min=0;
        int max=ranks[len-1]*((n*(n+1))/2);
        int ans=Integer.MAX_VALUE;
        while(min<=max){
            int mid=min+(max-min)/2;
            if(isPossible(ranks,mid,n)){
                ans=Math.min(mid,ans);
                max=mid-1;
            }
            else min=mid+1;
        }
        return ans;
        
    }
}