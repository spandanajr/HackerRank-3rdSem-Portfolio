
import java.util.*;

public class SparseArrays {

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {

        Map<String, Integer> frequency = new HashMap<>();

        for (String str : stringList) {
            frequency.put(str, frequency.getOrDefault(str, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (String query : queries) {
            result.add(frequency.getOrDefault(query, 0));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stringList.add(sc.nextLine());
        }

        int q = sc.nextInt();
        sc.nextLine();

        List<String> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            queries.add(sc.nextLine());
        }

        List<Integer> result = matchingStrings(stringList, queries);

        for (int count : result) {
            System.out.println(count);
        }

        sc.close();
    }
}
