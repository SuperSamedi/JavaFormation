public class Exo13TableOf2 {
    public static void main(String[] args) {

        int table = 2;
        int multiple = 1;

        while(multiple < 11){
            System.out.printf("%s x %s = %s \n", multiple, table, multiple * table);
            multiple++;
        }

//        int display;
//        for (int i = 1; i < 11; i++){
//            display = i * multiple;
//            System.out.println(String.valueOf(display));
//        }
    }
}
