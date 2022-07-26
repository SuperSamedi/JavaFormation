package brussels.digitalcity.maxdolmans;

import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println(
                Stream
                .iterate(1, x -> x + 1).limit(9)
                .filter((x) -> x % 2 != 0)
                .map((x) -> (int)Math.pow(x, 2))
                .reduce(Integer::sum)
        );
    }

}
