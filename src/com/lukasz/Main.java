package com.lukasz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Integer> convertToList(String in) {
        String[] input = in.split(",");

        List<Integer> lengths = new ArrayList<>();

        if(input.length > 1) {
            for (String s : input) {
                if(s.contains(" ")) s = s.substring(1);
                lengths.add(Integer.parseInt(s));
            }
        }


        return lengths;
    }

    private static List<Integer> convertToListPart2(String input) {

        List<Integer> lengths = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int currentChar = (int) input.charAt(i);
            lengths.add(currentChar);
        }

        lengths.addAll(Arrays.asList(17, 31, 73, 47, 23));

        return lengths;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your input");
        String input = scanner.nextLine();

        List<Integer> lengths = convertToList(input);
        List<Integer> lengthsPart2 = convertToListPart2(input);


        Solution solution = new Solution(lengths);
        solution.hash();
        Solution solution2 = new Solution(lengthsPart2);
        solution2.hash64();

        System.out.println("Result of multiplying the first two numbers in the list is " + solution.getFirstTimesSecond());
        System.out.println("Knot Hash is " + solution2.getKnotHash());
    }
}
