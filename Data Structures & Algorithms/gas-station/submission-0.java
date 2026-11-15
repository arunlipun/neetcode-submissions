class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas=0,totalcost=0;
        for(int g:gas)totalgas+=g;
        for(int c:cost)totalcost+=c;
        if(totalcost>totalgas)return -1;
        int totalfuel=0,startindex=0;
        for(int i=0;i<gas.length;i++){
            totalfuel+=gas[i]-cost[i];
            if(totalfuel<0){
                startindex=i+1;
                totalfuel=0;
            }
        }
        return startindex;
        
    }
}
