import java.util.Arrays;

/*

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.



Constraints:

    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106




 */









public class SolutionMedainSorted {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged= new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,merged,0,nums1.length);
        System.arraycopy(nums2,0,merged,nums1.length,nums2.length);
        Arrays.sort(merged);
        int sum = 0;
        int n= merged.length;
        double median =0.0D;
        if(merged.length%2==0)
        {
           int nthTerm= merged[n/2-1];
           int nthPlus1Term=merged[n/2];

           // Even number of length  the formula for the median is = (n+1)th item/2 gives the decimal value so we need
            // to add the nth term + nth+1 term diveded by 2 then the respective value is the medain

            median= (double) (nthTerm + nthPlus1Term) /2;
        }

        // However in the odd lenght the + 1 makes the even and exactly divided by the 2 so the no decimal value is get
        // the respective is outcome form the sorted array .

        // for the odd length and +1

        int exactIndex= (n+1)/2;
        median= merged[exactIndex];

        return median;
    }



}
