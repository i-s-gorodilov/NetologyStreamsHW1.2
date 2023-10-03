import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static List<Integer> getPositiveNumbers(List<Integer> intList) {
      List<Integer> positiveList = new ArrayList<Integer>();

      for (int i = 0; i < intList.size(); i++) {
          if (intList.get(i) > 0) {
              positiveList.add(intList.get(i));
          }
      }

      return positiveList;
    };

    public static List<Integer> sortList(List<Integer> posList){
        List<Integer> sortedList = new ArrayList<Integer>();

        for (int i = 0; i < posList.size(); i++)
        {
            if (posList.get(i) % 2 == 0){
                sortedList.add(posList.get(i));
            }
        }

        Collections.sort(sortedList);
        return sortedList;
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> positiveList = getPositiveNumbers(intList);
        positiveList = sortList(positiveList);
        System.out.println("Sorted List: " + positiveList);

    }
}