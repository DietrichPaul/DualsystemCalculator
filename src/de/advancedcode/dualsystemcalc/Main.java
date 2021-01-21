package de.advancedcode.dualsystemcalc;

import java.util.Scanner;

public class Main {

    private static final double[] table = new double[8];

    public static void main(String[] args) {
        // fill table
        for (int i = 0; i < table.length; i++)
            table[i] = Math.pow(2, table.length - i - 1);

        while (true) {
            // input
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter your mode. 0 = decimal to binary; 1 = binary to decimal");

            int mode = scanner.nextInt();

            // calc
            switch (mode) {

                case 0:
                    System.out.println("Enter your decimal");
                    int decimal = scanner.nextInt();
                    double state = 0;
                    String binary = "";

                    for (int i = 0; i < table.length; i++) {
                        double d = table[i];
                        if (d > decimal) {
                            binary += "0";
                            continue;
                        }
                        if (state + d > decimal) {
                            binary += "0";
                            continue;
                        }
                        state += d;
                        binary += "1";
                    }
                    System.out.println(state + " | " + binary);

                    break;

                case 1:

                    System.out.println("Enter your binary");
                    String bin = scanner.next();

                    double d = 0;
                    char[] chars = bin.toCharArray();
                    int lengthDelta = table.length - chars.length;

                    for (int i = lengthDelta; i < table.length; i++) {
                        char c = chars[i - lengthDelta];
                        if (c == '0')
                            continue;
                        d += table[i];
                    }

                    System.out.println(bin + " | " + d);
                    break;

                default:
                    System.out.println("You entered an invalid mode.");

            }
        }
    }

}
