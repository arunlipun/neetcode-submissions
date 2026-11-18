class Solution {
    public List<Integer> partitionLabels(String s) {
         List<Integer> partition = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            // 1. Start at the current index 'i', not 0
            int startindex = i;
            int endindex = s.lastIndexOf(s.charAt(startindex));
            
            // 2. Increment 'j', not 'i'
            for (int j = startindex + 1; j <= endindex - 1; j++) {
                int lastIndexOfNextChar = s.lastIndexOf(s.charAt(j));
                if (lastIndexOfNextChar > endindex) {
                    endindex = lastIndexOfNextChar;
                }
            }
            
            partition.add(endindex - startindex + 1);
            
            // 3. Set 'i' to endindex so the loop's i++ moves it to endindex + 1
            i = endindex;
        } 
        
        return partition;
        
        
    }
}
