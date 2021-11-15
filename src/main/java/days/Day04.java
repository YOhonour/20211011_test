package days;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day04 {
    //数组中重复的数字
    //哈希集合实现
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int a : nums){
            if (set.contains(a)){
                return a;
            }else {
                set.add(a);
            }
        }
        return 0;
    }
    //原地交换
    public int findRepeatNumber2(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++){
            if (i == nums[i]){
                continue;
            }else if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }else {
                temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
                i--;
                //关键点是只有 nums[i] == i 的时候i才递增，这样保证找到相同元素前不会漏掉某些元素的处理
            }
        }
        return -1;
    }


    /*
    剑指 Offer 53 - I. 在排序数组中查找数字 I
    统计一个数字在排序数组中出现的次数。
     */
    //暴力哈希法
    public int search(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int a : nums){
            if (map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else {
                map.put(a,1);
            }
        }
        return map.containsKey(target) ? map.get(target) : 0;
    }
    //二分法
    public int search2(int[] nums, int target) {
        /*
        寻找第一个小于target的下标 为left
        再找第一个大于target的下标 为right
         所以出现的个数为right- left -1
         */
        int right,left;
        int i = 0, j = nums.length - 1,m;
        while(i <= j) {
            m = (i + j) / 2;
            if(nums[m] <= target)
                i = m + 1;
            else j = m - 1;
        }
        left = i;
        if(j >= 0 && nums[j] != target) return 0;
        i = 0;
        j = nums.length - 1;
        while(i <= j) {
            m = (i + j) / 2;
            if(nums[m] > target)
                i = m + 1;
            else j = m - 1;
        }
        right = j;

        return  right-left-1;
    }

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length ;i++){
            if (i != nums[i]){
                return i;
            }
        }
        return nums.length;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 2, 0, 0, 1};
        System.out.printf(new Day04().findRepeatNumber2(nums)+"");
    }

}
