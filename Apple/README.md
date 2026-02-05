# Apple Top LC

1. **LC 146. LRU Cache**
    1. **Brute** --> O(1) for get, O(2n) for put, SC: O(ArrayList size)
       1. Use map for cache 
       2. Use ArrayList to store ordered Nodes.
    2. **DLL and MAP** -> O(1) for get and O(1) for put. SC: O(DLL size)
   
2. **LC 1. Two Sum**
    1. **Brute**
        1. Check each pair -> O(n^2)
    2. **Map** -> O(n), O(n)
   
3. **LC 56. Merge Intervals**
   1. **Brute**
       1. ??
   2. **Sort, iterate and merge**
       1. Sort wrt start time, then iterate and merge. -> O(nlog(n) + n + n)

4. **LC 362. Design Hit Counter**
   1. **Brute**
        1. Store hits in an array list and do linear search in getHits call
   2. **List and binary search**
        1. TC: O(log(n)), SC: O(n)
   3. **Deque**
        1. TC: O(n), SC: O(n)
   4. Optimal ???

5. **LC 53. Maximum Subarray**
    1. **Brute**
        1. All subarray and keep track of max -> O(nˆ2), O(1)
    2. **Kadane's algo**
        1. TC: O(n), SC: O(1)

6. **189. Rotate Array**
    1. **Brute**
        1. rotate k times -> O(n*k), O(1)
    2. **Better**
        1. Use extra space to store rotated values and copyback -> TC: O(n), SC: O(n)
    3. **Optimal**
        1. reverse 0..n-1, then reverse 0..k-1, then reverse k..n-1 --> TC: O(~n), SC: O(1)

7. **253. Meeting Rooms II**
    1. **Two arrays - starts and end, sorting**
        1. TC: O(n + nlog(n) + nlog(n) + n), SC: O(n + n)
    2. **Heap** ??
        1. TC: O(nlog(n) + nlog(n)), SC: O(n)

8. **206. Reverse Linked List**
    1. **Iterative**
        1. TC: O(n), SC: O(1)
    2. **Recursive**
        1. TC: O(n), SC: O(1)

9. **347. Top K Frequent Elements**
    1. **Map + TreeMap**
        1. TC: O(nlog(n)), SC: O(n)
    2. **Min Heap**
        1. TC: O(nlog(k)), SC: O(n)

10. **200. Number of Islands**
    1. **BFS/DFS**
        1. TC: O(m*n), SC: O(1)

11. **23. Merge k Sorted Lists**
    1. **Optimal - merge sort** ??
        1. TC: O(N*log(k)) -> N is total num of nodes and K is num of lists, SC: O(1)
    2. **Optimized heap**
        1. TC: O(N*log(k)) -> N is total num of nodes and K is num of lists, SC: O(k)
    3. **Naive heap**
        1. TC: O(N*log(N)) -> N is total num of nodes, SC: O(N)
    4. **Brute force merge 2 lists successively**
        1. TC: O(k*N) -> N is total num of nodes and K is num of lists, SC: O(1)

12. **49. Group Anagrams**
    1. **Optimal - Hashmap**
        1. TC: O(k*n), SC: O(n*k)
    2. **Brute - sort**
        1. TC: O(k*n*log(n)), SC: O(n*k)

13. **125. Valid Palindrome**
    1. **Brute - Stringbuilder**
        1. TC: O(n), SC: O(n)
    2. **Optimal - two pointer**
        1. TC: O(n), SC: O(1)

14. **210. Course Schedule II**
    1. **BFS/Kahn's algo/Toposort**
        1. TC: O(V+E), SC: O(V+E) ??

15. **207. Course Schedule**
    1. **BFS/Kahn's algo/Toposort**
        1. TC: O(V+E), SC: O(V+E) ??

16. **981. Time Based Key-Value Store**
    1. **Brute - linear search**
        1. set - TC: O(1); get - TC: O(k) where k is length of timestamp list for the key.
    2. **Optimal - binary search**
        1. set - TC: O(1); get - TC: O(log(k)) where k is length of timestamp list for the key.

17. **1047. Remove All Adjacent Duplicates In String**
    1. **Optimal - StringBuffer/Stack**
        1. TC: O(N), SC: O(N-D) where D is num of duplicate chars.

18. **20. Valid Parentheses**
    1. **Optimal - Stack**
        1. TC: O(N), SC: O(N)

19. **713. Subarray Product Less Than K**
    1. **Optimal - Sliding Window**
        1. TC: O(N), SC: O(1)
    2. **Brute - Generate all subarrays**
       1. TC: O(nˆ2), SC: O(1)
    3. **Binary search** ??
        1. TC: O(nlog(n)), SC: O(n)

20. **36. Valid Sudoku**
    1. **3 Maps**
        1. TC: O(Nˆ2), SC: O(Nˆ2)
    2. Few more approaches in editorial. ??.

21. **54. Spiral Matrix**
    1. **Simulation**
        1. TC: O(N*M), SC: O(1)

22. **121. Best Time to Buy and Sell Stock**
    1. **Brute - check each pair**
        1. TC: O(Nˆ2), SC: O(1)
    2. **Optimal - check running**
        1. TC: O(N), SC: O(1)
    3. **DP - unnecessary**
        1. TC: O(N), SC: (N) 

23. **122. Best Time to Buy and Sell Stock II**
    1. **Brute**
        1. ??
    2. **Optimal - continuous addition**
        1. TC: O(N), SC: O(1)
    3. **Recursion/DP**
        1. TC: O(N), SC: (N) 

24. **238. Product of Array Except Self**
    1. **Brute - for each multiply the rest**
        1. TC: O(nˆ2), SC: O(1)
    2. **Noob - divide overall pdt by each. Not allowed as per q.**
        1. TC: O(N), SC: O(1)
    3. **Suboptimal - prefix and suffix array**
        1. TC: O(N), SC: O(N)
    4. **Optimal - without extra space**
        1. TC: O(N), SC: (1)

25. **1146. Snapshot Array**
    1. **Brute - simulation, copy entire array on each call**
        1. Map of snapid vs copy of array
        2. TC: O(n*k) {n calls to snap, in each call, copy entire array of size k}, SC: O(n*k)
    2. **Better - Map of snap vs map of index v/s val**
        1. ??
    3. **Optimal - treemap**
        1. TC: O(nlog(n) + k), SC: O(n+k)

26. **26. Remove Duplicates from Sorted Array**
    1. **Brute - Using extra array and set**
        1. Store values in extra array and use set to track duplicate.
        2. TC: O(n), SC: O(2n)
    2. **Better - Same array, two pointers, and set**
        1. TC: O(n), SC: O(n)
    3. **Optimal - two pointers**
        1. TC: O(n), SC: O(1)

27. **3. Longest Substring Without Repeating Characters**
    1. **Brute - Generate all substrings**
        1. TC: O(nˆ2), SC: O(nˆ2)
    2. **Better - suboptimal Sliding window**
        1. TC: O(2n), SC: O(n)
    3. **Optimal - Optimal sliding window**
        1. TC: O(n), SC: O(n)