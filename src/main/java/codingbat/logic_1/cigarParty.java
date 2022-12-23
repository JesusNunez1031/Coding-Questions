package codingbat.logic_1;

public class cigarParty {
    /*

    When squirrels get together for a party, they like to have cigars. A squirrel party is successful when the number of cigars is between 40 and 60, inclusive. Unless it is the weekend, in which case there is no upper bound on the number of cigars. Return true if the party with the given values is successful, or false otherwise.

    codingbat.logic_1.cigarParty(30, false) → false
    codingbat.logic_1.cigarParty(50, false) → true
    codingbat.logic_1.cigarParty(70, true) → true
     */
    public boolean cigarParty(int cigars, boolean isWeekend) {
        if (cigars >= 40 && cigars <= 60) {
            return true;
        }
        return isWeekend && cigars >= 40;
    }
}
