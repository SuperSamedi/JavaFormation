public class Exo06 {
    public static void main(String[] args) {
        // Demo
        int age = 18;
        int taille = 181;
        boolean grand = taille > 180;
        boolean majeur = age >= 18;
        // Est vrai uniquement si les deux expressions sont vraies
        boolean grandEtMajeur = grand && majeur;
        // Est faux uniquement si les deux expressions sont fausses
        boolean grandOuMajeur = grand || majeur;
        boolean petit = !grand;
        // age++; // Equivalent : age = age + 1
        // age += 2; // Equivalent : age = age +

        if (grandEtMajeur) {
            System.out.println("Bienvenue dans l'attraction");
        }
        if (grand) {
            System.out.println("Tu es grand");
        }
        else {
            System.out.println("Interdit");
        }

        switch (age) {
            case 18:
                System.out.println("A 18 ans");
                break;
            case 19:
                System.out.println("A 19 ans");
                break;
            default:
                System.out.println("Valeur par defaut");
                break;
        }

        // Exo

        int a = 3, b = 9, e = 9;
        boolean c = false, d = !c;

        System.out.println(a > 8);
        System.out.println(b == 9);
        System.out.println(!(a != 3));
        System.out.println(!c);
        System.out.println((a < b) || c);
        System.out.println(!((a+b) != 12));
        System.out.println((b == 5) || ((e > 10) && (a < 8)));
    }
}
