package com.intprep.tiktok.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@link - https://leetcode.com/problems/queue-reconstruction-by-height/description/
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        //Greedy approach by Sunchit dudeja.
        //There is apparently a solution using segment trees, maybe look for that on next encounter.

        //Intuition for greedy approach -
        //Sort the array in descending order of height.
        //If hieghts are same, sort in ascedind order wrt 2nd index.
        //Then iterate through the sorted array and place each element
        //in a list at an index equal to the second index.
        //The idea is that, once the array is sorted in descending order
        //then for each element of the array will be of height smaller
        //or equal to the elements on its left, and so, even if these
        //elements are now placed at and index in the left region,
        //it wont break the condition for the original element at that
        //index cos its height is less.
        //@see again for refresher -
        //@see - https://www.youtube.com/watch?v=DEWBl549h24&ab_channel=CodingDecoded
        Arrays.sort(people, (a1, a2) -> a1[0]==a2[0] ? a1[1]-a2[1]: a2[0]-a1[0]);
        List<int[]> ans = new ArrayList<>();
        for (int[] p: people) {
            ans.add(p[1], p);
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}
