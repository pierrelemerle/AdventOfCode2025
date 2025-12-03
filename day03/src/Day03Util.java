import java.util.List;
import java.util.Stack;

public class Day03Util {

    public static int biggestJoltage(List<Integer> joltageList){
        for (int i=9;i>=0;i--) {
            for (int j=9;j>=0;j--) {
                for (int listA=0;listA<joltageList.size()-1;listA++){
                    if (joltageList.get(listA)==i){
                        for (int listB=listA+1;listB<joltageList.size();listB++){
                            if (joltageList.get(listB)==j){
                                return (i*10+j);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
 
    public static long getLargestJoltage(List<Integer> sequence) {
        int length = sequence.size();
        int digitsToKeep = 12;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            int current = sequence.get(i);
            while (!stack.isEmpty() && stack.peek() < current && (stack.size() + (length - i) > digitsToKeep)) {
                stack.pop(); 
            }
            if (stack.size() < digitsToKeep) {
                stack.push(current);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();
        return Long.parseLong(result.toString());
    }

}


