# MS Top LC

1.	LC 1. Two sum
      a.	Brute
        i.	Check each pair -> O(nˆ2)
      b.	Map -> O(n), O(n)

2.  LC 2. Add two numbers
      a. Brute
        i. LL traversal, dummy node for ans -> O(n)

3.	LC 5. Longest palindromic substring
      a.	Brute
         i.	Generate substring of all length starting from largest to smallest -> O(nˆ3)
      b.	Top down
         i.	Boolean array -> O(Nˆ2), O(Nˆ2)
      c.	Bottom up
         i.	Check palindrome for each sub (i..j) and keep caching the result for faster check for later subs -> O(nˆ2), O(nˆ2)

4. LC 146. LRU cache
    a. Brute - HashMap, and Singly Linked list
       i. TC: get -> O(n), TC: put -> O(1)
    a. HashMap and DLL -> O(1)

5. LC 3. Longest substring without repeating chars
    a. Brute.
        i. Generate all subs, in each sub check if it doesn't repeat and record. -> O(nˆ2)
    b. Sliding window -> O(n)

6.	LC 11. Container with most water
      a.	Brute
         i.	Take each rod as left and find a right that gives max area -> O(nˆ2)
      b.	Two pointer -> O(n)

7.  LC 53. Maximum subarray
      a.  Brute
         i. Generate all subs (two loops) - O(nˆ2)
      b.  Optimal
         ii. Kadanes' algo one pass, keep track of max - O(n)

8. LC 121. Best Time to Buy and Sell Stock
    a. Brute.
        i. Buy at each and then check best day to sell while keeping track of max. -> O(nˆ2)
    b. Sliding window. -> O(n)
    c. Buy at min and sell at max. Keep track of min and keep calculating max diff. -> TC: O(n), SC: O(1)
    d. Recursion memo -> TC: O(n), SC: O(n)

9. LC 14. Longest Common Prefix
       a. Brute.
           i. Check each substring of first string in the rest of the strings.
           ii. TC: O(n*m); where n is length of first string and m is number of strings. SC: O(nˆ2)
       b. Optimized
           i. TC: O(n*m); where n is length of first string and m is number of strings. SC: O(1)
       c. Trie
           ii. TC: O(n*m); where n is length of first string and m is number of strings. SC: O(n)

10. LC 1797. Design authentication manager.
    a. Brute
        i. Using hashmap --> O(n) for get unexpired token call
        ii. Works because its given that timestamps are in increasing order.
    b. LRU using DLL ??
        i. We can keep the token in a increasing order in DLL, which would have the
        added benefit of moving renewed token to front in constant time. When counting
        unexpired tokens, we can break early when we find the first expired token which
        will improve runtime in avg case. But worst case TC will still be O(n)

11. LC 560. Subarray Sum Equals K
    a. Brute
        i. Calculate sum for each subarray -> TC: O(nˆ2), SC: O(1).
    b. Optimal - HashMap and Prefix sum
        i. TC: O(n), SC: O(n)

12. LC 200. Number of Islands
    1. BFS/DFS
        1. TC: O(m*n), SC: O(1)
        
13. LC 238. Product of Array Except Self
    1. Brute - for each multiply the rest
        1. TC: O(nˆ2), SC: O(1)
    2. Noob - divide overall pdt by each. Not allowed as per q.
        1. TC: O(N), SC: O(1)
    3. Suboptimal - prefix and suffix array
        1. TC: O(N), SC: O(N)
    4. Optimal - without extra space
        1. TC: O(N), SC: (1)

14. LC 9. Palindrome number
    a. Brute
        i. Convert the number to string, reverse and then compare. -> O(n), O(n)
    b. Math reverse using % and / -> O(log(n)) where its log to base 10
    c. Optimal
        i. Same as b. but with early return. Only do till og x is > rev, see lc editorial.

15. LC 70. Climbing Stairs
    a. Brute - plain recursion
        i. TC: O(2ˆn), SC: O(n)
    b. DP recursion with memo
        i. TC: O(n), SC: O(n)
    c. Fibonacci with two variables.
        i. TC: O(n), SC: O(1)

