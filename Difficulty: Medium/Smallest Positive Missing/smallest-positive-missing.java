import java.util.*;
class Solution {
    public int missingNumber(int[] arr) {
        // code here
        HashSet<Integer>set = new HashSet<>();
        for(int num : arr){
            set.add(num);
        }
        for(int i=0;i<arr.length;i++){
            if(!set.contains(i+1))return i+1;
        }
        return arr[arr.length-1]+1;
    }
}