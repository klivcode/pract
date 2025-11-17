public class SolutionLargestInteger {

    public int findMaxK(  int[] nums) {
        int greater=-1;
       for(int i=0; i<nums.length; i++){
           if(nums[i]>0)
           {


           }
           return -1;
       }
       return greater;
    }


    public static void main(String[] args) {
        SolutionLargestInteger sol = new SolutionLargestInteger();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,-9};
        System.out.println(sol.findMaxK(nums));
    }
}
