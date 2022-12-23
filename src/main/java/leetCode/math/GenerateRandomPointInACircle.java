package leetCode.math;

import java.util.Random;

public class GenerateRandomPointInACircle {
    /*
    Given the radius and x-y positions of the center of a circle, write a function randPoint which generates a uniform
    random point in the circle.

    Note:
    input and output values are in floating-point.
    radius and x-y position of the center of the circle is passed into the class constructor.
    a point on the circumference of the circle is considered to be in the circle.
    randPoint returns a size 2 array containing x-position and y-position of the random point, in that order.

    Example 1:
    Input:
    ["Solution","randPoint","randPoint","randPoint"]
    [[1,0,0],[],[],[]]
    Output: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]

    Example 2:
    Input:
    ["Solution","randPoint","randPoint","randPoint"]
    [[10,5,-7.5],[],[],[]]
    Output: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]
    Explanation of Input Syntax:

    The input is two lists: the subroutines called and their arguments. Solution's constructor has three arguments, the
    radius, x-position of the center, and y-position of the center of the circle. randPoint has no arguments. Arguments are
    always wrapped with a list, even if there aren't any.
     */
    double r;
    double x;
    double y;

    public GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        r = radius; //radius of the circle

        //x and y coordinates of the center of the circle
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        /*
            to define a random point in the circle we need a length, which is the distance from origin to new
            point and theta which is the angle

            when the origin is at the center, to generate a random point we need,
            x = length * cosθ
            y = length * sinθ

            if the origin is not at the center and rather at a point x_r, y_r, then,
            x = x_r + length * cosθ
            y = y_r + length * sinθ
            therefore the x coordinate is shifted by x_r and y coordinated by y_r
        */
        double length;
        double theta;

        //
        Random random = new Random(); //[0,1]
        //theta can range from 0 to 360 degrees, or 0 to 2π
        theta = random.nextDouble() * 2 * Math.PI;//[0, 2π]

        Random random2 = new Random(); //[0,1]
        /*
            the length of a random point from the center origin, can easily be a random point from [0, R], however,
            since the random function generates random values in a uniform distribution, meaning all outcomes are
            equally likely. So we take the sqare root of the random uniformly distributed number * radius to get a
            valid length for the new point
        */
        length = Math.sqrt(random2.nextDouble()) * r;

        //not a 0,0 centered circle so we need to add x and y to respective x and y distances
        double x_r = x + length * Math.cos(theta);
        double y_r = y + length * Math.sin(theta);

        //return the new random point x and y coordinates
        return new double[]{x_r, y_r};
    }
}
