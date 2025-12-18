class Solution {
    public void sortIt(int[] arr) {
        // code here
        List<Integer> odd=new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for(int x:arr){
            if(x%2!=0){
                odd.add(x);
            }else{
            even.add(x);
        }
        }
        Collections.sort(odd,Collections.reverseOrder());
        Collections.sort(even);
        int index=0;
        for(int x:odd){
            arr[index++]=x;
        }
        for(int x:even){
            arr[index++]=x;
        }
    }
}
