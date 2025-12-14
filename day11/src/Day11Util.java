import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Day11Util {
    
    public static List<Integer> findAllPath(Map<String, List<String>> map) {
        List<Integer> paths = new ArrayList<>();
        for (String startingPoint : map.get("you")) {
            oneStep(map, paths, 0, startingPoint);
        }
        return paths;
    }

    private static void oneStep(Map<String, List<String>> map, List<Integer> paths, int currentNbSteps, String position) {

        List<String> nextPositions = map.get(position);
        for (String nextPosition : nextPositions) {
            if (nextPosition.equals("out")) {
                paths.add(currentNbSteps++);
            } else {
                oneStep(map, paths, currentNbSteps + 1, nextPosition);
            }
        }
    }

    public static List<Integer> nbPathPart2(Map<String, List<String>> map) {
        List<Integer> counter = new ArrayList<>();
        for (String startingPoint : map.get("svr")) {
            List<String> currentPath = new ArrayList<>();
            currentPath.add(startingPoint);
            oneStepPart2(map, counter, currentPath, startingPoint);
        }
        return counter;
    }

    private static void oneStepPart2(Map<String, List<String>> map, List<Integer> counter, List<String> currentPath, String position) {

        List<String> nextPositions = map.get(position);
        for (String nextPosition : nextPositions) {
            List<String> pathToAdd = new ArrayList<>();
            for (String pos : currentPath) {
                pathToAdd.add(pos);
            }
            pathToAdd.add(nextPosition);
            if (nextPosition.equals("out")) {
                if (pathToAdd.contains("dac") && pathToAdd.contains("fft")) {
                    counter.add(1);                
                }   
                
            } 
            //avoid looping
            else if (!currentPath.contains(nextPosition)) {
                oneStepPart2(map, counter, pathToAdd, nextPosition);
            }
        }
    }

}

