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

6. LC 1475. Final Prices With a Special Discount in a Shop
      a. Brute
        i. For each, check the first smaller on right -> O(nˆ2)
      b. Stack
        i. Left to right or vice versa, using stack. -> O(n)

7. LC 33. Search in rotated sorted array.
     a. Brute
        i. Linear search -> O(n)
     b. Modified Binary search -> O(log(n))

8. LC 75. Sort colors
    a. Brute
        i. Sort -> O(nlog(n))
    b. 3 pass
        i. Manually sort (using single for loop) each code (0, 1, 2) one by one. -> O(3N)
    c. 2 pass
        i. Iterate and store freq of 0, 1, and 2. Then Iterated and replace each el in array --> O(2N)
    d. Dutch National Flag algo, 1 Pass
        i. [0..low-1] --> 0
           [low..mid-1] --> 1
           [mid..high] --> unsorted
           [high+1..n-1] --> 2

10. LC 9. Palindrome number
    a. Brute
        i. Convert the number to string, reverse and then compare. -> O(n), O(n)
    b. Math reverse using % and / -> O(log(n)) where its log to base 10
    c. Optimal
        i. Same as b. but with early return. Only do till og x is > rev, see lc editorial.

11. LC 21. Merge two sorted lists
    a. Brute
        i. Store nodes in arraylist, sort array list and then link -> O(n+m + (n+m)log(n+m) + n + m), O(n+m)
    b. Merge using third LL --> O(n+m), O(n+m)
    c. Inplace merge -> O(n+m), O(1)

12. LC 101. Symmetric tree
    a. DFS -> O(n)

13. LC 138. Copy List with Random Pointer
    a. HashMap -> O(n)



15. LC 49. Group anagrams
    a. Hashmap and freq array --> O(n*k)

16. LC 56. Merge intervals
    a. Sort and loop ->  O(nlog(n) + n + n)

17. LC 73. Set Matrix Zeroes
    a. Brute
        i. Using a separate copy matrix --> O(m*n), O(m*n)
    b. Two arrays/set to track rows/cols
        i. Use 2 arrays/sets to track the rows and cols that
           that need to be zero. --> O(m*n), O(m+n)
    c. Space efficient soln
        i. use first row and col to track which rows/cols
           need to marked zero --> O(m*n), O(1)

18. LC 93. Restore IP Addresses
    a. Backtracking
      i. Standard backtracking template --> O(MˆN) ???????

19. LC 242. Valid anagram
    a. 26 len array -> O(n)
    b. hashmap (if lets say the string contains special chars/unicode) -> O(n), O(n)

20. LC 424. Longest repeating character replacement.
    a. Brute
        i. generate all subs, in each sub, replace each char with a char of sub and see if
            it can be done within k replacement to make all chars same --> O(nˆ2 +..)
        ii. Sliding window -> O(n)

23. LC 16. 3 Sum closest
    a. Brute
        i. Three nested for-loops --> O(nˆ3)
    b. The optimal sort+3pointer approach of 3 sum problem -> O(nlog(n) + nˆ2)