16. LC 42. Trapping Rain Water
    a. Brute - For each find left and right boundary.
        i. TC: O(nˆ2), SC: O(1)
    b. Better - prefix nand suffix max
        i. TC: O(n), SC: O(n)
    c. Stack ??
        i. TC: O(n), SC: O(n)
    d. Optimal - Two pointer.
        i. TC: O(n), SC: O(1)

17. LC 4. Median of Two Sorted Arrays
    a. Brute - Copy to new array and sort.
        i. TC: O(n+m + (n+m)log(m+n)), SC: O(m+n)
    b. Better - merge two sorted arrays.
        i. TC: O(m+n), SC: O(m+n)
    c. Even better - merge two sorted arrays but dont' form a new array, just keep track of mid and mid+1
        i. TC: O(m+n), SC: O(1)
    d. Optimal - Binary search
        i. TC: O(log(m+n)), SC: O(1)

18. LC 15. 3Sum
    a. Brute - 3 loops and set for duplicate check.
        i. TC: O(nˆ3), SC: O(n)
    b. Better - 2 loops + set + two sum logic.
        i. TC: O(nˆ2), SC: O(n)
    c. Optimal - Sort and 3 pointers.
        i. TC: (nlog(n) + nˆ2), SC: O(1)

19. LC 23. Merge k Sorted Lists
    1. Optimal - merge sort ??
        1. TC: O(N*log(k)) -> N is total num of nodes and K is num of lists, SC: O(1)
    2. Optimized heap
        1. TC: O(N*log(k)) -> N is total num of nodes and K is num of lists, SC: O(k)
    3. Naive heap
        1. TC: O(N*log(N)) -> N is total num of nodes, SC: O(N)
    4. Brute force merge 2 lists successively
        1. TC: O(k*N) -> N is total num of nodes and K is num of lists, SC: O(1)
        
20. LC 26. Remove Duplicates from Sorted Array
    1. Brute - Using extra array and set
        1. Store values in extra array and use set to track duplicate.
        2. TC: O(n), SC: O(2n)
    2. Better - Same array, two pointers, and set
        1. TC: O(n), SC: O(n)
    3. Optimal - two pointers
        1. TC: O(n), SC: O(1)

21. LC 27. Remove Element
    1. Brute - Using extra array
        i. TC: O(n), SC: O(n)
    2. Optimal - in place using two pointers
        1. TC: O(n), SC: O(1)


22. LC 49. Group anagrams
    i. brute - sort each string and map
        a. TC: O(n*klog(k)), SC: O(n), where n is num of string and k is length of max string.
    a. Hashmap and freq array --> O(n*k)

23. LC 75. Sort colors
    a. Brute
        i. Sort -> O(nlog(n))
    b. 3 pass
        i. Manually sort (using single for loop) each code (0, 1, 2) one by one. -> O(3N)
    c. 2 pass
        i. Iterate and store freq of 0, 1, and 2. Then Iterate and replace each el in array --> O(2N)
    d. Dutch National Flag algo, 1 Pass
        i. [0..low-1] --> 0
           [low..mid-1] --> 1
           [mid..high] --> unsorted
           [high+1..n-1] --> 2

24. LC 283. Move zeros
    a. Brute - use extra array
        i. TC: O(n), SC: O(n)
    b. Two pointer
        i. TC: O(n), SC: O(1)

25. LC 424. Longest repeating character replacement.
    a. Brute
        i. generate all subs, in each sub, replace each char with a char of sub and see if
            it can be done within k replacement to make all chars same --> O(nˆ2 +..)
    b. Optimal - Sliding window
        i. TC: O(n), SC: O(1) coz the map only stores the 26 english alphas

26. LC 2858. Minimum Edge Reversals So Every Node Is Reachable
    a. Brute
        i. DFS from each node. TC: O(V*(V+E))
    b. Optimal - DFS from root, store cost and depth.
        i. TC: O(V+E)

27. LC 7. Reverse Integer
    a. Brute - convert to string and reverse string.
        i. TC: O(log(n)), SC: O(log(n))
    b. Better - use long for overflow check.
        i. TC: O(log(n)), SC: O(1)
    c. Optimal - use int for overflow check.
        i. TC: O(log(n)), SC: O(1)

28. LC 13. Roman to Integer
    a. Brute - store in map
        i. TC: O(N), SC: O(1)

