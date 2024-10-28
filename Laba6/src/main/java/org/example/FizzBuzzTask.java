package org.example;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class FizzBuzzTask {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(fizzBuzzIt(sc.nextInt()));
    }
    public static List<String> fizzBuzzIt(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(i -> {
                    if (i % 3 == 0 && i % 5 == 0) {
                        return "Fizz Buzz";
                    } else if (i % 3 == 0) {
                        return "Fizz";
                    } else if (i % 5 == 0) {
                        return "Buzz";
                    } else {
                        return String.valueOf(i);
                    }
                })
                .collect(Collectors.toList());
    }
}
