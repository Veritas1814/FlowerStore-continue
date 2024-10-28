package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
public class GroupWordsTask {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        data=List.of("ABCA", "BCD", "ABC");
//        while (sc.hasNext()) {
//            data.add(sc.next());
//        }
        System.out.println(groupIt(data));
    }

    public static Map<String, Integer> groupIt(List<String> data) {
        return data.stream()
                // Group by the first letter of each word
                .collect(Collectors.groupingBy(word -> word.substring(0, 1)))
                .entrySet()
                .stream()
                // Count how many times the group-key letter appears in all the grouped words
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (int) entry.getValue()
                                .stream()
                                .flatMapToInt(word -> word.chars()
                                        .filter(c -> c == entry.getKey().charAt(0)))
                                .count()
                ));
    }
}
