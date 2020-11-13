public class towersOfHanoi {
    //TC: O(2^n - 1)
    public static void hanoi(int n, char start, char finish, char temp) {
        if(n > 0) {
            hanoi(n-1, start, temp, finish);
            System.out.println("Move Disk " + n + " from rod " + start + " to rod " + finish);
            hanoi(n-1, temp, finish, start);
        }
    }

    public static void main(String[] args) {
        //Rod start is where all disks start from, finish is the destination, and temp is the extra rod used for moving
        char start = 'A';
        char finish = 'B';
        char temp = 'C';
        hanoi(3, start, finish, temp);
    }
}
