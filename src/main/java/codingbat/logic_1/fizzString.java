package codingbat.logic_1;

public class fizzString {
    /*
    Given a string str, if the string starts with "f" return "Fizz". If the string ends with "b" return "Buzz".
    If both the "f" and "b" conditions are true, return "FizzBuzz". In all other cases, return the string unchanged.

    codingbat.logic_1.fizzString("fig") → "Fizz"
    codingbat.logic_1.fizzString("dib") → "Buzz"
    codingbat.logic_1.fizzString("fib") → "FizzBuzz"
     */
    public String fizzString(String str) {
        if (str.charAt(0) == 'f' && !(str.charAt(str.length() - 1) == 'b')) {
            return "Fizz";
        }
        if (str.charAt(str.length() - 1) == 'b' && !(str.charAt(0) == 'f')) {
            return "Buzz";
        }
        return str.charAt(0) == 'f' && str.charAt(str.length() - 1) == 'b' ? "FizzBuzz" : str;
    }
}
