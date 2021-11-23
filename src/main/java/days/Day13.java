package days;

import java.util.Arrays;

public class Day13 {
    public int[] exchange(int[] nums) {
        if (nums.length <= 1) return nums;
        int letf = 0,right = nums.length-1;
        while (letf < right-1){
                //找到左边第一个偶数
                while (letf < right && (nums[letf]%2 == 1) && letf < nums.length-1)
                    letf++;
                //找到右边第一个奇数
                while (letf < right && (nums[right]%2 == 0) && right>1)
                    right--;
                //执行交换
                if (letf==nums.length-1 || right==0) break;
                //执行交换
                int temp = nums[letf];
                nums[letf] = nums[right];
                nums[right] = temp;
        }
        return nums;
    }
    public int[] exchange2(int[] nums) {
        if (nums.length <= 1) return nums;
        int letf = 0,right = nums.length-1;
        int temp = 0;
        while (letf < right){
            while (letf < right && (nums[letf]%2 == 1)) letf++;
            while (letf < right && (nums[right]%2 == 0)) right--;
            if (letf==nums.length-1 || right==0) break;
            temp = nums[letf];
            nums[letf] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
    //二分查找
    public Integer find(int[] nums, int target){
        int i = 0;
        int j = nums.length-1;
        while (i<j){
            int m = (i+j)/2;
            if (target == nums[m]) return nums[m];
            if (target > nums[m]) i = m+1;
            if (target < nums[m]) j = m-1;
        }
        if(target == nums[i]) return nums[i];
        return null;
    }
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            result[0] = nums[i];
            result[1] = target - nums[i];
            if (find(nums,result[1]) != null)
                return result;
        }
        return null;
    }
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = nums.length-1;
        int temp = 0;
        while (i<j){
            temp = nums[i]+nums[j];
            if (target == temp) return new int[]{nums[i],nums[j]};
            if (target > temp) i = i+1;
            if (target < temp) j = j-1;
        }
        return null;
    }
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        s = s.trim();
        if (s.equals("")) return "";
        int i = s.length()-1;
        int j = i;
        while (i>=0){
            while (i >= 0 && s.charAt(i) != ' ' ) i--;
            //此时 i 在从右往左第一个空格处
            builder.append(s.subSequence(i+1,j+1));
            builder.append(" ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }

        return builder.toString().trim();
    }
    public static void main(String[] args) {
        int[] ints = {2,7,11,15};
        Day13 day13 = new Day13();
//        day13.exchange2(ints);
//        System.out.println(Arrays.toString(ints));
//        System.out.println(Arrays.toString(day13.twoSum2(ints,9)));
        String s = "a good   example";
        System.out.println(day13.reverseWords(s));
    }
}
