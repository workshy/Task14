package ua.epam;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        System.out.println("Please, enter an integer.");

        for ( int i = 0; i < 10; i++ ) {
            a = scanner.nextInt();

            FactorialThread f = new FactorialThread(a);

            f.start();
            f.interrupt();
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
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){}

        System.out.println("The factorial of " + number + " is " + factorial(number) + ".");
    }

     private static synchronized long factorial(long number) {
         if (number == 0 || number == 1) {return 1;}
         return (number * factorial(number-1));
     }
}
