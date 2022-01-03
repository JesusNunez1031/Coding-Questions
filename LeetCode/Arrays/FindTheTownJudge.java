public class FindTheTownJudge {
    /*
    In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
    If the town judge exists, then:
        1. The town judge trusts nobody.
        2. Everybody (except for the town judge) trusts the town judge.
        3. There is exactly one person that satisfies properties 1 and 2.
    You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

    Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
    Example 1:
    Input: n = 2, trust = [[1,2]]
    Output: 2

    Example 2:
    Input: n = 3, trust = [[1,3],[2,3]]
    Output: 3

    Example 3:
    Input: n = 3, trust = [[1,3],[2,3],[3,1]]
    Output: -1

    Constraints:
        1 <= n <= 1000
        0 <= trust.length <= 104
        trust[i].length == 2
        All the pairs of trust are unique.
        ai != bi
        1 <= ai, bi <= n
     */
    //TC:O(n)
    public int findJudge(int N, int[][] trust) {
        // array holding the count of users ith person trusts
        int[] isTrusted = new int[N + 1];

        for (int[] person : trust) {
            // decrease the trust score of the person that is placing trust on someone else
            isTrusted[person[0]]--;

            // increase the trust score of the person that is being given trust by another
            isTrusted[person[1]]++;
        }

        // look for the person that has a trust score of n - 1 as this person must be the judge since they are trusted by all n people
        for (int i = 1; i < isTrusted.length; i++) {
            if (isTrusted[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
