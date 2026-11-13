class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n>m)return false;
        int freq[]=new int[26];
        int window[]=new int[26];

        for(int i=0;i<n;i++){
            freq[s1.charAt(i)- 'a']++;
            window[s2.charAt(i)-'a']++;

            

        }
        for(int i=n;i<m;i++){
            if(Arrays.equals(freq,window)){
                return true;
            }
            window[s2.charAt(i)-'a']++;
            window[s2.charAt(i-n)-'a']--;
        }
        return Arrays.equals(freq,window);
        
    }
}
