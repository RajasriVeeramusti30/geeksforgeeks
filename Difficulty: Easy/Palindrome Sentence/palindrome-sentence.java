class Solution {
    public boolean isPalinSent(String s) {
        StringBuilder st = new StringBuilder();
            for(char ch : s.toCharArray()){
                if(Character.isLetterOrDigit(ch)){
                    st.append(Character.toLowerCase(ch));
                }
            }
            int left=0;
            int right=st.length() - 1;
            while(left<right){
                if(st.charAt(left) != st.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
