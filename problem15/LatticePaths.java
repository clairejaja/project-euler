import java.util.*; // for ArrayList

/**
* @author Claire Jaja
* @version 9/22/14
*
* Project Euler Problem 15
* Starting in the top left corner of a 2x2 grid
* and only being able to move to the right and down,
* there are exactly 6 routes to the bottom right corner.
* How many such routes are there through a 20x20 grid?
*/

public class LatticePaths {
    // global variable for grid size
    private static int gridSize = 20;

    // global variable for memoizing calculated results
    private static Map<List<Integer>,Long> memoizedRoutes =
                                new HashMap<List<Integer>,Long>();

    public static void main(String[] args) {
        // start at 0,0
        int x = 0;
        int y = 0;
        List<Integer> coordinates = Arrays.asList(x,y);
        long routes = countRoutes(coordinates);
        System.out.println(routes);
    }

    // recursion!!
    public static long countRoutes(List<Integer> coordinates) {
        long routes = 0;
        // if exists in memoized results, return that
        if (memoizedRoutes.get(coordinates) != null) {
            return memoizedRoutes.get(coordinates);
        } else {
            int x = coordinates.get(0);
            int y = coordinates.get(1);
            // base case - already at end
            if (x == gridSize && y == gridSize) {
                return 1;
            } else {
                if (x != gridSize) {
                    // try moving to the right
                    List<Integer> newCoordinates = Arrays.asList(x+1,y);
                    routes += countRoutes(newCoordinates);
                }
                if (y != gridSize) {
                    // try moving down
                    List<Integer> newCoordinates = Arrays.asList(x,y+1);
                    routes += countRoutes(newCoordinates);
                }
                memoizedRoutes.put(coordinates,routes);
                return routes;
            }
        }
    }
}
