
import java.util.*;

public class DynamicArray {

    public static List<Integer> dynamicArray(
            int n, List<List<Integer>> queries) {

        List<List<Integer>> arr = new ArrayList<>();

        // Create n empty sequences
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        int lastAnswer = 0;
        List<Integer> answers = new ArrayList<>();

        // Process all queries
        for (List<Integer> query : queries) {

            int type = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            int idx = (x ^ lastAnswer) % n;

            if (type == 1) {
                arr.get(idx).add(y);
            } else if (type == 2) {
                lastAnswer = arr.get(idx).get(
                    y % arr.get(idx).size()
                );
                answers.add(lastAnswer);
            }
        }

        return answers;
    }

    public static void main(String[] args) {

        int n = 2;

        List<List<Integer>> queries = Arrays.asList(
            Arrays.asList(1, 0, 5),
            Arrays.asList(1, 1, 7),
            Arrays.asList(1, 0, 3),
            Arrays.asList(2, 1, 0),
            Arrays.asList(2, 1, 1)
        );

        List<Integer> result = dynamicArray(n, queries);

        for (int answer : result) {
            System.out.println(answer);
        }
    }
}
