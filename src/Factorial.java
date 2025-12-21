import java.util.Scanner;

public class Factorial {
    int factorial(int n) {
        // factorial with iterative
        int fact = 1;
        for(int i = 1; i <= n; i++){
            fact = fact * i;
        }
        return fact;
    }


    public static void main(String[] args) {
        System.out.println("Enter the value of n:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Factorial f = new Factorial();
        int result = f.factorial(n);
        System.out.println(result);
    }
}
