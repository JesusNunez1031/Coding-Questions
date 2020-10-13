public class kangaroo {
    static String kangaroo(int x1, int v1, int x2, int v2) {

        //If the second kangaroo moves slow than the first there is a chance the first can reach it
        if (v1 > v2) {
            boolean willIntersect = (x1 - x2) % (v2 - v1) == 0;
            if (willIntersect) {
                return "YES";
            }
        }
        return "NO";
    }
}
