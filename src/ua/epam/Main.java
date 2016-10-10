package ua.epam;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        System.out.println("Please, enter an integer.");

        for ( int i = 0; i < 10; i++ ) {
            a = scanner.nextInt();

            new FactorialThread(a).start();
        }

        scanner.close();
    }
}
 class FactorialThread extends Thread {
    private long number;

    public FactorialThread(long number) {
        this.number = number;
    }

    @Override
    public void run() {
        if ( number < 0 ) {
            System.out.println("You entered a negative number. Please, enter an integer.");
        } else {
            try {
                long fact = factorial(number);
                synchronized (System.out) {
                    System.out.print("The factorial of " + number + " = ");
                    System.out.println(factorial(fact));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

     private long factorial(long number) throws InterruptedException {
         Thread.sleep(2000);
         if (number == 0 || number == 1) {return 1;}
         return (number * factorial(number-1));
     }
}
