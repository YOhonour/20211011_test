package search;

public class Test {
    public int searchInsert(int[] nums, int target) {
        int i=0,j=nums.length-1;
        if (nums[0] > target) return 0;
        if (nums[nums.length-1] < target) return nums.length;
        if (nums[0] == target) return 0;
        if (nums[nums.length-1] == target) return nums.length-1;
        while (i<=j){
            int m = (i+j)/2;
            if (nums[m] == target) {
                return m;
            }else if (target < nums[m]) {
                j = m - 1;
            }else{
                i=m+1;
            }
        }
        return i+1;
    }
}
