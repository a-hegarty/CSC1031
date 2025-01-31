// program name: PrimeNumber.java
//date 31/01/2025
//author: Aoibhe Hegarty

//ATTENTION!!!!!!!
//the following method times out of DCU's einstein 
//because it takes too long
//the correct method is apparently 
//the seive of eratosthenes
//but idk how to get that one working
//we shall revisit at a later date

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the upper limit
        long limit = scanner.nextInt();

        // Counter of prime number
        long count = 0;

        for (int i = 1; i <= limit; i ++)
        {
            if (isPrime(i)) // if a number is prime ...
            {
                count ++;//... increment count by one
            }
        }

        // Print the results
        System.out.println(count);
    }

    // Function to check if it is prime
    private static boolean isPrime(long num) {
        if (num <= 1)//less than or equal to 1 are not prime
        {
            return false;
        }
        
        // if a number is evenly divisible by any of the numbers 
        //before or including its square root
        // it is not prime
        for (int j = 2; j <= Math.sqrt(num); j++)
        //for loop starts at 2 because all primes are divisible by 1
        {
            if(num % j == 0)
            {
                return false;
            }
        }
        
        //if all above conditions are not met
        //the number is prime
        return true;
    }
}