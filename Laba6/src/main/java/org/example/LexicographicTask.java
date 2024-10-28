package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LexicographicTask {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        while (sc.hasNext()) {
            data.add(sc.next());
        }
        printfunc(data);
    }

    public static void printfunc(List<String> data) {
        data.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
