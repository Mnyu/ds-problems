package _11_priority_queues;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given : N 2D points representing the location of the cab.
 * You are standing at origin, find the names of nearest k cars.
 */
public class _83_FindingCabs {
    public List<Car> nearestKCars(List<Car> cars, int k) {
        if (cars == null)
            return null;

        Queue<Car> heap = new PriorityQueue<>(k, new CarComparator());
        for (int i = 0; i < cars.size(); i++) {
            if (i < k) {
                heap.offer(cars.get(i));
            } else {
                if (cars.get(i).dist() < heap.peek().dist()) {
                    heap.poll();
                    heap.offer(cars.get(i));
                }
            }
        }
        List<Car> result = Arrays.asList(heap.toArray(new Car[k]));
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Car c1 = new Car("c1", 1,1);
        Car c2 = new Car("c2", 2,1);
        Car c3 = new Car("c3", 3,2);
        Car c4 = new Car("c4", 0,1);
        Car c5 = new Car("c5", 2,3);
        List<Car> cars = Arrays.asList(c1, c2, c3, c4, c5);
        _83_FindingCabs obj = new _83_FindingCabs();
        System.out.println(obj.nearestKCars(cars, 3));
    }
    // Time Complexity : O(NlogK) + O(K) [reverse]
    // Space Complexity : O(K)
}

class Car {
    private String name;
    private int x;
    private int y;

    public Car(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public int dist() {
        return x * x + y * y;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return car2.dist() - car1.dist();
    }
}
