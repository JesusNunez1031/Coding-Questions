import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class vasyaClerk {
    /*
    The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge
    line. Each of them has a single 100, 50 or 25 dollar bill. An "Avengers" ticket costs 25 dollars.

    Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.

    Can Vasya sell a ticket to every person and give change if he initially has no money and sells the tickets strictly
    in the order people queue?

    Return YES, if Vasya can sell a ticket to every person and give change with the bills he has at hand at that moment.
    Otherwise return NO.

    Examples:
    Line.Tickets(new int[] {25, 25, 50}) // => YES
    Line.Tickets(new int[] {25, 100}) // => NO. Vasya will not have enough money to give change to 100 dollars
    Line.Tickets(new int[] {25, 25, 50, 50, 100}) // => NO. Vasya will not have the right bills to give 75 dollars of change (you can't make two bills of 25 from one of 50)
     */
    public static String Tickets(int[] peopleInLine) {
        if (peopleInLine.length == 0) {
            return "YES";
        }

        //count of 25 and 50 dollar bills
        int d25 = 0;
        int d50 = 0;

        for (int bill : peopleInLine) {
            //25$ no change is owed
            if (bill == 25) {
                d25++;
            }
            //50$, 25$ of change is owed but we gain a 50$ bill
            else if (bill == 50) {
                d50++;
                d25--;
            }
            //100$, 75$ of change is owed if we have 50$ bills, otherwise we use 3 25$ bills
            else if (bill == 100) {
                if (d50 > 0) {
                    d50--;
                    d25--;
                } else {
                    d25 -= 3;
                }
            }

            //if at any point we have negative amount of bills, we cant make change
            if (d25 < 0) {
                return "NO";
            }
        }
        return "YES";
    }

    @Test
    public void test1() {
        assertEquals("YES", vasyaClerk.Tickets(new int[]{25, 25, 50}));
    }

    @Test
    public void test2() {
        assertEquals("NO", vasyaClerk.Tickets(new int[]{25, 100}));
    }
}
