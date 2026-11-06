class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character>set =new HashSet<>();
        int n=s.length();
        int mxl=0;
        int l=0;
        for(int i=0;i<n;i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(l));
                l++;

            }
            set.add(s.charAt(i));
            mxl=Math.max(mxl,i-l+1);
        }
        return mxl;
    }
}
