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

    public static void main(String[] args) {
        int[] ints = {1,11,4};
        Day13 day13 = new Day13();
        day13.exchange(ints);
        System.out.println(Arrays.toString(ints));
    }
}
