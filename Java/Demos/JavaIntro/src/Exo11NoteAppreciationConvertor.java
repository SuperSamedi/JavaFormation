import java.util.Scanner;

public class Exo11NoteAppreciationConvertor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez votre note : ");
        int note = Integer.parseInt(sc.nextLine());
        String appreciation = "I";

        if (note >= 0 && note <= 10){
            appreciation = "I";
        }
        else if (note >= 11 && note <= 12){
            appreciation = "S";
        }
        else if (note >= 13 && note <= 15){
            appreciation = "B";
        }
        else if (note >= 16 && note <= 18){
            appreciation = "TB";
        }
        else if (note >= 19 && note <= 20){
            appreciation = "Excellent";
        }
        else {
            System.out.println("Erreur : note impossible.");
            return;
        }

        System.out.println("Appréciation : " + appreciation);
    }
}
