import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day08Util {

    public static List<Pair> findClosestPairs(List<Point3D> points) {
        List<Pair> closestPairs = new ArrayList<>();
        // Loop through all combinations of points and list their distances
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                Point3D pointA = points.get(i);
                Point3D pointB = points.get(j);
                double distance = calculateDistance(pointA, pointB);        
                closestPairs.add(new Pair(pointA, pointB, distance));
            }
        }
        // Sort the pairs based on distance
        closestPairs.sort((pair1, pair2) -> Double.compare(pair1.distance, pair2.distance));
        // Return only the first 'numberOfPairs' closest pairs
        return closestPairs;
    }

    // function to execute the list of connections defined by the first part of the logic
    public static List<List<Point3D>> connectPoints(List<Point3D> junctionBoxes, List<Pair> closestPairs, int nbConnection) {
        List<Pair> limitedPairs = closestPairs.subList(0, nbConnection);
        List<List<Point3D>> connectedGroups = new ArrayList<>();
        for (Point3D box : junctionBoxes) {
            List<Point3D> singleGroup = new ArrayList<>();
            singleGroup.add(box);
            connectedGroups.add(singleGroup);
        }
        // Connect points based on the closest pairs
        for (Pair pair : limitedPairs) {
            int groupA = findGroupIndex(connectedGroups, pair.pointA);
            int groupB = findGroupIndex(connectedGroups, pair.pointB);
            // If they belong to different groups, connect them
            if (groupA != -1 && groupB != -1 && groupA != groupB) {
                connectedGroups.get(groupA).addAll(connectedGroups.get(groupB));
                connectedGroups.remove(groupB); 
            }
        }
        return connectedGroups;
    }   

    private static double calculateDistance(Point3D boxA, Point3D boxB) {
        double deltaX = boxA.getX() - boxB.getX();
        double deltaY = boxA.getY() - boxB.getY();
        double deltaZ = boxA.getZ() - boxB.getZ();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }

    private static int findGroupIndex(List<List<Point3D>> connectedGroups, Point3D point) {
        for (int i = 0; i < connectedGroups.size(); i++) {
            List<Point3D> group = connectedGroups.get(i);
            if (group.contains(point)) {
                return i; 
            }
        }
        return -1; 
    }

    private static void sortGroupsBySize(List<List<Point3D>> groups) {
        Collections.sort(groups, new Comparator<List<Point3D>>() {
            @Override
            public int compare(List<Point3D> group1, List<Point3D> group2) {
                return Integer.compare(group2.size(), group1.size()); 
            }
        });
    }    

    //to get the answer for part 1
    public static int countLargestConnections(List<List<Point3D>> connections, int nbConnection) {
        int result = 1;
        sortGroupsBySize(connections);
        for (int i = 0; i < nbConnection; i++) {
            result *= connections.get(i).size();
        }
        return result;
    }

    // function for the part 2. Leaves once we have only a single group, and returns the Pair that did it
    public static int connectPoints(List<Point3D> junctionBoxes, List<Pair> closestPairs) {
        int counter = 0;
        List<List<Point3D>> connectedGroups = new ArrayList<>();
        for (Point3D box : junctionBoxes) {
            List<Point3D> singleGroup = new ArrayList<>();
            singleGroup.add(box);
            connectedGroups.add(singleGroup);
        }
        // Connect points based on the closest pairs
        for (Pair pair : closestPairs) {
            int groupA = findGroupIndex(connectedGroups, pair.pointA);
            int groupB = findGroupIndex(connectedGroups, pair.pointB);
            // If they belong to different groups, connect them
            if (groupA != -1 && groupB != -1 && groupA != groupB) {
                connectedGroups.get(groupA).addAll(connectedGroups.get(groupB));
                connectedGroups.remove(groupB); 
            }
            counter++;
            if (connectedGroups.size() == 1) {
                break;
            }
        }
        return counter;
    }

    public static int calculateAnswer2(Pair closingPair) {
        return (int)(closingPair.getPointA().getX() * closingPair.getPointB().getX());
    }


}

