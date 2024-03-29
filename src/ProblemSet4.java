/*
* Problem Set 4.
* Copyright (c) 2019. UCVTS and its affiliated.
*
* Use is allowed as long as credit is given.
*/

import java.util.Scanner;

public class ProblemSet4 {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ProblemSet4 ps = new ProblemSet4();

        // comment out or uncomment as needed

        ps.sum();
        ps.reverse();
        ps.digits();
        ps.average();
        ps.prime();
        ps.fibonacci();
        ps.factors();
        ps.mario();
        ps.luigi();
        ps.credit();

        in.close();
    }

    /*
     * Exercise 1.
     *
     * Prompt the user to enter two integers. The first integer is a lower bound, and
     * the second integer is an upper bound.
     *
     * Compute the sum of all even integers between the lower and upper bounds,
     * including the bounds themselves.
     */

    public void sum() {
      boolean boundsVaild = false;
      boolean upperValid = false;

      System.out.print("\nLower bound: ");
      long lowerBound = in.nextLong();
      System.out.print("Upper bound: ");
      long upperBound = in.nextLong();

      while (!boundsVaild) {
          if (lowerBound <= upperBound) {
            boundsVaild = true;
          }else {
            System.out.print("Lower bound: ");
            lowerBound = in.nextLong();
            System.out.print("Upper bound: ");
            upperBound = in.nextLong();
          }
      }
      if ((lowerBound % 2) == 0) {
        if ((upperBound % 2) == 0) {
          // lowerBound /= 2;
          // upperBound /= 2;
        }else{
          upperBound --;
          // lowerBound /= 2;
          // upperBound /= 2;
        }
      }else {
        if ((upperBound % 2) == 0) {
          lowerBound ++;
          // lowerBound /= 2;
          // upperBound /= 2;
        }else{
          upperBound --;
          lowerBound ++;
          // lowerBound /= 2;
          // upperBound /= 2;
        }
      }
      // System.out.println(upperBound + " " + lowerBound);
      double sum = 0;
      for (long i = lowerBound; i <= upperBound; i++ ) {
        double addOn = i;
        sum += addOn;
        i++;
      }
      System.out.printf("\n%,.0f.\n", sum);
    }

    /*
     * Exercise 2.
     *
     * Prompt the user to enter a positive integer. Print the digits of this integer
     * in reverse order.
     */

    public void reverse() {
      boolean inputValid = false;
      System.out.print("\nPositive integer: ");
      long number = in.nextLong();

      while (!inputValid) {
        if (number > 0) {
          inputValid = true;
        }else{
          System.out.print("Positive integer: ");
          number = in.nextLong();
        }
      }
      System.out.println("");
      long lengthOfNumber = String.valueOf(number).length();
      for (long i = lengthOfNumber; i > 1; i--) {
        int digit = (int) number % 10;
        number /= 10;
        System.out.printf("%d, ", digit);
      }
      int digit = (int) number % 10;
      number /= 10;
      System.out.printf("%d.\n", digit);
    }

    /*
     * Exercise 3.
     *
     * Prompt the user to enter a positive integer. Compute the sum of all of the odd
     * digits in the integer.
     */

    public void digits() {
      boolean inputValid = false;
      System.out.print("\nPositive integer: ");
      long number = in.nextLong();
      long i = 0;
      long total = 0;

      while (!inputValid) {
        if (number > 0) {
          inputValid = true;
        }else{
          System.out.print("Positive integer: ");
          number = in.nextLong();
        }
      }
      long lengthOfNumber = String.valueOf(number).length();

      while (i <= lengthOfNumber) {
        int digit = (int) number % 10;
        number /= 10;
        if ((digit % 2) != 0 ) {
          total += digit;
        }
        i++;
      }
      System.out.println("\n"+ total +".");
    }

    /*
     * Exercise 4.
     *
     * Prompt the user to enter a series of non-negative integers. When the user
     * enters a negative integer, you can assume he or she is done entering values.
     * What is the average of the values entered?
     */

    public void average() {
      boolean finalInput = false;
      double total = 0;
      long average = 0;
      long number = 0;
      double totalNumbers = 0;
      System.out.println("");

      while (!finalInput) {
        System.out.print("Non-negative integers: ");
        number = in.nextLong();
        if (number == -1) {
          total /= totalNumbers;
          finalInput = true;
        }else if (number < 0) {

        }else if (number != 1) {
          total += number;
          totalNumbers ++;
        }
      }
      System.out.printf("\n%,.2f.\n", total);
    }

    /*
     * Exercise 5.
     *
     * Prompt the user to enter a non-negative integer. Is this number prime?
     */

    public void prime() {
      boolean inputValid = false;
      System.out.print("\nNon-negative integer: ");
      long number = in.nextLong();
      boolean isPrime = true;

      while (!inputValid) {
        if (number >= 0) {
          inputValid = true;
        }else{
          System.out.print("Non-negative integer: ");
          number = in.nextLong();
        }
      }
      for (int i = 2; i <= Math.ceil(Math.sqrt(number)) ; i++ ) {
        double testNumber = number;
        if ((testNumber % i) == 0) {
          isPrime = false;
        }
      }

      if (isPrime) {
        System.out.println("\nPrime");
      }else {
        System.out.println("\nNot prime.");
      }
    }

    /*
     * Exercise 6.
     *
     * Prompt the user to enter a positive integer in the range [1, 92]. If the
     * integer the user enters is called n, what is the nth Fibonacci number?
     */

    public void fibonacci() {
      boolean inputValid = false;
      System.out.print("\nPositive integer: ");
      long nth = in.nextLong();
      long number1 = 0;
      long number2 = 1;
      int i = 1;

      while (!inputValid) {
        if ((nth > 0) && (nth <= 92)) {
          inputValid = true;
        }else{
          System.out.print("Positive integer: ");
          nth = in.nextLong();
        }
      }

      while (i <= nth) {
         long sum = number1 + number2;
         number1 = number2;
         number2 = sum;
         i++;
      }
      System.out.println("\n" + number1 + ".");
    }

    /*
     * Exercise 7.
     *
     * Prompt the user to enter a positive integer. What are its factors?
     */

    public void factors() {
      boolean inputValid = false;
      System.out.print("\nPositive integer: ");
      long number = in.nextLong();

      while (!inputValid) {
        if (number > 0) {
          inputValid = true;
        }else{
          System.out.print("Positive integer: ");
          number = in.nextLong();
        }
      }
      System.out.println("");
      System.out.print("1, " + number);
      for (int i = 2; i <= (number /i)  ; i++ ) {
        double testNumber = number;
        if  ((testNumber % i) == 0) {
          System.out.print(", " + i + ", " + (number/i));
        }
      }
      System.out.print(".");
    }

    /*
     * Exercise 8.
     *
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */

    public void mario() {
      boolean inputValid = false;
      System.out.print("\n\nHeight: ");
      int height = in.nextInt();

      while (!inputValid) {
        if (height > 0 && height < 25) {
          inputValid = true;
        }else{
          System.out.print("Height: ");
          height = in.nextInt();
        }
      }

      for(int i = 0; i < height; i++) {
          System.out.println();
          for(int j = 0; j < height - 1 - i; j ++) {
              System.out.print(" ");
          }
          for(int k = 0; k < i + 2; k++) {
              System.out.print("#");
          }
      }

      System.out.println("");
    }

    /*
     * Exercise 9.
     *
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */

    public void luigi() {
      boolean inputValid = false;
      System.out.print("\nHeight: ");
      int height = in.nextInt();

      while (!inputValid) {
        if (height > 0 && height < 25) {
          inputValid = true;
        }else{
          System.out.print("Height: ");
          height = in.nextInt();
        }
      }
      System.out.println("");
      for(int i = 0; i < height; i++) {
            for(int j = 0; j < height - 1 - i; j ++) {
                System.out.print(" ");
            }
            int numberOfHashes = i + 2;
            for(int j = 0; j < i + 2; j ++) {
                System.out.print("#");
            }
            System.out.print("  ");
            for(int j = 0; j < i + 2; j ++) {
                System.out.print("#");
            }
            for(int j = 0; j < height - 1 - i; j ++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /*
     * Exercise 10.
     *
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */

    public void credit() {
       long cardNumber = 0;
       int firstSum = 0;
       int secondSum = 0;
       String sumString = "";
       String typeOfCard = "Invalid";
       String cardString = "";

       System.out.print("\nNumber: ");
       cardNumber = in .nextLong();
       cardString = Long.toString(cardNumber);

       while (cardNumber <= 0) {
           System.out.print("Number: ");
           cardNumber = in .nextLong();
           cardString = Long.toString(cardNumber);
       }

       cardString = Long.toString(cardNumber);
       for (int i = cardString.length() - 2; i > -1; i -= 2) {
           sumString += Integer.toString(2 * Integer.parseInt(cardString.substring(i, i + 1)));
       }

       for (int i = sumString.length() - 1; i >= 0; i --) {
           firstSum += Integer.parseInt(sumString.substring(i, i + 1));
       }

       for (int i = cardString.length() - 1; i >= 0; i -= 2 ) {
           secondSum += Integer.parseInt(cardString.substring(i, i + 1));
       }

       if (cardString.length() == 15 && (cardString.substring(0, 2).equals("37") ||
         cardString.substring(0, 2).equals("34")) && ((firstSum + secondSum) % 10 == 0)) {
           typeOfCard = "Amex";
       } else if ((cardString.length() == 16 || cardString.length() == 13) && ((firstSum + secondSum) % 10 == 0) &&
         (cardString.substring(0, 1).equals("4"))) {
           typeOfCard = "Visa";
       } else if (cardString.length() == 16 && ((firstSum + secondSum) % 10 == 0)) {
           switch (cardString.substring(0, 2)) {
               case "51":
                   typeOfCard = "Mastercard";
                   break;
               case "52":
                   typeOfCard = "Mastercard";
                   break;
               case "53":
                   typeOfCard = "Mastercard";
                   break;
               case "54":
                   typeOfCard = "Mastercard";
                   break;
               case "55":
                   typeOfCard = "Mastercard";
                   break;
           }
       }
       System.out.printf("\n%s.\n", typeOfCard);
   }
}
