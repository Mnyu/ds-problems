package _12_hashing_hashtables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given : N cartesian points in 2D plane.
 * Find the number of axis parallel rectangles that can be formed.
 */
public class _88_CountRectangles {
    public int rectanglesCount(List<Point> points) {
        if (points == null || points.size() == 0)
            return -1;
        Set<String> pSet = new HashSet<>();
        points.forEach(p -> {
            pSet.add(Integer.toString(p.x) + Integer.toString(p.y));
        });
        int count = 0;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                Point p1 = points.get(i);
                Point p2 = points.get(j);

                // We need to pick only possible diagonal points,
                // therefore, ignore p1 and p2 combo that can't be diagonal
                if (p1.x == p2.x || p1.y == p2.y)
                    continue;

                // For possible diagonal points p1 and p2, check if other 2 points are present.
                // If present we have a axis parallel rectangle
                if (pSet.contains(Integer.toString(p1.x) + Integer.toString(p2.y)) &&
                        pSet.contains(Integer.toString(p2.x) + Integer.toString(p1.y))) {
                    count++;
                }
            }
        }
        return count / 2;
    }

    public static void main(String[] args) {
        _88_CountRectangles obj = new _88_CountRectangles();
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 1));
        points.add(new Point(1, 1));
        points.add(new Point(1, 0));
        points.add(new Point(2, 1));
        points.add(new Point(2, 0));
        points.add(new Point(3, 1));
        points.add(new Point(3, 0));
        System.out.println(obj.rectanglesCount(points));
    }
    // Time Complexity : O(N^2)
    // Space Complexity : O(N)
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
