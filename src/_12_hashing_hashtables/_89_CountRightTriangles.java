package _12_hashing_hashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given : N cartesian points in a 2D plane
 * Find the number of right angled triangles such that the base or perpendicular is parallel to X-axis or Y-axis.
 */
public class _89_CountRightTriangles {
    public int rightTrianglesCount(List<Point> points) {
        if (points == null || points.size() == 0)
            return -1;
        Map<Integer, Integer> xFreq = new HashMap<>();
        Map<Integer, Integer> yFreq = new HashMap<>();
        for (Point p : points) {
            xFreq.put(p.x, xFreq.getOrDefault(p.x, 0) + 1);
            yFreq.put(p.y, yFreq.getOrDefault(p.y, 0) + 1);
        }
        int count = 0;
        for (Point p : points) {
            int countX = xFreq.get(p.x);
            int countY = yFreq.get(p.y);
            count = count + (countX - 1) * (countY - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        _89_CountRightTriangles obj = new _89_CountRightTriangles();
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 2));
        points.add(new Point(2, 1));
        points.add(new Point(2, 2));
        points.add(new Point(2, 3));
        points.add(new Point(3, 3));
        System.out.println(obj.rightTrianglesCount(points));
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N)
}
