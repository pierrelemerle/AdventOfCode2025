import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Day05Util {
    
    // Part 1: check if id is valid
    public static boolean isValid(Long id, List<long[]> validIntervals) {
        for (long[] interval : validIntervals) {
            if (id >= interval[0] && id <= interval[1]) {
                return true; 
            }
        }
        return false; 
    }

    // remove overlapping intervals
    public static List<long[]> mergeIntervals(List<long[]> intervals) {

        // Sort intervals
        intervals.sort(Comparator.comparingLong(a -> a[0]));
        List<long[]> merged = new ArrayList<>();
        long[] current = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            long[] next = intervals.get(i);
            if (current[1] >= next[0]) {
                // Overlapping intervals, merge them
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap, add the current interval to merged list
                merged.add(current);
                current = next;
            }
        }
        merged.add(current);
        return merged;
    }    

    // Part 2: calculate total valid numbers from merged intervals
    public static long calculateTotalValidNumbers(List<long[]> validIntervals) {
        long total = 0;
        for (long[] interval : validIntervals) {
            total += (interval[1] - interval[0] + 1); 
        }
        return total;
    }
}