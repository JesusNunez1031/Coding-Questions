package leetCode.math;

public class RobotBoundedInCircle {
    static class Robot {
        //position coordinates of robot
        int x;
        int y;

        // z is the vector the robot points to
        int z;
        // N = 0, W = 1, S = 2, E = 3
        int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        public Robot(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public void moveStrait() {
            /*
                move strait depending on the direction that we are currently pointed towards, i.e. N, S, E, W. So when
                we are,
                - pointing North, z = 0, only y changes hence x += 0 and y += 1 using dir[0][0] and dir[0][1]
                - when pointing west, we only x will change hence x += -1 and y += 0 using dir[1][0] and dir[1][1]
                - when pointing east, only x will change hence x += 1 and y += 0 using dir[3][0] and dir[3][1]
                - when pointing south, only y will change hence x += 0 and y += -1 using dir[2][0] and dir[2][1]
             */
            this.x += dir[this.z][0];
            this.y += dir[this.z][1];
        }

        public void turnLeft() {
            //4 possible directions, after every turn we add 1 so after 4 left turns, z == 0 hence we use %4
            this.z = (this.z + 1) % 4;
        }

        public void turnRight() {
            //similar to left, 4 possible directions, to turn right we make 3 left turns, better than using -1
            this.z = (this.z + 3) % 4;
        }
    }

    //TC: O(n)
    public boolean isRobotBounded(String instructions) {

        //initialize a robot at origin 0,0 pointing north 0
        Robot r = new Robot(0, 0, 0);

        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'G') {
                r.moveStrait();
            } else if (instruction == 'L') {
                r.turnLeft();
            } else {
                r.turnRight();
            }
        }

        boolean isOrigin = r.x == 0 && r.y == 0;
        boolean pointsNorth = r.z == 0;

        /*
            a robot is in a circle if after performing all instructions, is back at the start origin or it doesnt stay
            pointing north (changes direction) meaning it will eventually return the the starting vector if instructions
            are repeated
         */
        return isOrigin || !pointsNorth;
    }
}
