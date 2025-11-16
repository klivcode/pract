public class SolutionLargestInteger {

    public int findMaxK() {
        int[] nums = new int[10];
            int ans1=0;
        for(int i=0; i<nums.length; i++){

            if(nums[i]>nums[i+1]){
                 ans1=nums[i];
            }
            else{
                 ans1=nums[i];
            }

        }
        return ans1;
    }
}
