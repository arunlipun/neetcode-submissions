class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;
        int l=0;
        int r=n-1;
        int maxarea=0;
        while(l<r){
            maxarea=Math.max(maxarea,(r-l)*Math.min(heights[l],heights[r]));
            if(heights[l]<heights[r]){
                l++;
            }else{
                r--;
            }

        }
        return maxarea;
        
    }
}
