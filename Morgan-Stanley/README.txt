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