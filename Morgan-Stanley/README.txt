# MS Top LC

1. LC 49. Group anagrams
    i. brute - sort each string and map
        a. TC: O(n*klog(k)), SC: O(n), where n is num of string and k is length of max string.
    a. Hashmap and freq array --> O(n*k)

2. LC 54. Spiral Matrix
    1. Simulation
        1. TC: O(N*M), SC: O(1)

3. LC 198. House Robber
    1. Recursion + memo
        1. TC: O(N), SC: O(N)

4. LC 19. Remove Nth Node From End of List
    1. Brute - Two pass
        i. TC: O(n), SC: O(1)
    2. Extra space - put in array list
        i. TC: O(n), SC: O(n)
    3. Optimal - Two pointer
        i. TC: O(n), SC: O(1)

5. LC 143. Reorder List
    1. Optimal - half, reverse, merge
        i. TC: O(n), SC: O(1)

6. LC 141. Linked List Cycle
    1. Brute - hashset
        i. TC: O(n), SC: O(n)
    2. Optimal - f and s pointers, and tortoise and hare algo.
        i. TC: O(n), SC: O(1)

7. LC 142. Linked List Cycle II
    1. Brute - hashset
        i. TC: O(n), SC: O(n)
    2. Optimal - f and s pointers, and tortoise and hare algo.
        i. TC: O(n), SC: O(1)

8. LC 387. First Unique Character in a String
    1. Brute - for each compare with rest
        i. TC: O(nˆ2), SC: O(1)
    2. Optimal - freq aray and 2 pass.
        i. TC: O(n), SC: O(1)