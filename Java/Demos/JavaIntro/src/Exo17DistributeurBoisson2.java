import java.util.Scanner;

public class Exo17DistributeurBoisson2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stockOrangeSoda = 0;
        int stockIcedTea = 3;
        int stockAppleJuice = 1;

        while(stockOrangeSoda > 0 || stockIcedTea > 0 || stockAppleJuice > 0){
            System.out.println("Chose a drink.");
            System.out.println("1 : Orange Soda");
            System.out.println("2 : Iced Tea");
            System.out.println("3 : Apple Juice");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1 :
                    if (stockOrangeSoda > 0){
                        System.out.println("Here is an Orange Soda !");
                        stockOrangeSoda--;
                        break;
                    }
                    System.out.println("Sorry, there is no more Orange Soda...");
                    break;
                case 2 :
                    if (stockIcedTea > 0){
                        System.out.println("Here is an Iced Tea !");
                        stockIcedTea--;
                        break;
                    }
                    System.out.println("Sorry, there is no more Iced Tea...");
                    break;
                case 3 :
                    if (stockAppleJuice > 0){
                        System.out.println("Here is an Apple Juice !");
                        stockAppleJuice--;
                        break;
                    }
                    System.out.println("Sorry, there is no more Apple Juice...");
                    break;
                default :
                    System.out.println("Sorry, couldn't find any drink matching your selection.");
            }
        }

        System.out.println("The machine is empty, come back later...");
    }
}
