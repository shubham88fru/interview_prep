package com.intprep.tiktok.medium;

import java.util.*;

//@link - https://leetcode.com/problems/3sum/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // return threeSumBetter(nums);
        return threeSumOptimal(nums);

        //Works but gives TLE.
        /**
         Arrays.sort(nums);
         List<List<Integer>> triplets = new ArrayList<>();
         revise(nums, 0, 0, new ArrayList<>(), triplets);
         Set<String> st = new HashSet<>();
         List<List<Integer>> ans = new ArrayList<>();
         for (List<Integer> triplet: triplets) {
             // Collections.sort(triplet);
             String joined = triplet.get(0) + "_" + triplet.get(1) + "_" + triplet.get(2);
             if (!st.contains(joined)) {
                 ans.add(triplet);
                 st.add(joined);
             }
         }
         return ans;
         */
    }


    //backtracking Works but gives TLE.
    private void revise(int[] nums, int curr, int sum, List<Integer> triplet, List<List<Integer>> triplets) {
        if (sum == 0 && triplet.size() == 3) {
            triplets.add(new ArrayList<>(triplet));
            return;
        }
        if (curr >= nums.length) return;

        if (triplet.size() < 3) {
            triplet.add(nums[curr]);
            revise(nums, curr+1, sum+nums[curr], triplet, triplets);
            triplet.remove(triplet.size()-1);
        }

        revise(nums, curr+1, sum, triplet, triplets);

    }

    //1) Optimal soln - T: O(NlogN+N^2), S: O(1)
    //Using 3 pointers approach.
    private List<List<Integer>> threeSumOptimal(int[] nums) {
        /**
         Note We're sorting the og array in this approach
         and so able to follow the 3 pointer approach.
         */
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i=0; i<nums.length;i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while (j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum>0) {
                    k--;
                } else if (sum<0) {
                    j++;
                } else {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[i]);
                    lst.add(nums[j]);
                    lst.add(nums[k]);

                    ans.add(lst);
                    k--;
                    j++;
                    while (j < k && nums[k] == nums[k+1]) k--;
                    while (j<k && nums[j] == nums[j-1]) j++;
                }
            }
        }

        return ans;
    }

    //2) Better soln - T: O(N^2), S: O(N)
    //instead of searching the array for the third element,
    //find the third which is -(first+second) using hash
    private List<List<Integer>> threeSumBetter(int[] nums) {

        List<List<Integer>> ans = new  ArrayList<>();
        Set<String> triplets = new HashSet<>();
        for (int i = 0; i<nums.length; i++) {
            int first = nums[i];
            Set<Integer> seen = new HashSet<>(); //for new iteration, empty the seen set.

            for (int j=i+1; j < nums.length; j++) {
                int second = nums[j];
                int third = -(first+second);
                if (seen.contains(third)) {
                    //Note, og array is not  sorted in this approach
                    //so need separately handle cases that may result
                    //in duplicates.
                    int[] arr = new int[]{first, second, third};
                    Arrays.sort(arr);
                    String joined = arr[0] + "_" + arr[1] + "_" + arr[2];

                    if (!triplets.contains(joined)) {
                        List<Integer> lst = new ArrayList<>();
                        lst.add(arr[0]);
                        lst.add(arr[1]);
                        lst.add(arr[2]);

                        ans.add(lst);
                        triplets.add(joined);
                    }
                }


                seen.add(second);
            }
        }

        return ans;
    }

    //3) Brute force - T: O(N^3), S: O(N)
    //Generate all triplets using 3 for loops
    //and its a valid triplet if sum is 0.
    //will have to ensure using set/map and sorting
    //that we are not storing duplicates.
}
