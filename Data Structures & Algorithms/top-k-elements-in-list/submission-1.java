class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //create a hashmap to store key valyue pair 
        Map<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer>[]bucket=new List[n+1];
        for(int key:map.keySet()){
            int freq=map.get(key);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int []result=new int[k];
        int index=0;
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                for(int num:bucket[i]){
                    result[index]=num;
                    index++;
                    if(index==k){
                        return result;
                    }
                }
            }
        }
        return result;
        

    }
}
