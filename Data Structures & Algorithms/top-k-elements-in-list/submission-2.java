// TC: O(nlogk), n - total array ele, k - top freq ele
// SC: O(n+k)

class Pair{
    int key;
    int value;
    public Pair(int key, int value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return key;
    }

    public int getValue(){
        return value;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Logic: Min heap
        // 1. Build a freq map
        // 2. Convert map's key into a list
        // 3. Create a min-heap, keep pushing ele. into min-heap, if size of min-heap is greater than k, remove top pair
        // 4. Now min-heap contains k most freq ele
        //    Create a result list and return

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        // build a freq map
        for(int i=0; i<=n-1; i++){
            int currNum = nums[i];
            map.put(currNum, map.getOrDefault(currNum,0)+1);
        }

        Set<Integer> keySet = map.keySet();

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for(int key : keySet){
            minHeap.offer(new Pair(key, map.get(key)));
            
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        int[] result = new int[k];

        // get top k elements
        for(int i=0; i<k; i++){
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}
