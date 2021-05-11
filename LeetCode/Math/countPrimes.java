public class countPrimes {
    /*
    Count the number of prime numbers less than a non-negative number, n.

    Example 1:
    Input: n = 10
    Output: 4
    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

    Example 2:
    Input: n = 0
    Output: 0

    Example 3:
    Input: n = 1
    Output: 0

    Constraints:
        0 <= n <= 5 * 10^6
     */
    //TC: (n log(log n)) and O(n) space using The Sieve of Eratosthenes Algorithm
    public int countPrimes(int n) {
        //0 and 1 are not primes
        if (n <= 2) {
            return 0;
        }

        // list used to keep track of all values, primes will be false, composites will be true
        boolean[] composites = new boolean[n];

        /*
            We only need to consider factors up to √n because, if n is divisible by some number p, then n = p * q and
            since p <= q, we can derive that p <= √n. In laymen terms, tot avoid extra work, we don't need to check for
            absolutely all factors, but rather only half.
            ex:
                Factors for 6:
                2 x 3 = 6  |  1 x 6 = 6
                3 x 2 = 6  |  6 x 1 = 6

                Note 3 x 2 and 6 x 1 are not necessary.
         */

        int limit = (int) Math.sqrt(n);

        //start from 2 since 0 and 1 are not prime
        for (int i = 2; i <= limit; i++) {
            /*
                for each value in the range, mark off its multiples since all the multiples wont be prime since they are
                also divisible by i. When we encounter an already marked multiple, we don't need to mark its own multiples
                since any multiple after a previously marked multiple will also have the same multiples, e.g. 2, its
                multiples are 4, 6, 8, 10, 12, etc, when we arrive at 4, 4's multiples are 8, 12, 16, 20, etc, all the same
                as 2, hence we skip it.
             */
            if (!composites[i]) {
                /*
                    start at i^2 since all previous multiples for i have already been marked

                    Ex:
                     we can mark off multiples of 5 starting at 5 × 5 = 25, because 5 × 2 = 10 was already marked off by
                     multiple of 2, similarly 5 × 3 = 15 was already marked off by multiple of 3. Therefore, if the
                     current number is p, we can always mark off multiples of p starting at p^2
                 */
                for (int j = i * i; j < n; j += i) {
                    composites[j] = true;
                }
            }
        }

        /*
            counting the number of primes in the range of 0 - n is now only counting which values are not composites, i.e
            which values are not part of some previous numbers multiples, i.e. no value before 5 multiplied == 5, on the
            contrary, 4 is not prime since 2 * 2 == 4
         */
        int primes = 0;
        for (int i = 2; i < n; i++) {
            if (!composites[i]) {
                primes++;
            }
        }
        return primes;
    }
}
