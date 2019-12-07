import org.jetbrains.annotations.Contract;
import java.util.Scanner;
public class Factorial {
    @Contract(pure = true) // this annotation added by intelliJ
    public static long iterative(int n) {
        long factorial = 1;
        if (n <= 0) {
            throw new IllegalArgumentException("Error! The factorial function is undefined for non-positive numbers including zero."); // an input of <0 returns an error
        } else if (n == 1) {
            return 1; // an input of 0 returns 1
        } else {
            for (int i = 1; i <= n; i++) {
                factorial = factorial * i;
            }
            return factorial;
        }
    }
    public static long pureRecursive(int n) { //A purely recursive function that calculates the factorial of n.
        // This function only calls on itself.
        if (n > 1) {
            return n * pureRecursive(n - 1);
        } else if (n <= 0) {
            throw new IllegalArgumentException("Error! The factorial function is undefined for non-positive numbers including zero.");// an input of <0 returns an error
        } else {
            return 1;// an input of 0 returns 1
        }
    }
    public static long tailRecursive(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Error! The factorial function is undefined for non-positive numbers including zero."); // an input of <0 returns an error
        } else {
            return tail(n, 1);
        }
    }
    @Contract(pure = true) // this annotation added by intelliJ
    private static long tail(long n, long y) {
        if (n == 0) {
            return y;
        } else {
            return tail(n - 1, n * y); // it should call itself on the last line with no other computation after the function call.
        }
    }
    public static void main(String[] args) { // main method used to test sample output
        int number;
        Scanner scnr = new Scanner(System.in);
        System.out.print("What number would you like to test? : ");
        number = scnr.nextInt();
        System.out.println("Pure Recursive: " + pureRecursive(number));
        System.out.println("Tail Recursive: " + tailRecursive(number));
        System.out.println("Iterative: " + iterative(number));
    }
}


