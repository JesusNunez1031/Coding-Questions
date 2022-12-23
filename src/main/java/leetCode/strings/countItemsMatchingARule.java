package leetCode.strings;

import java.util.List;

public class countItemsMatchingARule {
    /*
    You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of
    the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.

    The ith item is said to match the rule if one of the following is true:
        - ruleKey == "type" and ruleValue == typei.
        - ruleKey == "color" and ruleValue == colori.
        - ruleKey == "name" and ruleValue == namei.
    Return the number of items that match the given rule.

    Example 1:
    Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
    Output: 1
    Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].

    Example 2:
    Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
    Output: 2
    Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.

    Constraints:
        1 <= items.length <= 10^4
        1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
        ruleKey is equal to either "type", "color", or "name".
        All strings consist only of lowercase letters.
     */
    //TC: O(n)
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int matches = 0;

        //get the rule key for the match query
        int key = -1;
        switch (ruleKey) {
            case "type":
                key = 0;
                break;
            case "color":
                key = 1;
                break;
            case "name":
                key = 2;
                break;
        }

        //search through the list of items
        for (List<String> item : items) {
            //if the current items' key value matches the ruleValue, a match has been found
            if (item.get(key).equals(ruleValue)) {
                matches++;
            }
        }
        return matches;
    }
}
