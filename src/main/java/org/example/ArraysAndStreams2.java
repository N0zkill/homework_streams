package org.example;

// Fig. 17.12: ArraysAndStreams2.java
// Demonstrating lambdas and streams with an array of Strings.
import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
   public static void main(String[] args) {
      String[] strings =
              {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

      // display original strings
      System.out.printf("Original strings: %s%n", Arrays.asList(strings));

      // strings in uppercase
      System.out.printf("strings in uppercase: %s%n",
              Arrays.stream(strings)
                      .map(String::toUpperCase)
                      .collect(Collectors.toList()));

      // strings less than "n" (case insensitive) sorted ascending
      System.out.printf("strings less than n sorted ascending: %s%n",
              Arrays.stream(strings)
                      .filter(s -> s.compareToIgnoreCase("n") < 0)
                      .sorted(String.CASE_INSENSITIVE_ORDER)
                      .collect(Collectors.toList()));

      // strings less than "n" (case insensitive) sorted descending
      System.out.printf("strings less than n sorted descending: %s%n",
              Arrays.stream(strings)
                      .filter(s -> s.compareToIgnoreCase("n") < 0)
                      .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                      .collect(Collectors.toList()));

      // 1. Filter strings that start with a vowel (case-insensitive)
      System.out.printf("Strings starting with a vowel: %s%n",
              Arrays.stream(strings)
                      .filter(s -> s.toLowerCase().matches("^[aeiou].*"))
                      .collect(Collectors.toList()));

      // 2. Concatenate all the strings into a single string separated by a comma
      String concatenated = Arrays.stream(strings)
              .collect(Collectors.joining(", "));
      System.out.printf("Concatenated string: %s%n", concatenated);

      // 3. Count the number of strings that contain more than 5 characters
      long count = Arrays.stream(strings)
              .filter(s -> s.length() > 5)
              .count();
      System.out.printf("Number of strings with more than 5 characters: %d%n", count);
   }
}
