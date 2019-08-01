public class Powers {

    public static boolean powerOfThree(int num) {
        if(num < 3) {
            return false;
        }
        for(int i = 1; i <= num;i++){
            if(Math.pow(3,i) == num){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.print(powerOfThree(6));
    }
}
