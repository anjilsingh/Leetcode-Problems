import java.util.Map.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {        
        Map<Integer, Integer> counts = new HashMap<>();
        
        for(int element: hand) {
            counts.put(element, counts.getOrDefault(element, 0) + 1);
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(Entry<Integer, Integer> current: counts.entrySet()) {
            minHeap.offer(new int[] {current.getKey(), current.getValue()});   
        }
        
        int answer = 0;
        while(!minHeap.isEmpty()) {
            List<int[]> temp = new ArrayList<>();
            for(int i = 0; i < groupSize; i++) {    
                if(minHeap.isEmpty()) return false;                
                temp.add(minHeap.poll());
            }
            
            for(int i = 1; i < groupSize; i++) {
                int[] first = temp.get(i - 1), second = temp.get(i);
                if((second[0] - first[0]) != 1) {
                    return false;
                }
            }
            
            for(int i = 0; i < groupSize; i++) {
                int[] current = temp.get(i);
                if(--current[1] > 0) {
                    minHeap.offer(current);
                }
            }
            
            answer++;
        }
        
        return true;
    }
}