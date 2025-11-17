public class SolutionLargestInteger {

    public int findMaxK(  int[] nums) {
        int greater=-1;
       for(int i=0; i<nums.length; i++){
           if(nums[i]>0)
           {
            for(int j=0; j<nums.length; j++){

                if(nums[j]== - nums[i])
                {
                    if(nums[i]>greater)
                    {
                        greater=nums[i];
                    }
                }
            }

           }
       }
       return greater;
    }


    public static void main(String[] args) {
        SolutionLargestInteger sol = new SolutionLargestInteger();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,-9 ,10 ,-10};
        System.out.println(sol.findMaxK(nums));
    }
}
