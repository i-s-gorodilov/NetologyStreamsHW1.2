import java.util.*;
import java.util.stream.*;

public class StreamMain {

    public static void main(String[] args){
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        Stream<Integer> stream = intList.stream();

        stream = stream.filter(x -> x > 0);
        stream = stream.filter(x -> x % 2 == 0);
        stream = stream.sorted(Comparator.naturalOrder());

        stream.forEach(System.out::println);
    }
}
