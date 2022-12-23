package codingbat.recursion_1;

public class bunnyEars {
    /*
    We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears
    across all the bunnies recursively (without loops or multiplication).

    codingbat.recursion_1.bunnyEars(0) → 0
    codingbat.recursion_1.bunnyEars(1) → 2
    codingbat.recursion_1.bunnyEars(2) → 4
     */
    public int bunnyEars(int bunnies) {
        if (bunnies == 0) {
            return 0;
        }
        return bunnyEars(bunnies - 1) + 2;
    }
}
