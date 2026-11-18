class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count[]=new int[k];
        count[0]=1;
        int sum=0,ans=0;
        for(int i:nums){
            sum=((sum+i)%k + k)%k;
            ans+=count[sum];
            count[sum]++;
        }
        return ans;
        
    }
}