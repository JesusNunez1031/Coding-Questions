public class BinaryAddition {

    public static String addBinary(String a, String b) {
        if(a.length() == 1 && b.length() == 1) {
            if(a.charAt(0) == '1' && b.charAt(0) == '1')
                return "10";
            else
                return a.charAt(0) == '0' && b.charAt(0) == '0' ? "0" : "1";
        }
        long aVal = Long.parseLong(a);
        long bVal = Long.parseLong(b);
        int i = 0, remainder = 0;
        StringBuilder sb = new StringBuilder();

        int[] sum = new int[20];

        while(aVal != 0 || bVal != 0) {
            sum[i++] = (int)((aVal % 10 + bVal % 10 + remainder) % 2);
            remainder = (int)((aVal % 10 + bVal % 10 + remainder) / 2);
            aVal = aVal / 10;
            bVal = bVal / 10;
        }

        if(remainder != 0) {
            sum[i++] = remainder;
        }
        --i;
        while(i >= 0) {
            sb.append(sum[i--]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "0";
        String b = "0";

        System.out.println(addBinary(a,b));
    }
}