29. LC 33. Search in rotated sorted array.
     a. Brute
        i. Linear search -> O(n)
     b. Modified Binary search -> O(log(n))
     
30. LC 54. Spiral Matrix
    1. Simulation
        1. TC: O(N*M), SC: O(1)
        
31. LC 189. Rotate Array
    1. Brute
        1. rotate k times -> O(n*k), O(1)
    2. Better
        1. Use extra space to store rotated values and copyback -> TC: O(n), SC: O(n)
    3. Optimal
        1. reverse 0..n-1, then reverse 0..k-1, then reverse k..n-1 --> TC: O(~n), SC: O(1)

32. LC 17. Letter Combinations of a Phone Number
    1. Brute - backtracking
        i. TC: O(n*4ˆn), SC: O(n)

33. LC 19. Remove Nth Node From End of List
    1. Brute - Two pass
        i. TC: O(n), SC: O(1)
    2. Optimal - Two pointer
        i. TC: O(n), SC: O(1)

34. LC 21. Merge two sorted lists
    a. Brute
        i. Store nodes in arraylist, sort array list and then link -> O(n+m + (n+m)log(n+m) + n + m), O(n+m)
    b. Merge using third LL --> O(n+m), O(n+m)
    c. Inplace merge -> O(n+m), O(1)
    
35. LC 34. Find First and Last Position of Element in Sorted Array
    1. Brute - linear search
        1. TC: O(n), SC: O(1)
    2. Optimal - binary search
        1. TC: O(log(n)), SC: O(1)

36. LC 50. Pow(x, n)
    1. Brute - linear
        1. TC: O(n), SC: O(1)
    2. Better - binary exponentiation recursive.
        1. TC: O(log(n)), SC: O(log(n))
    3. Optimal - binary exponentiation iterative.
        1. TC: O(log(n)), SC: O(1)

37. LC 56. Merge intervals
    a. Sort and loop ->  O(nlog(n) + n + n)

38. LC 215. Kth Largest Element in an Array
    a. Brute - sort
        i. TC: O(nlog(n)), SC: O(1)
    b. Better - min heap
        i. TC: O(nlog(k)), SC: O(k)
    c. Optimal - quick select ??
        i. TC: O(n) in avg case but worst case O(nˆ2), SC: O(1)

39. LC 101. Symmetric tree
    a. DFS -> O(n), SC: O(n)
    b. BFS -> O(n), SC: O(n)

40. LC 138. Copy List with Random Pointer
    a. Better - HashMap
        i. TC: O(n), SC: O(n)
    b. Optimal - Pointers --> clever but tricky to code ??
        i. TC: O(3n), SC: O(1)

41. LC 498. Diagonal Traverse
    a. Better - HashMap
        i. TC: O(m*n), SC: O(m+n)
    b. Optimal --> no hashmap ?? tricky to code.
        i. TC: O(m*n), SC: O(1)

42. LC 696. Count Binary Substrings
    a. Optimal - sliding window
        i. TC: O(n), SC: O(1)

43. LC 1475. Final Prices With a Special Discount in a Shop
      a. Brute
        i. For each, check the first smaller on right -> O(nˆ2)
      b. Stack
        i. Left to right or vice versa, using stack. -> O(n)

44. LC 31. Next Permutation
      a. Brute - Generate all perms and in that find the next one.
        i. TC: O(n!), SC: O(n)
      b. One pass - two pointer.
        i. TC: O(n), SC: O(1)

45. LC 78. Subsets
      a. Backtracking 1
        i. TC: O(n*2ˆn), SC: O(n)
      b. Backtracking 2
        i. TC: O(n*2ˆn), SC: O(n)
      c. Bit manip
        i. TC: O(n*2ˆn), SC: O(n)

46. LC 103. Binary Tree Zigzag Level Order Traversal
      a. BFS - reverse odd levels
        i. TC: O(n), SC: O(n)

47. LC 162. Find Peak Element
      a. Brute - linear search
        i. TC: O(n), SC: O(1)
      b. Optimal - binary search
        i. TC: O(log(n)), SC: O(1)

48. LC 242. Valid anagram
    a. 26 len array -> O(n)
    b. hashmap (if lets say the string contains special chars/unicode) -> O(n), O(n)

