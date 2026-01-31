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

4. **362. Design Hit Counter**
   1. **Brute**
        1. Store hits in an array list and do linear search in getHits call
   2. **List and binary search**
        1. TC: O(log(n)), SC: O(n)
   3. **Deque**
        1. TC: O(n), SC: O(n)
   4. Optimal ???