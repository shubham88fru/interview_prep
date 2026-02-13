import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamsInterviewQuestions {
    public static void main(String[] args) {
        List<Integer> ints = List.of(5, 1, 2, 13, 10, 11, 1, 3, 5, 10, 15);
        List<String> strs = List.of("longstring", "game", "name", "same", "alright", "o", "oai", "else", "throw", "trash");

        /*
            1. Write a program to find the sum of all elements
            in a list using Java Stream API
        */
        ints.stream().mapToInt(i->i).sum();

        /*
            2. Given a list of integers, write a program to find
            and print the maximum element using Java Stream API
         */
        ints.stream().mapToInt(i->i).max().orElse(-1);

        /*
            3. Write a program to filter out all the even numbers
            from a list using Java Stream API
        */
        ints.stream().filter(i -> i%2 == 0).toList();

        /*
            4. Given a list of strings, write a program to count the number of strings
             containing a specific character ‘a’ using Java Stream API.
        */
        strs.stream().filter(s -> s.contains("a")).count();

        /*
            5. Write a program to convert a list of strings to
            uppercase using Java Stream API.
        */
        strs.stream().map(s -> s.toUpperCase()).toList();

        /*
            6. Given a list of integers, write a program to calculate
            the average of all the numbers using Java Stream API.
        */
        ints.stream().mapToDouble(d -> d).average().orElse(0.0);

        /*
            7. Write a program to sort a list of strings in
            alphabetical order using Java Stream API.
        */
        strs.stream().sorted().toList();

        /*
            8. Given a list of strings, write a program to
            concatenate all the strings using Java Stream API.
        */
        strs.stream().collect(Collectors.joining());

        /*
            9. Write a program to find the longest string
            in a list of strings using Java Stream API.
        */
        strs.stream().max((s1, s2) -> s1.length() - s2.length()).orElse("");

        /*
            10. Given a list of integers, write a program to find
             and print the second largest number using Java Stream API.
        */
        ints.stream().sorted((i1, i2) -> i2-i1).skip(1).findFirst().orElse(-1);

        /*
            11. Write a program to remove all the duplicate
            elements from a list using Java Stream API.
        */
        ints.stream().distinct().toList();

        /*
            12. Given a list of strings, write a program to find
             and print the shortest string using Java Stream API.
        */
        strs.stream().min((s1, s2) -> s1.length() - s2.length()).orElse("");

        /*
            13. Write a program to convert a list of integers to
             a list of their squares using Java Stream API.
        */
        ints.stream().map(i -> i*i).toList();

        /*
            14. Given a list of strings, write a program to
            find and print the strings starting with a specific
            prefix ‘a’ using Java Stream API.
        */
        strs.stream().filter(s -> s.startsWith("a")).toList();

        /*
            15. Write a program to find the product of all elements
             in a list of integers using Java Stream API.
        */
        ints.stream().reduce(1, (a, b) -> a*b);

        /*
            16. Given a list of integers, write a program to find and
            print the prime numbers using Java Stream API.
        */
        ints.stream().filter(i -> isPrime(i)).toList();

        /*
            17. Write a program to check if a list of strings contains
             a specific string using Java Stream API.
        */
        strs.stream().anyMatch(s -> s.equals("name"));

        /*
            18. Given a list of strings, write a program to find and print the
             strings with length greater than a specified value 5 using Java Stream API.
        */
        strs.stream().filter(s -> s.length()>5).toList();

        /*
            19. Write a program to filter out all the elements divisible
             by 3 and 5 from a list of integers using Java Stream API.
        */
        ints.stream().filter(i -> (i%3==0 && i%5==0)).toList();

        /*
            20. Given a list of strings, write a program to find and print
             the strings with the maximum length using Java Stream API.
        */
        strs.stream().max((s1, s2) -> s1.length()-s2.length()).orElse(null);

        /*
            21. Write a program to reverse a list of strings using Java Stream API.
        */
        Collections.reverse(strs);

        /*
            22. Given a list of integers, write a program to find and print
            the distinct odd numbers using Java Stream API.
        */
        ints.stream().filter(i-> i%2!=0).distinct().toList();

        /*
            23. Write a program to remove all null values from a list
             of strings using Java Stream API.
        */
        strs.stream().filter(s -> s != null).toList();

        /*
            24. Given a list of integers, write a program to find and
             print the sum of all odd numbers using Java Stream API.
        */
        ints.stream().filter(i -> i%2 != 0).mapToInt(i->i).sum();

        /*
            25. Write a program to find the intersection of two
             lists of strings using Java Stream API.
        */
        ints.stream().filter(i -> List.of(2, 3, 8, 9, 1).contains(i)).toList();

        /*
            26. Given a list of strings, write a program to find and print the
             strings containing only vowels using Java Stream API.
        */
        strs.stream().filter(s -> s.matches("[aeiouAEIOU]+")).toList();

        /*
            27. Write a program to convert a list of strings to a
             comma-separated string using Java Stream API.
        */
        strs.stream().collect(Collectors.joining(", "));

        /*
            28. Given a list of integers, write a program to find and
             print the index of the first occurrence of a specific number
             using Java Stream API.
        */
        IntStream.range(0, ints.size()).filter(i -> ints.get(i).equals(13))
                .findFirst().orElse(-1);

        /*
            29. Write a program to find the union of two lists
             of integers using Java Stream API.
        */
        Stream.concat(ints.stream(), List.of(4, -1, 2, 0).stream()).distinct().toList();

        /*
            30. Given a list of strings, write a program to find
             and print the strings containing duplicate characters
             using Java Stream API.
        */
        strs.stream().filter(s -> s.length() != s.chars().distinct().count()).toList();
    }

    private static boolean isPrime(int num) {
        if (num == 1) return false;
        if (num == 2) return true;

        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num%i == 0) return false;
        }

        return true;
    }
}
