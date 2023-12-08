package RadiusSubArrayAverages;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] n = {7,4,3,9,1,8,5,2,6};
        System.out.println(Arrays.toString(getAverages2(n, 3)));

    }
    public static int [] getAverages(int[] nums, int k){
        // When a single element is considered then its average will be the number itself only;
        if(k == 0){
            return nums;
        }
        int n = nums.length;
        int [] averages = new int[n];
        Arrays.fill(averages, -1);
        // Any index will not have 'k' elements in it's left and right.
        if(2 * k + 1 > n){
            return averages;
        }
        // Generate 'prefix' array for 'nums'.
        // 'prefix[i + 1]' will be sum of all elements of 'nums' from index '0' to 'i'.
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        // We iterate only on those indices which have at least 'k' elements in their left and right.
        // i.e. indices from 'k' to 'n - k'
        for(int i = k; i < (n - k); ++i){
            int leftBound = i - k, rightBound = i + k;
            long subArraySum = prefix[rightBound + 1] - prefix[leftBound];
            int average = (int) (subArraySum / (2 * k + 1));
            averages[i] = average;
        }
        // Time complexity: O(n)
        // Space complexity: O(n)

        return averages;

    }
    public static int [] getAverages2(int[] nums, int k){
        // hen a single element is considered then its average will be the number itself only.

        if(k == 0){
            return nums;
        }
        int n = nums.length;
        int[] averages = new  int[n];
        Arrays.fill(averages, -1);

        // Any index will not have 'k' elements in its left and right.
        if(2 * k + 1 > n){
            return averages;
        }
        //First get the sum of first window of the 'nums' array.
        long windowSum = 0;
        for (int i = 0; i < (2 * k + 1); i++) {
            windowSum += nums[i];
        }
        averages[k] = (int) (windowSum/(2 * k + 1));

        // Iterate on rest indices which have at least 'k' elements
        // on its left and right sides.
        for (int i = (2 * k + 1); i < n; i++) {
            // We remove the discarded element and add the new element to get current window sum.
            // 'i' is the index of new inserted element, and
            // 'i - (window size)' is the index of the last removed element.
            windowSum = windowSum - nums[i - (2 * k + 1)] + nums[i];
            averages[i - k] = (int) (windowSum / (2 * k + 1));
        }
        return averages;
        // Time complexity: O(n)
        // Space complexity: O(1)
    }
}