49. LC 863. All Nodes Distance K in Binary Tree
    a. Hashmap - TC: O(n)

50. LC 875. Koko Eating Bananas
    a. Brute - linear search
        i. TC: O(n), SC: O(1)
    b. Optimal search - binary search
        i. TC: O(log(n)), SC: O(1)

51. LC 169. Majority Element
    a. Brute - Check freq of each element
        i. TC: O(nˆ2), SC: O(1)
    b. Slightly better - Sorting
        i. TC: O(n*log(n)), SC: O(1)
    c. Better - Hashmap
        i. TC: O(n), SC: O(n)
    d. Optimal - Moore's voting
        i. TC: O(n), SC: O(1)

52. LC 1768. Merge Strings Alternately
    a. Optimal - two pointer
        i. TC: O(m+n), SC: (m+n)

53. LC 3507. Minimum Pair Removal to Sort Array I
    a. Optimal - simulation using list.
        i. TC: O(nˆ2), SC: (n)
        
54. LC 20. Valid Parentheses
    a. Optimal - Stack
        i. TC: O(N), SC: O(N)

54. LC 66. Plus One
    a. Brute - simple addition
        i. TC: O(2N), SC: O(N)
    b. Optimal - smart addition
        i. TC: O(n), SC: O(1)

54. LC 93. Restore IP Addresses
    a. Backtracking
      i. Standard backtracking template --> O(MˆN) ??????? 3ˆn

55. LC 102. Binary Tree Level Order Traversal
    a. BFS
      i. TC: O(n), SC: O(n)
    b. DFS
      i. TC: O(n), SC: O(n)

56. LC 733. Flood Fill
    a. BFS
      i. TC: O(n), SC: O(n)
    b. DFS
      i. TC: O(n), SC: O(n)

56. LC 1971. Find if Path Exists in Graph
    a. BFS
      i. TC: O(V+E), SC: O(V+E)
    b. DFS
      i. TC: O(V+E), SC: O(V+E)
    c. Optimal - DSU
      i. TC ??

57. LC 2571. Minimum Operations to Reduce an Integer to 0
    a. Recursion
      i. TC: O(log(n)ˆ2), SC: O(log(n))
    b. Recursion + memo
      i. TC: O(log(n)), SC: O(log(n))

58. LC 57. Insert Interval
    a. Brute - add interval and sort again
      i. TC: O(nlog(n)), SC: O(n)
    b. Optimal - add smartly and merge interval
      i. TC: O(n), SC: O(n)

59. LC 100. Same Tree
    a. BFS
      i. TC: O(n), SC: O(n)
    b. DFS
      i. TC: O(n), SC: O(n)

60. LC 125. Valid Palindrome
    1. Brute - Stringbuilder
        1. TC: O(n), SC: O(n)
    2. Optimal - two pointer
        1. TC: O(n), SC: O(1)

61. LC 84. Largest Rectangle in Histogram
    1. Brute - for each find left and right boundary
        1. TC: O(nˆ2), SC: O(1)
    2. Optimal - monotonic stack
        1. TC: O(n), SC: O(n)

62. LC 127. Word Ladder
    1. BFS
        i. TC: O(nˆ2*m) - where n is number of words and m is length of each word.
           SC: O(nˆ2) - we'll need to store nˆ2 edges because worst case each word will have edge to every other word.

63. LC 142. Linked List Cycle II
    1. Brute - hashset
        i. TC: O(n), SC: O(n)
    2. Optimal - f and s pointers, and tortoise and hare algo.
        i. TC: O(n), SC: O(1)

17. LC 73. Set Matrix Zeroes
    a. Brute
        i. Using a separate copy matrix --> O(m*n), O(m*n)
    b. Two arrays/set to track rows/cols
        i. Use 2 arrays/sets to track the rows and cols that
           that need to be zero. --> O(m*n), O(m+n)
    c. Space efficient soln
        i. use first row and col to track which rows/cols
           need to marked zero --> O(m*n), O(1)

23. LC 16. 3 Sum closest
    a. Brute
        i. Three nested for-loops --> O(nˆ3)
    b. The optimal sort+3pointer approach of 3 sum problem -> O(nlog(n) + nˆ2)