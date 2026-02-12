import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamsInterviewQuestions {
    public static void main(String[] args) {
        List<Integer> ints = List.of(5, 1, 2, 10, 11, 1, 3);
        List<String> strs = List.of("game", "name", "same", "else", "throw", "trash");

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
    }
}
