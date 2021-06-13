import java.util.PriorityQueue;

public class MinimumNumberOfRefulingStops {
    /*
    A car travels from a starting position to a destination which is target miles east of the starting position.

    Along the way, there are gas stations.  Each station[i] represents a gas station that is station[i][0] miles east of
    the starting position, and has station[i][1] liters of gas.

    The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.  It uses 1 liter of
    gas per 1 mile that it drives.

    When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

    What is the least number of refueling stops the car must make in order to reach its destination?  If it cannot reach
    the destination, return -1.

    Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.  If the car reaches the
    destination with 0 fuel left, it is still considered to have arrived.

    Example 1:
    Input: target = 1, startFuel = 1, stations = []
    Output: 0
    Explanation: We can reach the target without refueling.

    Example 2:
    Input: target = 100, startFuel = 1, stations = [[10,100]]
    Output: -1
    Explanation: We can't reach the target (or even the first gas station).

    Example 3:
    Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
    Output: 2
    Explanation:
    We start with 10 liters of fuel.
    We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
    Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
    and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
    We made 2 refueling stops along the way, so we return 2.

    Note:
        1 <= target, startFuel, stations[i][1] <= 10^9
        0 <= stations.length <= 500
        0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target
     */
    //TC: O(n log n) where n is the number of stations, log n time to build heap
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;

        //the initial distance that can be traveled is determined by the initial amount of fuel available
        int distance = startFuel;
        int i = 0, stops = 0;

        //heap keeps track of the largest fuel reserve a station has in the current distance traveled
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

        //make the largest gap stops while we are still not at the target destination
        while (distance < target) {

            /*
                add all stations that can are within reach, i.e. stations who's distance is equal or less than the
                current distance that can be traveled
             */
            while (i < n && distance >= stations[i][0]) {
                maxHeap.add(stations[i++][1]);
            }
            //no stations left in the queue before reaching target means target cant be reached
            if (maxHeap.isEmpty()) {
                return -1;
            }

            //fuel on the station that will give the most fuel
            distance += maxHeap.remove();
            stops++;
        }
        return stops;
    }
}
