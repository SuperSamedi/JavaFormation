package brussels.digitalcity.tu.exo.triangle;

import java.awt.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean triangulating = true;
        while(triangulating) {
            Triangle tri = new Triangle();

            System.out.println("Let's create a new triangle!");
            scan.nextLine();

            boolean validInput = false;
            while (!validInput) {
                System.out.println("How long should side A be? ...");
                String input = scan.nextLine();

                try{
                    tri.setSideA(Integer.parseInt(input));
                    validInput = true;
                }
                catch(NumberFormatException ex){
                    System.out.println("Error - invalid input - Please enter an integer number.");
                }
            }

            validInput = false;
            while (!validInput) {
                System.out.println(
                        "\nSide A = " + tri.getSideA() +
                        "\nHow long should side B be? ..."
                );
                String input = scan.nextLine();

                try{
                    tri.setSideB(Integer.parseInt(input));
                    validInput = true;
                }
                catch(NumberFormatException ex){
                    System.out.println("Error - invalid input - Please enter an integer number.");
                }
            }

            validInput = false;
            while (!validInput) {
                System.out.println(
                        "\nSide A = " + tri.getSideA() +
                        "\nSide B = " + tri.getSideB() +
                        "\nHow long should side C be? ..."
                );
                String input = scan.nextLine();

                try{
                    tri.setSideC(Integer.parseInt(input));
                    validInput = true;
                }
                catch(NumberFormatException ex){
                    System.out.println("Error - invalid input - Please enter an integer number.");
                }
            }

            System.out.println(
                    "\nSide A = " + tri.getSideA() +
                    "\nSide B = " + tri.getSideB() +
                    "\nSide C = " + tri.getSideC() +
                    "\nOK, Let's create that triangle! ..."
            );
            scan.nextLine();

            try{
                System.out.println("Well done! You made a beautiful " + tri.checkValidity().name().toLowerCase() + " triangle!");
            }
            catch (TriangleException ex) {
                System.out.println(ex.getMessage());
            }

            // Draw it in console????
            //----------#
            //---------#--#
            //--------#------#
            //------############
            // triangle
            drawTriangle(tri.getSideA(), tri.getSideB(), tri.getSideC());

            System.out.println("\nLet's make a new one?");

            validInput = false;
            while (!validInput) {
                System.out.println("Y/N");
                String input = scan.nextLine();

                switch (input) {
                    case "Y", "y" -> {
                        System.out.println("OK, here we go!");
                        validInput = true;
                    }
                    case "N", "n" -> {
                        System.out.println("Alright, cya!");
                        validInput = true;
                        triangulating = false;
                    }
                    default -> System.out.println("Error - invalid input - Please enter Y or N.");
                }
            }
        }
    }

    private static void drawTriangle(int sideA, int sideB, int sideC) {
        // Triangle height = 2 * Area / base
        // Heron's formula:
        // Area = sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))

        // base = largest side
        int b = sideB;
        int a = sideA;
        int c = sideC;

        if (sideA > b) {
            b = sideA;
            a = sideB;
            c = sideC;
        }
        if(sideC > b) {
            b = sideC;
            a = sideA;
            c = sideB;
        }

        // semi-perimeter
        double s = (sideA + sideB + sideC) * 0.5;

        // Area
        double A = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));

        // height
        double h = 2 * A / b;

        // base 2 sides (cut by height perpendicular)

        //      +
        //     +|--+
        //  a +-|----+ c
        //   +--| h-----+
        // +----+----------+
        //   d  +    e

        // b = d + e

        double d;
        double e;

        // a² = h² + d²
        // a² - h² = d²
        // sqrt(a² - h²) = d
        d = Math.sqrt(Math.pow(a, 2) - Math.pow(h, 2));
        e = b - d;

        // We'll try to draw 10 lines high.
        // h * x = 10
        // x = 10 / h
        int heightLimit = 10;
        d *= heightLimit / h; // first part of base
        e *= heightLimit / h; // second part of base

        String sign = "[ ]";
        StringBuilder sb = new StringBuilder();
        int lineCount = 0;
        String lineStart = "\n" + lineCount +" ";

        // Each line.
        for (int i = heightLimit; i > 0; i--) {
            lineCount++;
            sb.append(lineStart);

            // Each char space of the line
            for (int j = 0; j < Math.round(d + e) + 1; j++) {
                // Before height line. (compare to d)
                if (j == Math.round(d / heightLimit) * i){
                    sb.append(sign);
                }
                else {
                    sb.append(" ");
                }
                // After height line. (compare to e)
            }
        }
        // Line 1:
        sb.append(lineStart);
        for (int i = 0; i < Math.round(d) - 1; i++) {
            sb.append(" ");
        }
        sb.append(sign);

        // Line 2
        sb.append(lineStart);


        // Line 10
        sb.append(lineStart);
        for (int i = 0; i < Math.round(d + e); i++) {
            sb.append(sign);
        }

        System.out.println(sb);

    }
}

