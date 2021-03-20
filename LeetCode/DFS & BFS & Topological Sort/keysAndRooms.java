import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class keysAndRooms {
    //TC: O(r + k) and O(r) where r is the number of rooms and k is the number of keys, [DFS]
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //array to mark rooms visited
        boolean[] visited = new boolean[rooms.size()];
        //by default we have the key to room 0 so we mark it as visited
        visited[0] = true;

        //call method to do DFS search to visit rooms starting with the keys from room 0
        visitRooms(rooms, visited, 0);

        //once we've exhausted all possible room visits, check if all rooms have been visited
        for (boolean room : visited) {
            //the room has not been visited
            if (!room) {
                return false;
            }
        }
        //all rooms were visited
        return true;
    }

    private void visitRooms(List<List<Integer>> rooms, boolean[] visited, int index) {
        /*
            look through all the keys in the current room, if the room of the key has not been visited, mark it as visited
            since the rooms key has been found and then look through all the keys in room "key"
         */
        for (Integer key : rooms.get(index)) {
            if (!visited[key]) {
                visited[key] = true;
                visitRooms(rooms, visited, key);
            }
        }
    }

    //TC: O(r + k) and O(r) where r is the number of rooms and k is the number of keys, [BFS]
    public boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true; //by default we have access to room 0

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); //add first room to the queue

        while (!queue.isEmpty()) {
            Integer current_key = queue.remove(); //remove a room to look through

            /*
                look through all the keys in the current room and if we have not visited a room, add it queue and mark
                as visited since we now have the key to visit it
             */
            for (Integer key : rooms.get(current_key)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.add(key);
                }
            }
        }

        //check if all rooms were visited
        for (boolean room : visited) {
            if (!room) {
                return false;
            }
        }
        return true;
    }
}
