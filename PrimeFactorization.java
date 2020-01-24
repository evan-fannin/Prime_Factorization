import java.util.ArrayList;
import java.util.Scanner;

public class PrimeFactorization
{

    public static void main(String[] args) {
        new PrimeFactorization();
    }

    public PrimeFactorization()
    {
        System.out.println("Enter positive integer to factorize.");
        int number = takeInput();
        primeFactorization(number);
    }

    public void primeFactorization(int number)
    {
        ArrayList<Integer> primeFactors = new ArrayList<>();
        if (isPrime(number)) {
            primeFactors.add(number);
        }
        else {
            int lastFactor = 0;
            while (!isPrime(number)) {
                int primeFactor = findPrimeFactor(number);
                primeFactors.add(primeFactor);
                number = number / primeFactor;
                lastFactor = number;
            }
            primeFactors.add(lastFactor);
        }

        String returnString = "The prime factorization is: \n";
        for (Integer prime : primeFactors) {
            returnString += " (" + prime + ") ";
        }
        System.out.println(returnString);
    }

    private int findPrimeFactor(int number)
    {
        double sqrt = Math.sqrt((double)number);
        int factor = 1;
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0 && isPrime(i)) {
                factor = i;
                break;
            }
        }
        return factor;
    }

    private boolean isPrime(int number)
    {
        double sqrt = Math.sqrt((double)number);
        boolean isPrime = true;
        int i = 2;
        while (i <= sqrt && isPrime == true) {
            if (number % i == 0) {
                isPrime = false;
            }
            i++;
        }
        return isPrime;
    }

    private int takeInput() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        return input;
    }
}
