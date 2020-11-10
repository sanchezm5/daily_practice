/** This question is from Firecode.io
 *
 * The Fibonacci Sequence is the series of numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ... The next number is found by
 * adding up the two numbers before it. Write a recursive method fib(n) that returns the nth Fibonacci number. n is 0
 * indexed, which means that in the sequence 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ..., n == 0 should return 0 and n == 3
 * should return 2. Assume n is less than 15.
 *
 * Examples:
 *      fib(0) ==> 0
 *      fib(1) ==> 1
 *      fib(3) ==> 2
 */

package numbers;

public class FibonacciNumber {

    public static int fib(int n) {
        // Base case to return 0 when input is 0 or 1 when input is 1
        if (n == 0) return 0;
        if (n == 1) return 1;
        // Recursive call where two previous numbers are used to find the nth Fibonacci number
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        System.out.println(fib(0)); // output is 0
        System.out.println(fib(1)); // output is 1
        System.out.println(fib(10)); // output is 55
    }
}

