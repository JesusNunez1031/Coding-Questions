public class ComplexNumberMultiplication {
    /*
    A complex number can be represented as a string on the form "real+imaginaryi" where:
        real is the real part and is an integer in the range [-100, 100].
        imaginary is the imaginary part and is an integer in the range [-100, 100].
        i2 == -1.
    Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.

    Example 1:
    Input: num1 = "1+1i", num2 = "1+1i"
    Output: "0+2i"
    Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.

    Example 2:
    Input: num1 = "1+-1i", num2 = "1+-1i"
    Output: "0+-2i"
    Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.

    Constraints:
        num1 and num2 are valid complex numbers.
     */
    // complex number object to store real and imaginary parts of an actual complex number
    static class ComplexNumber {
        int real;
        int imaginary;

        public ComplexNumber(int real, int imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }
    }

    //TC:O(len(num1) + len(num2))
    public String complexNumberMultiply(String num1, String num2) {
        ComplexNumber n1 = parseComplexNum(num1);
        ComplexNumber n2 = parseComplexNum(num2);

        /*
            Multiplication of Complex numbers:
            Num1: (a + ib)
            Num2: (x + iy)

            Using FOIL: ax + aiy + ibx + i^2by === ax + i(ay + bx) + i^2by

            i^2 == -1, hence we simplify further:
            ax - by + i(ay + bx)
         */

        //ax - by
        int productRealNum = (n1.real * n2.real) - (n1.imaginary * n2.imaginary);

        //ay + bx
        int productImagNum = (n1.real * n2.imaginary) + (n1.imaginary * n2.real);

        // convert solution to proper format
        return productRealNum + "+" + productImagNum + "i";
    }

    private ComplexNumber parseComplexNum(String num) {
        int i = 0;
        int real = 0; // the real number of the num
        boolean isRealNegative = false;

        // check if the real number is negative, i.e. first character is '-'
        if (num.charAt(i) == '-') {
            isRealNegative = true;
            i++;
        }

        // Calculate the real number value, '+' denotes the end of the real number
        while (num.charAt(i) != '+') {
            real = 10 * real + (num.charAt(i) - '0');
            i++;
        }

        // make negative if first character was '-'
        if (isRealNegative) {
            real = -real;
        }

        // move to the character after '+'
        i++;

        int imaginary = 0; // the imaginary number of the num
        boolean isImaginaryNegative = false;

        // check if imaginary number is negative, i.e. first character of the number is '-'
        if (num.charAt(i) == '-') {
            isImaginaryNegative = true;
            i++;
        }

        //'i' denotes the end of the imaginary number
        while (num.charAt(i) != 'i') {
            imaginary = 10 * imaginary + (num.charAt(i) - '0');
            i++;
        }

        // make negative if first character was '-'
        if (isImaginaryNegative) {
            imaginary = -imaginary;
        }

        // return a new complex number object composed of the real and imaginary numbers in num
        return new ComplexNumber(real, imaginary);
    }
}
