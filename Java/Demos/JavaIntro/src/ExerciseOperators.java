import java.util.Scanner;

public class ExerciseOperators {
    public static void main(String[] args) {
//Exercice 03
        int a, b, c, d, e;

        a = 8 % 3;
        b = 4 + a;
        c = b * a;
        d = (c - a) * b;
        e = ((a + 7) * (d / a)) * 0;

        System.out.println();

//Exercice 04
        int intA = 5, intB = 7;

        intA = intA + intB;
        intB = intA - intB;
        intA = intA - intB;

        System.out.println();

//Exercice 05
//        int totalSeconds = 4561;
//        int days, hours, minutes, seconds;
//
//        days = totalSeconds / 86400;
//        totalSeconds -= days * 86400;
//        hours = totalSeconds / 3600;
//        totalSeconds -= hours * 3600;
//        minutes = totalSeconds / 60;
//        seconds = totalSeconds % 60;
//
//
//        System.out.println(totalSeconds + " seconds = " + days + " days " + hours + " hours " + minutes + " minutes " + seconds + " seconds.");

//        Reponse prof
        int daysTotal, hoursTotal, minutesTotal, secondsTotal;
        int hours, minutes, seconds;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number of seconds : ");

        System.out.printf("%s seconds = %s days %s hours %s minutes %s seconds.");
    }
}
