package leetCode.design;

import java.util.HashMap;
import java.util.Map;

public class designUndergroundSystem {
    /*
    Implement the UndergroundSystem class:
    -> void checkIn(int id, string stationName, int t)
        - A customer with a card id equal to id, gets in the station stationName at time t.
        - A customer can only be checked into one place at a time.
    -> void checkOut(int id, string stationName, int t)
        - A customer with a card id equal to id, gets out from the station stationName at time t.
    -> double getAverageTime(string startStation, string endStation)
        - Returns the average time to travel between the startStation and the endStation.
        - The average time is computed from all the previous traveling from startStation to endStation that happened directly.
        - Call to getAverageTime is always valid.
    You can assume all calls to checkIn and checkOut methods are consistent. If a customer gets in at time t1 at some
    station, they get out at time t2 with t2 > t1. All events happen in chronological order.

    Example 1:
    Input
    ["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
    [[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]

    Output
    [null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]

    Explanation
    UndergroundSystem undergroundSystem = new UndergroundSystem();
    undergroundSystem.checkIn(45, "Leyton", 3);
    undergroundSystem.checkIn(32, "Paradise", 8);
    undergroundSystem.checkIn(27, "Leyton", 10);
    undergroundSystem.checkOut(45, "Waterloo", 15);
    undergroundSystem.checkOut(27, "Waterloo", 20);
    undergroundSystem.checkOut(32, "Cambridge", 22);
    undergroundSystem.getAverageTime("Paradise", "Cambridge");       // return 14.00000. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
    undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.00000. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.00000
    undergroundSystem.checkIn(10, "Leyton", 24);
    undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.00000
    undergroundSystem.checkOut(10, "Waterloo", 38);
    undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 12.00000
    Example 2:

    Input
    ["UndergroundSystem","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime"]
    [[],[10,"Leyton",3],[10,"Paradise",8],["Leyton","Paradise"],[5,"Leyton",10],[5,"Paradise",16],["Leyton","Paradise"],[2,"Leyton",21],[2,"Paradise",30],["Leyton","Paradise"]]

    Output
    [null,null,null,5.00000,null,null,5.50000,null,null,6.66667]

    Explanation
    UndergroundSystem undergroundSystem = new UndergroundSystem();
    undergroundSystem.checkIn(10, "Leyton", 3);
    undergroundSystem.checkOut(10, "Paradise", 8);
    undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.00000
    undergroundSystem.checkIn(5, "Leyton", 10);
    undergroundSystem.checkOut(5, "Paradise", 16);
    undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.50000
    undergroundSystem.checkIn(2, "Leyton", 21);
    undergroundSystem.checkOut(2, "Paradise", 30);
    undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 6.66667

    Constraints:
        There will be at most 20000 operations.
        1 <= id, t <= 10^6
        All strings consist of uppercase and lowercase English letters, and digits.
        1 <= stationName.length <= 10
        Answers within 10-5 of the actual value will be accepted as correct.
     */

    /**
     * Your UndergroundSystem object will be instantiated and called as such:
     * UndergroundSystem obj = new UndergroundSystem();
     * obj.checkIn(id,stationName,t);
     * obj.checkOut(id,stationName,t);
     * double param_3 = obj.getAverageTime(startStation,endStation);
     */

    //TC: O(1) and O(n) space since we store all arrivals and checkouts
    class UndergroundSystem {
        //Customer check-in info Object
        class ArrivalInfo {
            int id;
            String stationName;
            int time;

            //when a customer checks in, we take its id, stationName, and the time checked in
            public ArrivalInfo(int id, String stationName, int time) {
                this.id = id;
                this.stationName = stationName;
                this.time = time;
            }
        }

        Map<Integer, ArrivalInfo> arrivals; //map holds the id of the arrival and the info of the customer
        /*
            map holds the a double array of size 2 for each station check in and out combo,
            arr[0] = time to get to a station from another stations, and number of times customers went
            from station a to station b. Key is station a + station b
        */
        Map<String, double[]> total;

        public UndergroundSystem() {
            arrivals = new HashMap<>();
            total = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            //add the new customer to the map of arrivals
            ArrivalInfo customer = new ArrivalInfo(id, stationName, t);
            arrivals.put(id, customer);
        }

        public void checkOut(int id, String stationName, int t) {
        /*
            when a customer checks out, we add combine the names of the stations where the customer checked in
            and checked out to create a key, this key serves as the start and end from one pair of stations
            and helps us keep track of the total time customers have taken traveling from this pair of stations
            and the number of times the stations were used
        */
            ArrivalInfo arrival_station = arrivals.get(id); //get the starting station of the checking out customer
            String key = arrival_station.stationName + "_" + stationName; //make the new key

            //get the info of the start and end station, if no other customer has used this station pair make a new array
            double[] travel_info = total.getOrDefault(key, new double[2]);

            //travel time is the end time - start time
            int travel_time = t - arrival_station.time;

            //add the travel time to the first value and add 1 to the times customers have used this station pair
            travel_info[0] += travel_time;
            travel_info[1]++;

            //add the entry to the total map
            total.put(key, travel_info);
        }

        public double getAverageTime(String startStation, String endStation) {
            //make the station pair key
            String key = startStation + "_" + endStation;

            double[] travel_info = total.get(key);

            return travel_info[0] / travel_info[1];
        }
    }
}
