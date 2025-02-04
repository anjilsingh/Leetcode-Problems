import java.util.*;

class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        // 1. Accumulate all the available gaps
        List<Integer> gaps = new ArrayList<>();

        // 2. First gap would be first event start time - 0
        gaps.add(startTime[0]);

        // 3. Add in-between gaps for all events
        int size = startTime.length;
        for (int i = 1; i < size; i++) {
            gaps.add(startTime[i] - endTime[i - 1]);
        }

        // 4. Last gap would be eventTime - last event end time
        gaps.add(eventTime - endTime[size - 1]);

        // 5. Go through each gap with a sliding window of size k+1
        int start = 0;
        int gapSum = 0;
        int maxGapSum = 0;

        for (int end = 0; end < gaps.size(); end++) {
            gapSum += gaps.get(end);

            if (end - start + 1 > k + 1) { // Window size exceeds k+1
                gapSum -= gaps.get(start); // Remove leftmost element
                start++; // Move left pointer
            }

            maxGapSum = Math.max(maxGapSum, gapSum);
        }

        return maxGapSum;
    }

    
}
