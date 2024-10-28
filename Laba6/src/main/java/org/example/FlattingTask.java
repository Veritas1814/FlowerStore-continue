package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class FlattingTask {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        while (sc.hasNext()) {
            data.add(sc.next());
        }
        System.out.println(flattingStrings(data));
    }

    public static List<String> flattingStrings(List<String> data) {
        return data.stream()
                .flatMap(word -> word.chars().mapToObj(c -> String.valueOf((char) c)))
                .collect(Collectors.toList());
    }
}
