class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int end=0,minjump=0,maxindex=0;
        for(int i=0;i<n-1;i++){
            maxindex=Math.max(maxindex,i+nums[i]);
            if(i==end){

                minjump++;
                end=maxindex;
            }if(end>=n-1){
                break;
            }
        }
        return minjump;
        
    }
}
