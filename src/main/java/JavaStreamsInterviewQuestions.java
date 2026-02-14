import java.util.Collections;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class JavaStreamsInterviewQuestions {
    public static void main(String[] args) {
        List<Integer> ints = List.of(5, 1, 2, 13, 10, 11, 1, 3, 5, 10, 15);
        List<String> strs = List.of("longstring","listen", "silent", "456", "1a2bcd" ,
                "streams api java", "game", "name", "same", "alright", "o", "oai", "else", "throw", "trash");
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

        /*
            31. Write a program to check if all elements in a list of
             strings are of the same length using Java Stream API.
        */
        boolean b = strs.stream().map(s -> s.length()).distinct().count() == 1;

        /*
            32. Given a list of integers, write a program to find and
             print the difference between the maximum and minimum numbers
             using Java Stream API.
        */
        int diff = ints.stream().mapToInt(i -> i).max().orElse(0) -
                ints.stream().mapToInt(i -> i).min().orElse(0);

        /*
            33. Write a program to remove all whitespace from a list
             of strings using Java Stream API.
        */
        strs.stream().map(s -> String.join("", s.split(" "))).toList();
        strs.stream().map(s -> s.replaceAll("\\s", "")).toList();


        /*
            34. Given a list of strings, write a program to find and print
             the strings containing a specific substring using Java Stream API.
        */
        strs.stream().filter(s -> s.contains("am")).toList();

        /*
            35. Write a program to find the mode of a list of integers
             using Java Stream API.
        */
        Map<Integer, Long> frequencyMap = ints.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        long maxFrequency = frequencyMap.values().stream().mapToLong(Long::longValue).max().orElse(0);
        frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Map.Entry::getKey).toList();

        /*
            36. Given a list of strings, write a program to find and print
             the strings with the minimum length using Java Stream API.
        */
        int min = strs.stream().map(s -> s.length()).mapToInt(i->i).min().getAsInt();
        strs.stream().filter(s -> s.length() == min).toList();
        strs.stream().min((s1, s2) -> s1.length() - s2.length()).orElse("");

        /*
            37. Write a program to find the frequency of each element in
             a list of integers using Java Stream API.
        */
        ints.stream().collect(Collectors.groupingBy(i->i, Collectors.counting()));

        /*
            38. Given a list of strings, write a program to find and print
             the strings with the maximum number of vowels using Java Stream API.
        */
        Map<String, Long> fMap = strs.stream()
                .collect(Collectors.toMap(s -> s, s -> s.chars().filter(c -> "AEIOUaeiou".indexOf(c) != -1).count()));
        long maxVowelCount = fMap.values().stream().mapToLong(Long::longValue).max().orElse(0);
        fMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxVowelCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        /*
            39. Write a program to check if a list of integers is sorted in
             ascending order using Java Stream API.
        */
        List<Integer> temp = List.of(-1, 2, 8, 9);
        temp.stream().sorted().toList().equals(temp);

        /*
            40. Given a list of strings, write a program to find and print
             the strings with the minimum number of vowels using Java Stream API.
        */
        long minVowelCount = fMap.values().stream().mapToLong(Long::valueOf).min().orElse(0);
        fMap.entrySet().stream()
                .filter(e -> e.getValue() == minVowelCount)
                .map(e -> e.getKey()).toList();

        /*
            41. Write a program to find the median of a list of integers
             using Java Stream API.
        */
        ints.stream().mapToInt(Integer::intValue).sorted()
                .skip((ints.size() - 1) / 2)
                .limit(ints.size() % 2 == 0 ? 2 : 1)
                .average().orElse(-1);

        /*
            42. Given a list of strings, write a program to find and print the
             strings containing a specific character at least twice using Java Stream API.
        */
        strs.stream().filter(s -> s.chars().filter(c -> c == 'e').count() >= 2).toList();

        /*
            43. Write a program to find the kth smallest element
             in a list of integers using Java Stream API.
        */
        int k = 3;
        ints.stream().sorted().distinct().skip(k-1).findFirst().orElse(-1);

        /*
            44. Given a list of strings, write a program to find and print
             the strings with the maximum number of consonants using Java Stream API.
        */
        fMap = strs.stream()
                .collect(Collectors.toMap(s -> s, s -> s.chars().filter(c -> "AEIOUaeiou".indexOf(c) == -1).count()));
        long maxConsCount = fMap.values().stream().mapToLong(Long::longValue).max().orElse(0);
        fMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxConsCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        /*
            45. Write a program to check if a list of strings is palindrome using Java Stream API.
        */
        strs.stream()
                .skip(strs.size() / 2)
                .allMatch(s -> s.equals(strs.get(strs.size() - 1 - strs.indexOf(s))));

        /*
            46. Given a list of integers, write a program to find and
            print the elements with the highest frequency using Java Stream API.
        */
        frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Map.Entry::getKey).toList();

        /*
            47. Write a program to remove all non-numeric characters
             from a list of strings using Java Stream API.
        */
        Pattern pattern = Pattern.compile("[^0-9]");
        strs.stream()
                .map(s -> pattern.matcher(s).replaceAll(""))
                .collect(Collectors.toList());

        /*
            48. Given a list of strings, write a program to find and print
             the strings containing only digits using Java Stream API.
        */
        strs.stream()
                .filter(s -> pattern.matcher(s).replaceAll("").equals(s))
                .collect(Collectors.toList());

        /*
            49. Write a program to find the kth largest element
             in a list of integers using Java Stream API.
        */
        ints.stream().sorted(Collections.reverseOrder()).distinct().skip(2).findFirst().orElse(-1);

        /*
            50. Given a list of integers, write a program to find and print
             the elements with the lowest frequency using Java Stream API.
        */
        long minFreq = frequencyMap.values().stream().mapToLong(Long::longValue).min().orElse(0);
        frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == minFreq)
                .map(Map.Entry::getKey).toList();

        /*
            51. Check if a list of integers contains a prime number using Java streams.
        */
        ints.stream().anyMatch(JavaStreamsInterviewQuestions::isPrime);

        /*
            52. Merge two sorted lists into a single sorted list using Java streams
        */
        Stream.concat(List.of(1, 2, 3, 4, 5).stream(), List.of(-1, 2, 9, 10, 16).stream())
                .sorted().toList();

        /*
            53. Given a list of transactions, find the sum of transaction
             amounts for each day using Java streams:
        */
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );
        Map<String, Integer> mp = transactions.stream().collect(Collectors
                .groupingBy(t -> t.date, Collectors.summingInt(t -> t.amount)));

        /*
            54. Given a list of strings, find the frequency of each word using Java streams.
        */
        Map<String, Long> freqs = strs.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        /*
            55. Implement a method to partition a list into two groups based
             on a predicate using Java streams:
        */
        Map<Boolean, List<Integer>> evenOddPartitions = ints.stream()
                .collect(Collectors.partitioningBy(e -> e%2 == 0));

        /*
            56. Implement a method to calculate the Fibonacci sequence using Java streams.
        */
        LongStream fibonacci = Stream.iterate(
                        new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
                .mapToLong(f -> f[0]);
        fibonacci.limit(10).forEach(System.out::println);

        /*
            57. Given a list of strings, find the longest common prefix using Java streams
        */
        String longestCommonPrefix = strs.stream()
                .reduce((s1, s2) -> {
                    int length = Math.min(s1.length(), s2.length());
                    int i = 0;
                    while (i < length && s1.charAt(i) == s2.charAt(i)) {
                        i++;
                    }
                    return s1.substring(0, i);
                })
                .orElse("");


        /*
            58. Find the maximum product of two integers in an array using Java streams.
        */
        IntStream.range(0, ints.size())
                .map(i -> IntStream.range(i + 1, ints.size())
                        .map(j -> ints.get(i) * ints.get(j))
                        .max()
                        .orElse(Integer.MIN_VALUE))
                .max()
                .orElse(Integer.MIN_VALUE);

        /*
            59. Implement a method to find all anagrams in a list of strings using Java streams
        */
        strs.stream().collect(Collectors.groupingBy(s -> {
            char[] carr = s.toCharArray();
            Arrays.sort(carr);
            return new String(carr);
        }));

        /*
            60. Find the number of occurrences of a given character in
             a list of strings using Java streams
        */
        strs.stream()
                .map(s -> s.chars().filter(c -> c == 'b').count())
                .mapToLong(Long::longValue)
                .sum();

        strs.stream()
                .flatMapToInt(s -> s.chars())
                .filter(c -> c == 'b')
                .count();

        /*
            61. Given a list of integers, find all pairs of numbers
             that sum up to a given target using Java streams
        */
        ints.stream()
                .flatMap(i -> ints.stream().
                        map(j -> i + j == 12 ? "(" + i + ", " + j + ")" : ""))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toSet());

        /*
            62. Given a list of integers, find all non duplicate
             integers using Java streams
        */
        Map<Integer, Long> frequencies = ints.stream()
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting())
                );

        ints.stream()
                .filter(number -> frequencies.get(number) == 1)
                .forEach(System.out::println);
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

class Transaction {
    String date;
    int amount;
    public Transaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }
}